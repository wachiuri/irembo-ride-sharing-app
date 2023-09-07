package com.irembo.ride.driveronboarding.configuration.security;

import com.irembo.ride.driveronboarding.user.User;
import com.irembo.ride.driveronboarding.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

/*
Note to self : Understand Map and FlatMap properly. They are so confusing
 */

/**
 * Security Note 4 :
 * Authenticates the BearerToken returned from AuthConverter inside the "authenticate" function and returns a UsernamePasswordAuthenticationToken
 * <p>
 * It also makes use of the UserServiceDetails object to get the user from db and return a UserDetail which is then further transformed into UsernamePasswordAuthenticationToken
 * <p>
 * This function is also going to be using JWTService to validate and get the username
 */
@Component
@Slf4j
public class AuthManager implements ReactiveAuthenticationManager {
    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {

        if (authentication == null) {
            return Mono.empty();
        }

        log.trace("principal {} credentials {}", authentication.getPrincipal(), authentication.getCredentials());

        int firstIndexOfDot = ((String) authentication.getPrincipal()).indexOf(".");

        int lastIndexOfDot = ((String) authentication.getPrincipal()).lastIndexOf(".");

        if (firstIndexOfDot == -1 || (firstIndexOfDot == lastIndexOfDot)) {
            String userName = (String) authentication.getPrincipal();

            return userService.findByEmail(userName)
                    .switchIfEmpty(Mono.error(new RuntimeException("User not found")))
                    .<Authentication>flatMap(user -> {
                        if (
                                passwordEncoder.matches(
                                        (String) authentication.getCredentials(), user.getPassword()
                                )) {
                            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                    authentication.getPrincipal(),
                                    authentication.getCredentials(),
                                    List.of()
                            );
                            return Mono.just(usernamePasswordAuthenticationToken);
                        } else {
                            return Mono.error(new RuntimeException("Invalid credentials"))
                                    ;
                        }

                    });
        } else {
            String jwtBearerToken = (String) authentication.getPrincipal();
            log.trace("authorizing {}", jwtBearerToken);
            if (jwtService.isValid(jwtBearerToken)) {
                User user = jwtService.get(jwtBearerToken, User.class);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword(),
                        List.of()
                );
                return Mono.just(usernamePasswordAuthenticationToken);
            } else {
                return Mono.error(new RuntimeException("Invalid token"));
            }
        }

    }
}