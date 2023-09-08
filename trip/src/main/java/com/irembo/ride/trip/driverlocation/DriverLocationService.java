package com.irembo.ride.trip.driverlocation;

import com.irembo.ride.trip.driver.Driver;
import com.irembo.ride.trip.user.User;
import com.uber.h3core.H3Core;
import jakarta.annotation.PostConstruct;
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
public class DriverLocationService {

    private final Map<Long, DriverLocation> driverLocations = new HashMap<>();

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

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

        driverLocations.put(driverLocation.getUser().getId(), driverLocation);
        kafkaTemplate.send("driverLocations", driverLocation);
        return driverLocation;
    }
}
