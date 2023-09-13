/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.web.reactive.config.CorsRegistry;

/**
 *
 * @author Timothy Wachiuri
 */
public class WebConfigTest {
    
    public WebConfigTest() {
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
     * Test of addCorsMappings method, of class WebConfig.
     */
    @Test
    public void testAddCorsMappings() {
        System.out.println("addCorsMappings");
        CorsRegistry corsRegistry = null;
        WebConfig instance = new WebConfig();
        instance.addCorsMappings(corsRegistry);
        
        
    }
    
}
