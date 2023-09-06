package com.irembo.ride.trip.driverlocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/driverLocation")
public class DriverLocationController {

    @Autowired
    private DriverLocationService service;

    @GetMapping
    public Flux<DriverLocation> list() {
        return service.list();
    }

    @PutMapping
    public DriverLocation update(@RequestBody DriverLocation driverLocation) {
        return service.update(driverLocation);
    }
}
