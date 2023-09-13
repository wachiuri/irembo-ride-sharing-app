/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.trip.request;

import com.irembo.ride.trip.driverlocation.DriverLocation;
import java.util.List;
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
public class RequestServiceTest {
    
    public RequestServiceTest() {
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
     * Test of request method, of class RequestService.
     */
    @Test
    public void testRequest() {
        System.out.println("request");
        Request request = null;
        RequestService instance = new RequestService();
        Mono<DriverLocation> expResult = null;
        Mono<DriverLocation> result = instance.request(request);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of distance method, of class RequestService.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        double lat1 = 0.0;
        double lon1 = 0.0;
        double lat2 = 0.0;
        double lon2 = 0.0;
        RequestService instance = new RequestService();
        double expResult = 0.0;
        double result = instance.distance(lat1, lon1, lat2, lon2);
        assertEquals(expResult, result, 0);
        
        
    }

    /**
     * Test of list method, of class RequestService.
     */
    @Test
    public void testList() {
        System.out.println("list");
        RequestService instance = new RequestService();
        List<Request> expResult = null;
        List<Request> result = instance.list();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of accept method, of class RequestService.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        Request request = null;
        RequestService instance = new RequestService();
        Mono<Request> expResult = null;
        Mono<Request> result = instance.accept(request);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of reject method, of class RequestService.
     */
    @Test
    public void testReject() {
        System.out.println("reject");
        Request request = null;
        RequestService instance = new RequestService();
        Mono<Request> expResult = null;
        Mono<Request> result = instance.reject(request);
        assertEquals(expResult, result);
        
        
    }
    
}
