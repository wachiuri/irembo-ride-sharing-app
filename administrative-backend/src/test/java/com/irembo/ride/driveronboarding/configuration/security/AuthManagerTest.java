/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration.security;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.security.core.Authentication;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class AuthManagerTest {
    
    public AuthManagerTest() {
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
     * Test of authenticate method, of class AuthManager.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        Authentication authentication = null;
        AuthManager instance = new AuthManager();
        Mono<Authentication> expResult = null;
        Mono<Authentication> result = instance.authenticate(authentication);
        assertEquals(expResult, result);
        
        
    }
    
}
