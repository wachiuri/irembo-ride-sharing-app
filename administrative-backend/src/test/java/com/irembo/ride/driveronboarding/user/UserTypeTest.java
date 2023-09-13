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

/**
 *
 * @author Timothy Wachiuri
 */
public class UserTypeTest {
    
    public UserTypeTest() {
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
     * Test of values method, of class UserType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        UserType[] expResult = null;
        UserType[] result = UserType.values();
        assertArrayEquals(expResult, result);
        
        
    }

    /**
     * Test of valueOf method, of class UserType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        UserType expResult = null;
        UserType result = UserType.valueOf(string);
        assertEquals(expResult, result);
        
        
    }
    
}
