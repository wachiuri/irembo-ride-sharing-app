/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.userpermission;

import com.irembo.ride.driveronboarding.permission.Permission;
import com.irembo.ride.driveronboarding.user.User;
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
public class UserPermissionTest {
    
    public UserPermissionTest() {
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
     * Test of builder method, of class UserPermission.
     */
    @Test
    public void testBuilder() {
        System.out.println("builder");
        UserPermission.UserPermissionBuilder expResult = null;
        UserPermission.UserPermissionBuilder result = UserPermission.builder();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getUser method, of class UserPermission.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UserPermission instance = new UserPermission();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getPermission method, of class UserPermission.
     */
    @Test
    public void testGetPermission() {
        System.out.println("getPermission");
        UserPermission instance = new UserPermission();
        Permission expResult = null;
        Permission result = instance.getPermission();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setUser method, of class UserPermission.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        UserPermission instance = new UserPermission();
        instance.setUser(user);
        
        
    }

    /**
     * Test of setPermission method, of class UserPermission.
     */
    @Test
    public void testSetPermission() {
        System.out.println("setPermission");
        Permission permission = null;
        UserPermission instance = new UserPermission();
        instance.setPermission(permission);
        
        
    }

    /**
     * Test of equals method, of class UserPermission.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        UserPermission instance = new UserPermission();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class UserPermission.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        UserPermission instance = new UserPermission();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class UserPermission.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserPermission instance = new UserPermission();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class UserPermission.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserPermission instance = new UserPermission();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
