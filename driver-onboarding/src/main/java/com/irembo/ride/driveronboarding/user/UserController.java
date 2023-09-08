package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.base.BaseController;
import com.irembo.ride.driveronboarding.lib.ResponseObject;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    @PreAuthorize("hasAuthority('View User')")
    @GetMapping
    public Mono<Page<User>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int pageIndex,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return service.findAll(pageIndex, size);
    }

    @PreAuthorize("hasAuthority('View User')")
    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PreAuthorize("hasAuthority('Delete User')")
    @DeleteMapping("/{id}")
    public Mono<ResponseObject> deleteById(@PathVariable("id") Long id) {
        logger.debug("id {}", id);
        return service.deleteById(id)
                .then(Mono.just(new ResponseObject(200, "User deleted")));
    }

    @PreAuthorize("hasAuthority('Update User')")
    @PostMapping
    public Mono<User> save(@RequestBody @Valid User user) {
        return service.save(user);
    }

    @GetMapping("/principal")
    public Principal principal(Principal principal) {
        return principal;
    }

    @GetMapping("/driver")
    public Flux<User> driver(
            @RequestParam(name = "page", defaultValue = "0") int pageIndex,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return service.findByUserType(UserType.DRIVER, pageIndex, size);
    }

    @PostMapping("/register")
    public Mono<User> register(@RequestBody @Valid User user) {
        return service.save(user);
    }
}
