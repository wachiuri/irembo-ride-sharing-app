package com.irembo.ride.driver.driverlocation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uber.h3core.H3Core;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.HashMap;
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

    public DriverLocation update(DriverLocation driverLocation) {

        try {
            H3Core h3Core = H3Core.newInstance();
            driverLocation.setCellAddress(h3Core.latLngToCellAddress(driverLocation.getLat(), driverLocation.getLng(), 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        driverLocations.put(driverLocation.getUser().getId(), driverLocation);

        try {
            kafkaTemplate.send("driverLocations", objectMapper.writeValueAsString(driverLocation));
        } catch (JsonProcessingException e) {
            log.error("error writing json body", e);
            throw new RuntimeException(e);
        }

        return driverLocation;
    }
}
