package com.irembo.ride.driveronboarding.configuration.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import reactor.core.publisher.Mono;

@Slf4j
public class ApplicationServerAuthenticationFailureHandler implements ServerAuthenticationFailureHandler {
    @Override
    public Mono<Void> onAuthenticationFailure(WebFilterExchange webFilterExchange, AuthenticationException exception) {
        log.error("authentication failure {}", exception.getMessage());
        webFilterExchange.getExchange().getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        return Mono.empty();
    }
}
