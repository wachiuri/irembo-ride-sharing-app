/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration;

import io.r2dbc.spi.ConnectionFactory;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Timothy Wachiuri
 */
public class R2dbcApplicationConfigurationTest {
    
    public R2dbcApplicationConfigurationTest() {
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
     * Test of connectionFactory method, of class R2dbcApplicationConfiguration.
     */
    @Test
    public void testConnectionFactory() {
        System.out.println("connectionFactory");
        R2dbcApplicationConfiguration instance = new R2dbcApplicationConfiguration();
        ConnectionFactory expResult = null;
        ConnectionFactory result = instance.connectionFactory();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCustomConverters method, of class R2dbcApplicationConfiguration.
     */
    @Test
    public void testGetCustomConverters() {
        System.out.println("getCustomConverters");
        R2dbcApplicationConfiguration instance = new R2dbcApplicationConfiguration();
        List<Object> expResult = null;
        List<Object> result = instance.getCustomConverters();
        assertEquals(expResult, result);
        
        
    }
    
}
