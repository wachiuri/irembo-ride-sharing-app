package com.irembo.ride.trip.driverlocation;

import com.irembo.ride.trip.driver.Driver;
import com.irembo.ride.trip.user.User;
import com.uber.h3core.H3Core;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverLocationService {

    private final List<DriverLocation> driverLocations = new ArrayList<>();

    public Flux<DriverLocation> list() {
        return Flux.fromIterable(driverLocations);
    }

    public DriverLocation update(DriverLocation driverLocation) {
        driverLocations.add(driverLocation);
        return driverLocation;
    }
}
