/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration.jpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;

/**
 *
 * @author Timothy Wachiuri
 */
public class PhysicalNamingStrategyTest {
    
    public PhysicalNamingStrategyTest() {
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
     * Test of getTableName method, of class PhysicalNamingStrategy.
     */
    @Test
    public void testGetTableName() {
        System.out.println("getTableName");
        Class type = null;
        PhysicalNamingStrategy instance = new PhysicalNamingStrategy();
        String expResult = "";
        String result = instance.getTableName(type);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getColumnName method, of class PhysicalNamingStrategy.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        RelationalPersistentProperty property = null;
        PhysicalNamingStrategy instance = new PhysicalNamingStrategy();
        String expResult = "";
        String result = instance.getColumnName(property);
        assertEquals(expResult, result);
        
        
    }
    
}
