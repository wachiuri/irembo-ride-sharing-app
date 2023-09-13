/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.configuration.websocket;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.web.reactive.socket.WebSocketSession;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationWebSocketSessionTest {
    
    public ApplicationWebSocketSessionTest() {
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
     * Test of write method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        String message = "";
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        instance.write(message);
        
        
    }

    /**
     * Test of getDriverId method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testGetDriverId() {
        System.out.println("getDriverId");
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        Long expResult = null;
        Long result = instance.getDriverId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCustomerId method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        Long expResult = null;
        Long result = instance.getCustomerId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getWebSocketSession method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testGetWebSocketSession() {
        System.out.println("getWebSocketSession");
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        WebSocketSession expResult = null;
        WebSocketSession result = instance.getWebSocketSession();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setDriverId method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testSetDriverId() {
        System.out.println("setDriverId");
        Long driverId = null;
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        instance.setDriverId(driverId);
        
        
    }

    /**
     * Test of setCustomerId method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        Long customerId = null;
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        instance.setCustomerId(customerId);
        
        
    }

    /**
     * Test of setWebSocketSession method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testSetWebSocketSession() {
        System.out.println("setWebSocketSession");
        WebSocketSession webSocketSession = null;
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        instance.setWebSocketSession(webSocketSession);
        
        
    }

    /**
     * Test of equals method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class ApplicationWebSocketSession.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ApplicationWebSocketSession instance = new ApplicationWebSocketSession();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
