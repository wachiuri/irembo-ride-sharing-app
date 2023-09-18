package com.irembo.ride.trip.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.irembo.ride.trip.configuration.websocket.ApplicationWebSocketHandler;
import com.irembo.ride.trip.driverlocation.DriverLocation;
import com.irembo.ride.trip.driverlocation.DriverLocationService;
import com.irembo.ride.trip.websocket.WebsocketMessage;
import com.uber.h3core.H3Core;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RequestService {

    @Autowired
    private DriverLocationService driverLocationService;

    @Autowired
    private ApplicationWebSocketHandler applicationWebSocketHandler;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ApplicationWebSocketHandler webSocketHandler;

    private final Map<String, List<DriverLocation>> rejected = new HashMap<>();

    public void rejected(String requestId, DriverLocation driverLocation) {
        rejected.computeIfAbsent(requestId, k -> new ArrayList<>()).add(driverLocation);
    }

    public Mono<DriverLocation> match(Request request) {
        return this.request(request)

                .map(matched -> {

                    log.trace("matcher {}", matched);
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.registerModule(new JavaTimeModule());

                    try {
                        String message = objectMapper.writeValueAsString(new WebsocketMessage("driverMatch", new DriverMatch(DriverMatchStage.MATCH, request, matched)));

                        kafkaTemplate.send("driverMatch", message);

                        //send matching status to rider
                        DriverMatch driverMatch = new DriverMatch(DriverMatchStage.MATCH, request, matched);
                        String riderMessage = objectMapper.writeValueAsString(new WebsocketMessage("driverMatch", driverMatch));
//                        webSocketHandler.write(riderMessage);
                        webSocketHandler.write(riderMessage, request.getUser().getRider().getId());
                    } catch (JsonProcessingException e) {
                        log.error("error writing json object ", e);
                        //throw new RuntimeException(e);
                    }

                    return matched;

                });
    }

    public Mono<DriverLocation> request(Request request) {

        if (rejected.containsKey(request.getId()) && rejected.get(request.getId()).size() >= 5) {
            return Mono.error(new DriverNotFoundException("Driver not found"));
        }

        try {

            H3Core h3Core = H3Core.newInstance();

            String address = h3Core.latLngToCellAddress(request.getDepartureLatitude(), request.getDepartureLongitude(), 1);

            log.trace("address {}", address);
            Flux<DriverLocation> drivers = driverLocationService.list().flatMap(d -> Flux.fromIterable(d.values()));
            return drivers
                    .filter(d -> !(rejected.containsKey(request.getId()) && rejected.get(request.getId()).contains(d)))
                    .filter(d -> {
                        log.trace("d {}", d);
                        return d.getCellAddress().equals(address);
                    })
                    .switchIfEmpty(
                            drivers.filter(d -> {
                                List<List<String>> inVicinity1 = h3Core.gridDiskDistances(address, 1);

                                log.trace("vicinity1 {}", inVicinity1);

                                return inVicinity1.stream().anyMatch(inVicinityList -> inVicinityList.contains(d.getCellAddress()));
                            })
                    )
                    .switchIfEmpty(
                            drivers.filter(d -> {
                                List<String> inVicinity2 = h3Core.gridDisk(address, 2);

                                log.trace("vicinity2 {}", inVicinity2);
                                return inVicinity2.contains(d.getCellAddress());
                            })
                    )
                    .switchIfEmpty(
                            drivers.filter(d -> {
                                List<String> inVicinity3 = h3Core.gridDisk(address, 3);

                                log.trace("vicinity3 {}", inVicinity3);
                                return inVicinity3.contains(d.getCellAddress());
                            })
                    )
                    .switchIfEmpty(
                            drivers.filter(d -> {
                                List<String> inVicinity4 = h3Core.gridDisk(address, 4);

                                log.trace("vicinity4 {}", inVicinity4);
                                return inVicinity4.contains(d.getCellAddress());
                            })
                    )
                    .switchIfEmpty(
                            drivers.filter(d -> {
                                List<String> inVicinity5 = h3Core.gridDisk(address, 5);

                                log.trace("vicinity5 {}", inVicinity5);
                                return inVicinity5.contains(d.getCellAddress());
                            })
                    )
                    .reduce((d1, d2) -> {
                                log.trace("reduce d1 {} d2 {}", d1, d2);
                                DriverLocation matched = this.shortestDistance(request, d1, d2);

                                return matched;
                            }
                    )
                    ;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DriverLocation shortestDistance(Request request, DriverLocation d1, DriverLocation d2) {
        double distance1 = distance(
                request.getDepartureLatitude(),
                request.getDepartureLongitude(),
                d1.getLat(),
                d1.getLng()
        );
        double distance2 = distance(request.getDepartureLatitude(), request.getDepartureLongitude(),
                d2.getLat(), d2.getLng());
        return distance1 < distance2 ? d1 : d2;
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 1.609344 * 1000;
        return (dist); // 134910.69784909734
    }

    /* The function to convert decimal into radians */
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /* The function to convert radians into decimal */
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
