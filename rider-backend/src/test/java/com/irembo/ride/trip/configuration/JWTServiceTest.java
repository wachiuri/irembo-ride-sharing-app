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
public class JWTServiceTest {
    
    public JWTServiceTest() {
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
     * Test of generate method, of class JWTService.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");
        String subject = "";
        Object data = null;
        JWTService instance = new JWTService();
        String expResult = "";
        String result = instance.generate(subject, data);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getUserID method, of class JWTService.
     */
    @Test
    public void testGetUserID() {
        System.out.println("getUserID");
        String token = "";
        JWTService instance = new JWTService();
        String expResult = "";
        String result = instance.getUserID(token);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of isValid method, of class JWTService.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        String token = "";
        JWTService instance = new JWTService();
        boolean expResult = false;
        boolean result = instance.isValid(token);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of get method, of class JWTService.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        JWTService instance = new JWTService();
        Object expResult = null;
        Object result = instance.get("", Object.class);
        assertEquals(expResult, result);
        
        
    }
    
}
