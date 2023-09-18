package com.irembo.ride.driver.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.irembo.ride.driver.configuration.websocket.ApplicationWebSocketHandler;
import com.irembo.ride.driver.driverlocation.DriverLocationService;
import com.irembo.ride.driver.rider.DriverMatch;
import com.irembo.ride.driver.websocket.WebsocketMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RequestService {

    @Autowired
    private DriverLocationService driverLocationService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ApplicationWebSocketHandler webSocketHandler;

    public Mono<DriverMatch> accept(DriverMatch driverMatch) {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        return Mono.just(driverMatch)
                .map(a -> {
                            try {
                                kafkaTemplate.send("driverMatch", objectMapper.writeValueAsString(
                                        new WebsocketMessage("driverMatch", driverMatch)));
                            } catch (JsonProcessingException e) {
                                throw new RuntimeException(e);
                            }
                            return a;
                        }
                )
                ;
    }

    public Mono<DriverMatch> reject(DriverMatch driverMatch) {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        return Mono.just(driverMatch)
                .map(a -> {
                            try {
                                kafkaTemplate.send("driverMatch", objectMapper.writeValueAsString(
                                        new WebsocketMessage("driverMatch", driverMatch)));
                            } catch (JsonProcessingException e) {
                                throw new RuntimeException(e);
                            }
                            return a;
                        }
                )
                ;
    }
}
