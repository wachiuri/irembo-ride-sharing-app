package com.irembo.ride.driver.configuration.websocket;

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

    private Long customerId;

    private WebSocketSession webSocketSession;

    public void write(String message) {
        log.trace("session is open", webSocketSession.isOpen());
        webSocketSession.send(Mono.just(webSocketSession.textMessage(message))).subscribe();
    }
}
