/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.configuration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 *
 * @author Timothy Wachiuri
 */
public class SecurityConfigurationTest {
    
    public SecurityConfigurationTest() {
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
     * Test of springSecurityFilterChain method, of class SecurityConfiguration.
     */
    @Test
    public void testSpringSecurityFilterChain() {
        System.out.println("springSecurityFilterChain");
        ServerHttpSecurity http = null;
        AuthManager jwtAuthManager = null;
        AuthConverter jwtAuthConverter = null;
        SecurityConfiguration instance = new SecurityConfiguration();
        SecurityWebFilterChain expResult = null;
        SecurityWebFilterChain result = instance.springSecurityFilterChain(http, jwtAuthManager, jwtAuthConverter);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of passwordEncoder method, of class SecurityConfiguration.
     */
    @Test
    public void testPasswordEncoder() {
        System.out.println("passwordEncoder");
        SecurityConfiguration instance = new SecurityConfiguration();
        PasswordEncoder expResult = null;
        PasswordEncoder result = instance.passwordEncoder();
        assertEquals(expResult, result);
        
        
    }
    
}
