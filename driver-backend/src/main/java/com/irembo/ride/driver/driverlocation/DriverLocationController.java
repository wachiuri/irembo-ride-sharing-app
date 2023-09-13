package com.irembo.ride.driver.driverlocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/driverLocation")
public class DriverLocationController {

    @Autowired
    private DriverLocationService service;

    @GetMapping
    public Flux<DriverLocation> list() {
        return service.getDriverLocations().flatMap(a -> Flux.fromIterable(a.values()));
    }

    @PutMapping
    public DriverLocation update(@RequestBody DriverLocation driverLocation) {
        return service.update(driverLocation);
    }

    @PostMapping("/generate")
    public Mono<Void> generate(){
        return service.generate();
    }
}
