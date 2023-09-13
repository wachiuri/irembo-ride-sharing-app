package com.irembo.ride.driver.rider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/driverMatch")
public class DriverMatchController {

    @Autowired
    private DriverMatchService service;

    @PostMapping("/accept")
    public Mono<DriverMatch> accept(@RequestBody DriverMatch driverMatch){
        return service.accept(driverMatch);
    }

    @PostMapping("/reject")
    public Mono<DriverMatch> reject(@RequestBody DriverMatch driverMatch){
        return service.reject(driverMatch);
    }
}
