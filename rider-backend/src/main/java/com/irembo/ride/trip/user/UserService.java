package com.irembo.ride.trip.user;

import com.irembo.ride.trip.configuration.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService {

    @Autowired
    private JWTService jwtService;

    public Mono<User> getCurrentUser() {
        return ReactiveSecurityContextHolder
                .getContext()
                .map(a -> {
                    log.trace("context {}", a);
                    return a;
                })
                .map(SecurityContext::getAuthentication)
                .map(a -> {
                    log.trace("authentication {}", a);
                    return a;
                })
                .map(Authentication::getPrincipal)
                .map(a -> {
                    log.trace("principal {}", a);
                    return a;
                })
                .cast(String.class)
                .map(a -> {
                    log.trace("casted to string {}", a);
                    return a;
                })
                .flatMap(a -> Mono.just(jwtService.get(a, User.class)))
                .map(a -> {
                    log.trace("user {}", a);
                    return a;
                })
                ;
    }
}
