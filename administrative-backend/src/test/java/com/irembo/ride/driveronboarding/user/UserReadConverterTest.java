/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.user;

import io.r2dbc.spi.Row;
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
public class UserReadConverterTest {
    
    public UserReadConverterTest() {
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
     * Test of convert method, of class UserReadConverter.
     */
    @Test
    public void testConvert() {
        System.out.println("convert");
        Row source = null;
        UserReadConverter instance = new UserReadConverter();
        User expResult = null;
        User result = instance.convert(source);
        assertEquals(expResult, result);
    }
    
}
