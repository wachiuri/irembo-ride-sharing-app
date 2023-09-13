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
import org.springframework.security.core.Authentication;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class AuthConverterTest {
    
    public AuthConverterTest() {
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
     * Test of convert method, of class AuthConverter.
     */
    @Test
    public void testConvert() {
        System.out.println("convert");
        ServerWebExchange exchange = null;
        AuthConverter instance = new AuthConverter();
        Mono<Authentication> expResult = null;
        Mono<Authentication> result = instance.convert(exchange);
        assertEquals(expResult, result);
        
        
    }
    
}
