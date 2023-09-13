/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.driverlocation;

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
public class DriverLocationControllerTest {
    
    public DriverLocationControllerTest() {
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
     * Test of list method, of class DriverLocationController.
     */
    @Test
    public void testList() {
        System.out.println("list");
        DriverLocationController instance = new DriverLocationController();
        Flux<DriverLocation> expResult = null;
        Flux<DriverLocation> result = instance.list();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of update method, of class DriverLocationController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        DriverLocation driverLocation = null;
        DriverLocationController instance = new DriverLocationController();
        DriverLocation expResult = null;
        DriverLocation result = instance.update(driverLocation);
        assertEquals(expResult, result);
        
        
    }
    
}
