package com.irembo.ride.trip.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.irembo.ride.trip.configuration.websocket.ApplicationWebSocketHandler;
import com.irembo.ride.trip.driverlocation.DriverLocation;
import com.irembo.ride.trip.websocket.WebsocketMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping
    public Flux<Request> list() {
        return Flux.fromArray(service.list().toArray(new Request[0]));
    }

    @PostMapping("/accept")
    public Mono<Request> accept(Request request) {
        return service.accept(request);
    }

    public void listen() {

    }
}
