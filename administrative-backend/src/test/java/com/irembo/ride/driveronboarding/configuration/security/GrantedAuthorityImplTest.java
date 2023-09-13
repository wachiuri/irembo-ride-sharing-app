/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration.security;

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
public class GrantedAuthorityImplTest {
    
    public GrantedAuthorityImplTest() {
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
     * Test of getAuthority method, of class GrantedAuthorityImpl.
     */
    @Test
    public void testGetAuthority() {
        System.out.println("getAuthority");
        GrantedAuthorityImpl instance = new GrantedAuthorityImpl();
        String expResult = "";
        String result = instance.getAuthority();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setAuthority method, of class GrantedAuthorityImpl.
     */
    @Test
    public void testSetAuthority() {
        System.out.println("setAuthority");
        String authority = "";
        GrantedAuthorityImpl instance = new GrantedAuthorityImpl();
        instance.setAuthority(authority);
        
        
    }

    /**
     * Test of equals method, of class GrantedAuthorityImpl.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        GrantedAuthorityImpl instance = new GrantedAuthorityImpl();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class GrantedAuthorityImpl.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        GrantedAuthorityImpl instance = new GrantedAuthorityImpl();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class GrantedAuthorityImpl.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GrantedAuthorityImpl instance = new GrantedAuthorityImpl();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class GrantedAuthorityImpl.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GrantedAuthorityImpl instance = new GrantedAuthorityImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
