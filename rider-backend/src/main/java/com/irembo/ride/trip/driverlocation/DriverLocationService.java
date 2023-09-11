package com.irembo.ride.trip.driverlocation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irembo.ride.trip.driver.Driver;
import com.irembo.ride.trip.user.User;
import com.uber.h3core.H3Core;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DriverLocationService {

    private final Map<Long, DriverLocation> driverLocations = new HashMap<>();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Flux<Map<Long, DriverLocation>> list() {
        return Flux.just(driverLocations);
    }

    public Map<Long, DriverLocation> getDriverLocations() {
        return driverLocations;
    }


}
