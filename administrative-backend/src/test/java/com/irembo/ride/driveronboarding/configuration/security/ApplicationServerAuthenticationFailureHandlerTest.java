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
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationServerAuthenticationFailureHandlerTest {
    
    public ApplicationServerAuthenticationFailureHandlerTest() {
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
     * Test of onAuthenticationFailure method, of class ApplicationServerAuthenticationFailureHandler.
     */
    @Test
    public void testOnAuthenticationFailure() {
        System.out.println("onAuthenticationFailure");
        WebFilterExchange webFilterExchange = null;
        AuthenticationException exception = null;
        ApplicationServerAuthenticationFailureHandler instance = new ApplicationServerAuthenticationFailureHandler();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.onAuthenticationFailure(webFilterExchange, exception);
        assertEquals(expResult, result);
        
        
    }
    
}
