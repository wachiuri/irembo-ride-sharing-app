/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.user;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.data.r2dbc.mapping.OutboundRow;

/**
 *
 * @author Timothy Wachiuri
 */
public class UserWriteConverterTest {
    
    public UserWriteConverterTest() {
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
     * Test of convert method, of class UserWriteConverter.
     */
    @Test
    public void testConvert() {
        System.out.println("convert");
        User source = null;
        UserWriteConverter instance = new UserWriteConverter();
        OutboundRow expResult = null;
        OutboundRow result = instance.convert(source);
        assertEquals(expResult, result);
        
        
    }
    
}
