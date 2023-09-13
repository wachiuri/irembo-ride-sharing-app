/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.trip.request;

import com.irembo.ride.trip.driverlocation.DriverLocation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class RequestControllerTest {
    
    public RequestControllerTest() {
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
     * Test of request method, of class RequestController.
     */
    @Test
    public void testRequest() {
        System.out.println("request");
        Request request = null;
        RequestController instance = new RequestController();
        Mono<DriverLocation> expResult = null;
        Mono<DriverLocation> result = instance.request(request);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of list method, of class RequestController.
     */
    @Test
    public void testList() {
        System.out.println("list");
        RequestController instance = new RequestController();
        Flux<Request> expResult = null;
        Flux<Request> result = instance.list();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of accept method, of class RequestController.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        Request request = null;
        RequestController instance = new RequestController();
        Mono<Request> expResult = null;
        Mono<Request> result = instance.accept(request);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of listen method, of class RequestController.
     */
    @Test
    public void testListen() {
        System.out.println("listen");
        RequestController instance = new RequestController();
        instance.listen();
        
        
    }
    
}
