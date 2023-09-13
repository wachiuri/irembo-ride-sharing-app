/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.configuration.websocket;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationWebSocketHandlerTest {
    
    public ApplicationWebSocketHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of handle method, of class ApplicationWebSocketHandler.
     */
    @Test
    public void testHandle() {
        System.out.println("handle");
        WebSocketSession session = null;
        ApplicationWebSocketHandler instance = new ApplicationWebSocketHandler();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.handle(session);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of write method, of class ApplicationWebSocketHandler.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        Long driverId = null;
        String message = "";
        ApplicationWebSocketHandler instance = new ApplicationWebSocketHandler();
        instance.write(driverId, message);
        
        
    }

    /**
     * Test of handlerMapping method, of class ApplicationWebSocketHandler.
     */
    @Test
    public void testHandlerMapping() {
        System.out.println("handlerMapping");
        ApplicationWebSocketHandler instance = new ApplicationWebSocketHandler();
        HandlerMapping expResult = null;
        HandlerMapping result = instance.handlerMapping();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getSessions method, of class ApplicationWebSocketHandler.
     */
    @Test
    public void testGetSessions() {
        System.out.println("getSessions");
        ApplicationWebSocketHandler instance = new ApplicationWebSocketHandler();
        List<ApplicationWebSocketSession> expResult = null;
        List<ApplicationWebSocketSession> result = instance.getSessions();
        assertEquals(expResult, result);
        
        
    }
    
}
