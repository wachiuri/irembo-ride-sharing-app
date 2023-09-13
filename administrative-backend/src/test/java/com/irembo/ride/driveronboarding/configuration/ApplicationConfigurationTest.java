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
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.relational.core.mapping.NamingStrategy;

/**
 *
 * @author Timothy Wachiuri
 */
public class ApplicationConfigurationTest {
    
    public ApplicationConfigurationTest() {
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
     * Test of namingStrategy method, of class ApplicationConfiguration.
     */
    @Test
    public void testNamingStrategy() {
        System.out.println("namingStrategy");
        ApplicationConfiguration instance = new ApplicationConfiguration();
        NamingStrategy expResult = null;
        NamingStrategy result = instance.namingStrategy();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of reactiveAuditorAware method, of class ApplicationConfiguration.
     */
    @Test
    public void testReactiveAuditorAware() {
        System.out.println("reactiveAuditorAware");
        ApplicationConfiguration instance = new ApplicationConfiguration();
        ReactiveAuditorAware expResult = null;
        ReactiveAuditorAware result = instance.reactiveAuditorAware();
        assertEquals(expResult, result);
        
        
    }
    
}
