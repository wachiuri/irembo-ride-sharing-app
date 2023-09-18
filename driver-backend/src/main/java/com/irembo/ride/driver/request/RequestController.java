package com.irembo.ride.driver.request;

import com.irembo.ride.driver.rider.DriverMatch;
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

    @PostMapping("/accept")
    public Mono<DriverMatch> accept(@RequestBody DriverMatch driverMatch) {
        log.trace("accept message {}", driverMatch);
        return service.accept(driverMatch);
    }

    @PostMapping("/reject")
    public Mono<DriverMatch> reject(@RequestBody DriverMatch driverMatch) {
        log.trace("reject message {}", driverMatch);
        return service.reject(driverMatch);
    }
}
