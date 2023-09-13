/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.lib;

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
public class ResponseObjectTest {
    
    public ResponseObjectTest() {
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
     * Test of getStatus method, of class ResponseObject.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ResponseObject instance = new ResponseObject();
        int expResult = 0;
        int result = instance.getStatus();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getMessage method, of class ResponseObject.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        ResponseObject instance = new ResponseObject();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setStatus method, of class ResponseObject.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        int status = 0;
        ResponseObject instance = new ResponseObject();
        instance.setStatus(status);
        
        
    }

    /**
     * Test of setMessage method, of class ResponseObject.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        ResponseObject instance = new ResponseObject();
        instance.setMessage(message);
        
        
    }

    /**
     * Test of equals method, of class ResponseObject.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        ResponseObject instance = new ResponseObject();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class ResponseObject.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        ResponseObject instance = new ResponseObject();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class ResponseObject.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ResponseObject instance = new ResponseObject();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class ResponseObject.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ResponseObject instance = new ResponseObject();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
