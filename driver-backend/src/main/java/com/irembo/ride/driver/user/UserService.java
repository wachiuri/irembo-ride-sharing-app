package com.irembo.ride.driver.user;

import com.irembo.ride.driver.configuration.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
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
                .map(c -> {
                    Authentication authentication = c.getAuthentication();
                    log.trace("authentication {}", authentication);
                    return authentication;
                })
                .map(Authentication::getPrincipal)
                .cast(String.class)
                .flatMap(a -> Mono.just(jwtService.get(a, User.class)))
                ;
    }
}
