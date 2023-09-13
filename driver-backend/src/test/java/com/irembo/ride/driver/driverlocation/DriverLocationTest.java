/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.driverlocation;

import com.irembo.ride.driver.user.User;
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
public class DriverLocationTest {
    
    public DriverLocationTest() {
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
     * Test of builder method, of class DriverLocation.
     */
    @Test
    public void testBuilder() {
        System.out.println("builder");
        DriverLocation.DriverLocationBuilder expResult = null;
        DriverLocation.DriverLocationBuilder result = DriverLocation.builder();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getUser method, of class DriverLocation.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        DriverLocation instance = new DriverLocation();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getLat method, of class DriverLocation.
     */
    @Test
    public void testGetLat() {
        System.out.println("getLat");
        DriverLocation instance = new DriverLocation();
        Double expResult = null;
        Double result = instance.getLat();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getLng method, of class DriverLocation.
     */
    @Test
    public void testGetLng() {
        System.out.println("getLng");
        DriverLocation instance = new DriverLocation();
        Double expResult = null;
        Double result = instance.getLng();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCellAddress method, of class DriverLocation.
     */
    @Test
    public void testGetCellAddress() {
        System.out.println("getCellAddress");
        DriverLocation instance = new DriverLocation();
        String expResult = "";
        String result = instance.getCellAddress();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setUser method, of class DriverLocation.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        DriverLocation instance = new DriverLocation();
        instance.setUser(user);
        
        
    }

    /**
     * Test of setLat method, of class DriverLocation.
     */
    @Test
    public void testSetLat() {
        System.out.println("setLat");
        Double lat = null;
        DriverLocation instance = new DriverLocation();
        instance.setLat(lat);
        
        
    }

    /**
     * Test of setLng method, of class DriverLocation.
     */
    @Test
    public void testSetLng() {
        System.out.println("setLng");
        Double lng = null;
        DriverLocation instance = new DriverLocation();
        instance.setLng(lng);
        
        
    }

    /**
     * Test of setCellAddress method, of class DriverLocation.
     */
    @Test
    public void testSetCellAddress() {
        System.out.println("setCellAddress");
        String cellAddress = "";
        DriverLocation instance = new DriverLocation();
        instance.setCellAddress(cellAddress);
        
        
    }

    /**
     * Test of equals method, of class DriverLocation.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        DriverLocation instance = new DriverLocation();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class DriverLocation.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        DriverLocation instance = new DriverLocation();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class DriverLocation.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DriverLocation instance = new DriverLocation();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class DriverLocation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DriverLocation instance = new DriverLocation();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
