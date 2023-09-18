package com.irembo.ride.trip.configuration.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.irembo.ride.trip.configuration.websocket.ApplicationWebSocketHandler;
import com.irembo.ride.trip.driverlocation.DriverLocation;
import com.irembo.ride.trip.driverlocation.DriverLocationService;
import com.irembo.ride.trip.request.DriverMatch;
import com.irembo.ride.trip.request.DriverMatchStage;
import com.irembo.ride.trip.request.DriverNotFoundException;
import com.irembo.ride.trip.request.RequestService;
import com.irembo.ride.trip.websocket.WebsocketMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
@Slf4j
public class KafkaConfiguration {

    @Autowired
    private ApplicationWebSocketHandler applicationWebSocketHandler;

    @Autowired
    private DriverLocationService driverLocationService;

    @Autowired
    private RequestService requestService;

    @Bean
    public KafkaAdmin.NewTopics topic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("driverLocations")
                        .partitions(1)
                        .replicas(1)
                        .build(),
                TopicBuilder.name("driverMatch")
                        .partitions(1)
                        .replicas(1)
                        .build()
        );
    }

    @KafkaListener(id = "listenDriverLocations", topics = "driverLocations")
    public void driverLocations(String in) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            WebsocketMessage websocketMessage = objectMapper.readValue(in, WebsocketMessage.class);

            DriverLocation driverLocation = objectMapper.convertValue(websocketMessage.getData(), DriverLocation.class);
            applicationWebSocketHandler.write(in);

            driverLocationService.getDriverLocations()
                    .put(driverLocation.getUser().getId(), driverLocation);

        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException", e);
            throw new RuntimeException(e);
        }

    }

    @KafkaListener(id = "driverMatch", topics = "driverMatch")
    public void driverMatch(String in) {

        log.trace("driverMatch kafka received message {}", in);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            WebsocketMessage websocketMessage = objectMapper.readValue(in, WebsocketMessage.class);

            DriverMatch driverMatch = objectMapper.convertValue(websocketMessage.getData(), DriverMatch.class);

            if (driverMatch.getStage().equals(DriverMatchStage.ACCEPT) || driverMatch.getStage().equals(DriverMatchStage.REJECT)) {

//                applicationWebSocketHandler.write(in);
                applicationWebSocketHandler.write(in, driverMatch.getRequest().getUser().getRider().getId());

                if (driverMatch.getStage().equals(DriverMatchStage.REJECT)) {
                    log.trace("driverMatch is reject");
                    requestService.rejected(driverMatch.getRequest().getId(), driverMatch.getDriverLocation());

                    requestService.match(driverMatch.getRequest())
                            .doOnError(DriverNotFoundException.class, driverNotFoundException -> {
                                log.error("error", driverNotFoundException);
                                driverMatch.setStage(DriverMatchStage.DRIVER_NOT_FOUND);
                                try {
                                    applicationWebSocketHandler.write(
                                            objectMapper.writeValueAsString(
                                                    new WebsocketMessage("driverMatch", driverMatch)
                                            ),
                                            driverMatch.getRequest().getUser().getRider().getId()
                                    );
                                } catch (JsonProcessingException e) {
                                    log.error("JsonProcessingException", e);
                                }
                            })
                            .subscribe(driverMatch1 -> log.trace("driverMatch {}", driverMatch1));
                    ;
                }

            }

        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException", e);
            throw new RuntimeException(e);
        }

    }

}
