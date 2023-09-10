package com.irembo.ride.driveronboarding.driver;

import com.irembo.ride.driveronboarding.base.BaseController;
import com.irembo.ride.driveronboarding.lib.ResponseObject;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/driver")
public class DriverController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DriverService service;

    //@PreAuthorize("hasAuthority('View Driver')")
    @GetMapping
    public Mono<Page<Driver>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int pageIndex,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return service.findAll(pageIndex, size);
    }

    @PreAuthorize("hasAuthority('View Driver')")
    @GetMapping("/{id}")
    public Mono<Driver> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PreAuthorize("hasAuthority('Delete Driver')")
    @DeleteMapping("/{id}")
    public Mono<ResponseObject> deleteById(@PathVariable("id") Long id) {
        logger.debug("id {}", id);
        return service.deleteById(id)
                .then(Mono.just(new ResponseObject(200, "Driver deleted")));
    }

    @PreAuthorize("hasAuthority('Update Driver')")
    @PostMapping
    public Mono<Driver> save(@RequestBody @Valid Driver driver) {
        return service.save(driver);
    }
}
