package com.irembo.ride.driveronboarding.configuration.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irembo.ride.driveronboarding.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ApplicationServerAuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler {

    @Autowired
    private JWTService service;

    @Autowired
    private UserService userService;

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {

        return Mono.justOrEmpty(authentication)
                .zipWhen(a -> userService.findByEmail((String) a.getPrincipal()))
                .flatMap(t -> {
                    try {
                        ServerWebExchange serverWebExchange = webFilterExchange.getExchange();
                        HttpHeaders httpHeaders = serverWebExchange.getResponse().getHeaders();
                        httpHeaders.add("Content-Type", "application/json");

                        String token = service.generate(t.getT2().getEmail(), t.getT2());
                        ObjectMapper om = new ObjectMapper();

                        String body = om.writeValueAsString(new SuccessfulLoginResponse(token, 200));

                        DataBuffer dataBuffer = DefaultDataBufferFactory
                                .sharedInstance
                                .wrap(body.getBytes());
                        return serverWebExchange.getResponse().writeAndFlushWith(Mono.just(Mono.just(dataBuffer)));
                    } catch (JsonProcessingException e) {
                        log.error("error writing json body", e);
                        return Mono.empty();
                    }
                });
    }
}
