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
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;

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
    
}
