package com.irembo.ride.driver.configuration.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationWebSocketSession {

    private Long driverId;

    private Long customerId;

    private WebSocketSession webSocketSession;

    public void write(String message){
        webSocketSession.send(Mono.just(webSocketSession.textMessage(message)));
    }
}
