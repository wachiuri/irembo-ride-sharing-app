package com.irembo.ride.driveronboarding.rider;

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
public class RiderController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RiderService service;

    @PreAuthorize("hasAuthority('View Customer')")
    @GetMapping
    public Mono<Page<Rider>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int pageIndex,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return service.findAll(pageIndex, size);
    }

    @PreAuthorize("hasAuthority('View Customer')")
    @GetMapping("/{id}")
    public Mono<Rider> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PreAuthorize("hasAuthority('Delete Customer')")
    @DeleteMapping("/{id}")
    public Mono<ResponseObject> deleteById(@PathVariable("id") Long id) {
        logger.debug("id {}", id);
        return service.deleteById(id)
                .then(Mono.just(new ResponseObject(200, "Customer deleted")));
    }

    @PreAuthorize("hasAuthority('Update Customer')")
    @PostMapping
    public Mono<Rider> save(@RequestBody @Valid Rider rider) {
        return service.save(rider);
    }
}
