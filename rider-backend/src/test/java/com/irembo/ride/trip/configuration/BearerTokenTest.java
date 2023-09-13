/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.trip.configuration;

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
public class BearerTokenTest {
    
    public BearerTokenTest() {
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
     * Test of getCredentials method, of class BearerToken.
     */
    @Test
    public void testGetCredentials() {
        System.out.println("getCredentials");
        BearerToken instance = null;
        String expResult = "";
        String result = instance.getCredentials();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getPrincipal method, of class BearerToken.
     */
    @Test
    public void testGetPrincipal() {
        System.out.println("getPrincipal");
        BearerToken instance = null;
        String expResult = "";
        String result = instance.getPrincipal();
        assertEquals(expResult, result);
        
        
    }
    
}
