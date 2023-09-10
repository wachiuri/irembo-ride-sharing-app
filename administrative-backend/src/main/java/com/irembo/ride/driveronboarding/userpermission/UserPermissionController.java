package com.irembo.ride.driveronboarding.userpermission;

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
@RequestMapping("/userpermission")
public class UserPermissionController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserPermissionService service;

    @PreAuthorize("hasAuthority('View UserPermission')")
    @GetMapping
    public Mono<Page<UserPermission>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int pageIndex,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return service.findAll(pageIndex, size);
    }

    @PreAuthorize("hasAuthority('View UserPermission')")
    @GetMapping("/{id}")
    public Mono<UserPermission> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PreAuthorize("hasAuthority('Delete UserPermission')")
    @DeleteMapping("/{id}")
    public Mono<ResponseObject> deleteById(@PathVariable("id") Long id) {
        logger.debug("id {}", id);
        return service.deleteById(id)
                .then(Mono.just(new ResponseObject(200, "UserPermission deleted")));
    }

    @PreAuthorize("hasAuthority('Update UserPermission')")
    @PostMapping
    public Mono<UserPermission> save(@RequestBody @Valid UserPermission userPermission) {
        return service.save(userPermission);
    }
}
