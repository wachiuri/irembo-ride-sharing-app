/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.rider;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Timothy Wachiuri
 */
public class RiderServiceTest {
    
    public RiderServiceTest() {
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
     * Test of getRepository method, of class RiderService.
     */
    @Test
    public void testGetRepository() {
        System.out.println("getRepository");
        RiderService instance = new RiderService();
        RiderRepository expResult = null;
        RiderRepository result = instance.getRepository();
        Assertions.assertEquals(expResult, result);
        
        
    }
    
}
