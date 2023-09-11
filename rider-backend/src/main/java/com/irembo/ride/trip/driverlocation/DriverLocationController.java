package com.irembo.ride.trip.driverlocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/driverLocation")
public class DriverLocationController {

    @Autowired
    private DriverLocationService service;
}
