package com.irembo.ride.driveronboarding.permission;

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
@RequestMapping("/permission")
public class PermissionController extends BaseController {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PermissionService service;

    @PreAuthorize("hasAuthority('View Permission')")
    @GetMapping
    public Mono<Page<Permission>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int pageIndex,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return service.findAll(pageIndex, size);
    }

    @PreAuthorize("hasAuthority('View Permission')")
    @GetMapping("/{id}")
    public Mono<Permission> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PreAuthorize("hasAuthority('Delete Permission')")
    @DeleteMapping("/{id}")
    public Mono<ResponseObject> deleteById(@PathVariable("id") Long id) {
        logger.debug("id {}", id);
        return service.deleteById(id)
                .then(Mono.just(new ResponseObject(200, "Permission deleted")));
    }

    @PreAuthorize("hasAuthority('Update Permission')")
    @PostMapping
    public Mono<Permission> save(@RequestBody @Valid Permission permission) {
        return service.save(permission);
    }
}
