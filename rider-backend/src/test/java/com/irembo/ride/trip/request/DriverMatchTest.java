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

/**
 *
 * @author Timothy Wachiuri
 */
public class DriverMatchTest {
    
    public DriverMatchTest() {
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
     * Test of getRequest method, of class DriverMatch.
     */
    @Test
    public void testGetRequest() {
        System.out.println("getRequest");
        DriverMatch instance = new DriverMatch();
        Request expResult = null;
        Request result = instance.getRequest();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDriverLocation method, of class DriverMatch.
     */
    @Test
    public void testGetDriverLocation() {
        System.out.println("getDriverLocation");
        DriverMatch instance = new DriverMatch();
        DriverLocation expResult = null;
        DriverLocation result = instance.getDriverLocation();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setRequest method, of class DriverMatch.
     */
    @Test
    public void testSetRequest() {
        System.out.println("setRequest");
        Request request = null;
        DriverMatch instance = new DriverMatch();
        instance.setRequest(request);
        
        
    }

    /**
     * Test of setDriverLocation method, of class DriverMatch.
     */
    @Test
    public void testSetDriverLocation() {
        System.out.println("setDriverLocation");
        DriverLocation driverLocation = null;
        DriverMatch instance = new DriverMatch();
        instance.setDriverLocation(driverLocation);
        
        
    }

    /**
     * Test of equals method, of class DriverMatch.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        DriverMatch instance = new DriverMatch();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class DriverMatch.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        DriverMatch instance = new DriverMatch();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class DriverMatch.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DriverMatch instance = new DriverMatch();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class DriverMatch.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DriverMatch instance = new DriverMatch();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
