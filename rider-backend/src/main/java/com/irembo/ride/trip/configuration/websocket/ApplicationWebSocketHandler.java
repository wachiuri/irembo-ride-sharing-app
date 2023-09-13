package com.irembo.ride.trip.configuration.websocket;

import com.irembo.ride.trip.user.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
public class ApplicationWebSocketHandler implements WebSocketHandler {

    @Getter
    private List<ApplicationWebSocketSession> sessions = new ArrayList<>();

    @Autowired
    private UserService userService;

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        log.trace("handling new session");

        return Mono.just(new ApplicationWebSocketSession())
                .map(a -> {
                    a.setWebSocketSession(session);
                    return a;
                })
                .map(a->sessions.add(a))
                .flatMap(a -> session.receive().then());
/*
        return Mono.just(new ApplicationWebSocketSession())
                .zipWith(userService.getCurrentUser())
                .map(a -> {
                    log.trace("user {}",a.getT2());
                    log.trace("websocketsession {}",a.getT1());
                    a.getT1().setRiderId(a.getT2().getRider().getId());
                    a.getT1().setWebSocketSession(session);
                    return a.getT1();
                })
                .map(a -> sessions.add(a))
                .flatMap(a -> session.receive().then());*/
    }

    public void write(String message) {
        log.trace("writing to {} sessions message {} ", sessions.size(), message);
        sessions.forEach(s -> s.write(message));
    }

    public void write(String message, Long riderId) {
        sessions.stream().filter(s -> s.getRiderId().equals(riderId)).forEach(s -> s.write(message));
    }

    @Bean
    public HandlerMapping handlerMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/websocket", this);
        int order = -1; // before annotated controllers

        return new SimpleUrlHandlerMapping(map, order);
    }
}
