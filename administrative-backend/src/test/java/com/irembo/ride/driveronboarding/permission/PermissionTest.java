/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.permission;

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
public class PermissionTest {
    
    public PermissionTest() {
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
     * Test of builder method, of class Permission.
     */
    @Test
    public void testBuilder() {
        System.out.println("builder");
        Permission.PermissionBuilder expResult = null;
        Permission.PermissionBuilder result = Permission.builder();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getPermission method, of class Permission.
     */
    @Test
    public void testGetPermission() {
        System.out.println("getPermission");
        Permission instance = new Permission();
        String expResult = "";
        String result = instance.getPermission();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setPermission method, of class Permission.
     */
    @Test
    public void testSetPermission() {
        System.out.println("setPermission");
        String permission = "";
        Permission instance = new Permission();
        instance.setPermission(permission);
        
        
    }

    /**
     * Test of equals method, of class Permission.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Permission instance = new Permission();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class Permission.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Permission instance = new Permission();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class Permission.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Permission instance = new Permission();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class Permission.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Permission instance = new Permission();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
