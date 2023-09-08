package com.irembo.ride.trip.request;

import com.irembo.ride.trip.driverlocation.DriverLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService service;

    @PostMapping
    public Mono<DriverLocation> request(@RequestBody Request request) {
        return service.request(request);
    }

    @GetMapping
    public Flux<Request> list() {
        return Flux.fromArray(service.list().toArray(new Request[0]));
    }

    @PostMapping("/accept")
    public Mono<Request> accept(Request request) {
        return service.accept(request);
    }

    public void listen(){

    }
}
