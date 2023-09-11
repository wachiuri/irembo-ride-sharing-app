package com.irembo.ride.driver.configuration.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irembo.ride.driver.configuration.websocket.ApplicationWebSocketHandler;
import com.irembo.ride.driver.rider.DriverMatch;
import com.irembo.ride.driver.websocket.WebsocketMessage;
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

    @Bean
    public KafkaAdmin.NewTopics topic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("driverLocations")
                        .partitions(10)
                        .replicas(1)
                        .build(),
                TopicBuilder.name("driverMatch")
                        .partitions(1)
                        .replicas(1)
                        .build()
        );
    }

    @KafkaListener(id = "listenDriverMatch", topics = "driverMatch")
    public void listenDriverMatch(String in) {
        try {
            log.trace("driverMatch kafka topic received {}", in);
            ObjectMapper objectMapper = new ObjectMapper();
            WebsocketMessage websocketMessage = new ObjectMapper().readValue(in, WebsocketMessage.class);
            DriverMatch driverMatch = objectMapper.convertValue(websocketMessage.getData(), DriverMatch.class);
            applicationWebSocketHandler.write(driverMatch.getDriverLocation().getUser().getId(), in);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
