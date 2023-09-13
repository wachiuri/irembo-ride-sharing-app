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
import org.springframework.security.web.server.WebFilterExchange;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationServerAuthenticationSuccessHandlerTest {
    
    public ApplicationServerAuthenticationSuccessHandlerTest() {
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
     * Test of onAuthenticationSuccess method, of class ApplicationServerAuthenticationSuccessHandler.
     */
    @Test
    public void testOnAuthenticationSuccess() {
        System.out.println("onAuthenticationSuccess");
        WebFilterExchange webFilterExchange = null;
        Authentication authentication = null;
        ApplicationServerAuthenticationSuccessHandler instance = new ApplicationServerAuthenticationSuccessHandler();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.onAuthenticationSuccess(webFilterExchange, authentication);
        assertEquals(expResult, result);
        
        
    }
    
}
