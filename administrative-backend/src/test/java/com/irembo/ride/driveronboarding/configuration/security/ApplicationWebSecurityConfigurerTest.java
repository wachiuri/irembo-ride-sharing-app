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
import org.springframework.security.config.annotation.SecurityBuilder;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationWebSecurityConfigurerTest {
    
    public ApplicationWebSecurityConfigurerTest() {
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
     * Test of init method, of class ApplicationWebSecurityConfigurer.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        SecurityBuilder builder = null;
        ApplicationWebSecurityConfigurer instance = new ApplicationWebSecurityConfigurer();
        instance.init(builder);
        
        
    }

    /**
     * Test of configure method, of class ApplicationWebSecurityConfigurer.
     */
    @Test
    public void testConfigure() throws Exception {
        System.out.println("configure");
        SecurityBuilder builder = null;
        ApplicationWebSecurityConfigurer instance = new ApplicationWebSecurityConfigurer();
        instance.configure(builder);
        
        
    }
    
}
