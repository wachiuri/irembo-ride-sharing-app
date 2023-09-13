/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.driverlocation;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import reactor.core.publisher.Flux;

/**
 *
 * @author Timothy Wachiuri
 */
public class DriverLocationServiceTest {
    
    public DriverLocationServiceTest() {
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
     * Test of list method, of class DriverLocationService.
     */
    @Test
    public void testList() {
        System.out.println("list");
        DriverLocationService instance = new DriverLocationService();
        Flux<Map<Long, DriverLocation>> expResult = null;
        Flux<Map<Long, DriverLocation>> result = instance.getDriverLocations();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of update method, of class DriverLocationService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        DriverLocation driverLocation = null;
        DriverLocationService instance = new DriverLocationService();
        DriverLocation expResult = null;
        DriverLocation result = instance.update(driverLocation);
        assertEquals(expResult, result);
        
        
    }
    
}
