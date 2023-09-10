package com.irembo.ride.trip.configuration.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfiguration {

    @Bean
    public KafkaAdmin.NewTopics topic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("driverLocations")
                .partitions(10)
                .replicas(1)
                .build()
        );
    }

    @KafkaListener(id = "listen1", topics = "driverLocations")
    public void listen1(String in) {
        System.out.println("message in "+in);
    }

}
