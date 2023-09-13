/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.rider;

import com.irembo.ride.driver.user.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Timothy Wachiuri
 */
public class RequestTest {
    
    public RequestTest() {
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
     * Test of getRider method, of class Request.
     */
    @Test
    public void testGetRider() {
        System.out.println("getUser");
        Request instance = new Request();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDepartureLatitude method, of class Request.
     */
    @Test
    public void testGetDepartureLatitude() {
        System.out.println("getDepartureLatitude");
        Request instance = new Request();
        Double expResult = null;
        Double result = instance.getDepartureLatitude();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDepartureLongitude method, of class Request.
     */
    @Test
    public void testGetDepartureLongitude() {
        System.out.println("getDepartureLongitude");
        Request instance = new Request();
        Double expResult = null;
        Double result = instance.getDepartureLongitude();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getArrivalLatitude method, of class Request.
     */
    @Test
    public void testGetArrivalLatitude() {
        System.out.println("getArrivalLatitude");
        Request instance = new Request();
        Double expResult = null;
        Double result = instance.getArrivalLatitude();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getArrivalLongitude method, of class Request.
     */
    @Test
    public void testGetArrivalLongitude() {
        System.out.println("getArrivalLongitude");
        Request instance = new Request();
        Double expResult = null;
        Double result = instance.getArrivalLongitude();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setRider method, of class Request.
     */
    @Test
    public void testSetRider() {
        System.out.println("setRider");
        User rider = null;
        Request instance = new Request();
        instance.setUser(rider);
        
        
    }

    /**
     * Test of setDepartureLatitude method, of class Request.
     */
    @Test
    public void testSetDepartureLatitude() {
        System.out.println("setDepartureLatitude");
        Double departureLatitude = null;
        Request instance = new Request();
        instance.setDepartureLatitude(departureLatitude);
        
        
    }

    /**
     * Test of setDepartureLongitude method, of class Request.
     */
    @Test
    public void testSetDepartureLongitude() {
        System.out.println("setDepartureLongitude");
        Double departureLongitude = null;
        Request instance = new Request();
        instance.setDepartureLongitude(departureLongitude);
        
        
    }

    /**
     * Test of setArrivalLatitude method, of class Request.
     */
    @Test
    public void testSetArrivalLatitude() {
        System.out.println("setArrivalLatitude");
        Double arrivalLatitude = null;
        Request instance = new Request();
        instance.setArrivalLatitude(arrivalLatitude);
        
        
    }

    /**
     * Test of setArrivalLongitude method, of class Request.
     */
    @Test
    public void testSetArrivalLongitude() {
        System.out.println("setArrivalLongitude");
        Double arrivalLongitude = null;
        Request instance = new Request();
        instance.setArrivalLongitude(arrivalLongitude);
        
        
    }

    /**
     * Test of equals method, of class Request.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Request instance = new Request();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class Request.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Request instance = new Request();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class Request.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Request instance = new Request();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class Request.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Request instance = new Request();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
