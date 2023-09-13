package com.irembo.ride.trip.configuration.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ApplicationWebSocketSession {

    private Long driverId;

    private Long riderId;

    private WebSocketSession webSocketSession;

    public void write(String message) {
        log.trace("sending {} to driver id {}", message, driverId);
        webSocketSession.send(Mono.just(webSocketSession.textMessage(message))).subscribe();
    }
}
