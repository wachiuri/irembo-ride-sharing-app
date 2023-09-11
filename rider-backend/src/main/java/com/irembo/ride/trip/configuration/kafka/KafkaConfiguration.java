package com.irembo.ride.trip.configuration.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irembo.ride.trip.configuration.websocket.ApplicationWebSocketHandler;
import com.irembo.ride.trip.driverlocation.DriverLocation;
import com.irembo.ride.trip.driverlocation.DriverLocationService;
import com.irembo.ride.trip.websocket.WebsocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.LinkedHashMap;

@Configuration
public class KafkaConfiguration {

    @Autowired
    private ApplicationWebSocketHandler applicationWebSocketHandler;

    @Autowired
    private DriverLocationService driverLocationService;

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
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            WebsocketMessage websocketMessage = objectMapper.readValue(in, WebsocketMessage.class);

            DriverLocation driverLocation = objectMapper.convertValue(websocketMessage.getData(), DriverLocation.class);
            applicationWebSocketHandler.write(driverLocation.getUser().getId(), in);

            driverLocationService.getDriverLocations()
                    .put(driverLocation.getUser().getId(), driverLocation);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
