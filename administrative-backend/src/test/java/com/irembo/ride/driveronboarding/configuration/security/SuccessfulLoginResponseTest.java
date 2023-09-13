/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration.security;

import com.irembo.ride.driveronboarding.user.User;
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
public class SuccessfulLoginResponseTest {
    
    public SuccessfulLoginResponseTest() {
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
     * Test of getUser method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getToken method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        String expResult = "";
        String result = instance.getToken();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getStatus method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        int expResult = 0;
        int result = instance.getStatus();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setUser method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        instance.setUser(user);
        
        
    }

    /**
     * Test of setToken method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testSetToken() {
        System.out.println("setToken");
        String token = "";
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        instance.setToken(token);
        
        
    }

    /**
     * Test of setStatus method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        int status = 0;
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        instance.setStatus(status);
        
        
    }

    /**
     * Test of equals method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class SuccessfulLoginResponse.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SuccessfulLoginResponse instance = new SuccessfulLoginResponse();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
