package com.irembo.ride.driver.configuration.websocket;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        session.getAttributes();

        //HttpExchange.Principal principal = (HttpExchange.Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ApplicationWebSocketSession applicationSession = new ApplicationWebSocketSession();
        //applicationSession.setDriverId(Long.parseLong(principal.getName()));
        applicationSession.setDriverId(10L);
        applicationSession.setWebSocketSession(session);
        sessions.add(applicationSession);

        return session.receive().then();
    }

    public void write(Long driverId, String message) {

        log.trace("no of sessions {}", sessions.size());

        List<ApplicationWebSocketSession> openSessions = sessions
                .stream()
                .filter(s -> s.getWebSocketSession().isOpen())
                .toList();

        log.trace("no of open sessions {}", openSessions.size());
        /*sessions.stream().filter(s -> s.getDriverId().equals(driverId))
                .forEach(s -> s.write(message));*/
        openSessions
                .forEach(s -> s.write(message));
    }

    @Bean
    public HandlerMapping handlerMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/websocket", this);
        int order = -1; // before annotated controllers

        return new SimpleUrlHandlerMapping(map, order);
    }
}
