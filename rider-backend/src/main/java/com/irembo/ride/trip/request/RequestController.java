package com.irembo.ride.trip.request;

import com.irembo.ride.trip.driverlocation.DriverLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/request")
@Slf4j
public class RequestController {

    @Autowired
    private RequestService service;

    @PostMapping
    public Mono<DriverLocation> request(@RequestBody Request request) {
       return service.match(request);
    }

}
