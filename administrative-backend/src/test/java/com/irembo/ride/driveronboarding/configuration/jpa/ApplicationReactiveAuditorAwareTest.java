/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration.jpa;

import com.irembo.ride.driveronboarding.user.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationReactiveAuditorAwareTest {
    
    public ApplicationReactiveAuditorAwareTest() {
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
     * Test of getCurrentAuditor method, of class ApplicationReactiveAuditorAware.
     */
    @Test
    public void testGetCurrentAuditor() {
        System.out.println("getCurrentAuditor");
        ApplicationReactiveAuditorAware instance = new ApplicationReactiveAuditorAware();
        Mono<User> expResult = null;
        Mono<User> result = instance.getCurrentAuditor();
        assertEquals(expResult, result);
        
        
    }
    
}
