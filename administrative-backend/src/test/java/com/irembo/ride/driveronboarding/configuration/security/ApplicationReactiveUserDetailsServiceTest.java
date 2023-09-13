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
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationReactiveUserDetailsServiceTest {
    
    public ApplicationReactiveUserDetailsServiceTest() {
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
     * Test of findByUsername method, of class ApplicationReactiveUserDetailsService.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        String email = "";
        ApplicationReactiveUserDetailsService instance = new ApplicationReactiveUserDetailsService();
        Mono<UserDetails> expResult = null;
        Mono<UserDetails> result = instance.findByUsername(email);
        assertEquals(expResult, result);
        
        
    }
    
}
