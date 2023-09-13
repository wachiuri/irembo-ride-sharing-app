package com.irembo.ride.driver.rider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.irembo.ride.driver.configuration.websocket.ApplicationWebSocketHandler;
import com.irembo.ride.driver.websocket.WebsocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DriverMatchService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ApplicationWebSocketHandler webSocketHandler;

    public Mono<DriverMatch> accept(DriverMatch driverMatch) {

        driverMatch.setStage(DriverMatchStage.ACCEPT);

        send(driverMatch);

        return Mono.just(driverMatch);

    }

    public Mono<DriverMatch> reject(DriverMatch driverMatch) {

        driverMatch.setStage(DriverMatchStage.REJECT);
        send(driverMatch);
        return Mono.just(driverMatch);
    }

    private void send(DriverMatch driverMatch) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            String message = objectMapper
                    .writeValueAsString(
                            new WebsocketMessage(
                                    "driverMatch",
                                    driverMatch
                            )
                    );
            kafkaTemplate.send("driverMatch", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
