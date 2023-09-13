/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration.security;

import com.irembo.ride.driveronboarding.user.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Timothy Wachiuri
 */
public class UserDetailsImplTest {
    
    public UserDetailsImplTest() {
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
     * Test of builder method, of class UserDetailsImpl.
     */
    @Test
    public void testBuilder() {
        System.out.println("builder");
        UserDetailsImpl.UserDetailsImplBuilder expResult = null;
        UserDetailsImpl.UserDetailsImplBuilder result = UserDetailsImpl.builder();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getAuthorities method, of class UserDetailsImpl.
     */
    @Test
    public void testGetAuthorities() {
        System.out.println("getAuthorities");
        UserDetailsImpl instance = new UserDetailsImpl();
        List<GrantedAuthority> expResult = null;
        List<GrantedAuthority> result = instance.getAuthorities();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getUsername method, of class UserDetailsImpl.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        UserDetailsImpl instance = new UserDetailsImpl();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getPassword method, of class UserDetailsImpl.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserDetailsImpl instance = new UserDetailsImpl();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of isAccountNonLocked method, of class UserDetailsImpl.
     */
    @Test
    public void testIsAccountNonLocked() {
        System.out.println("isAccountNonLocked");
        UserDetailsImpl instance = new UserDetailsImpl();
        boolean expResult = false;
        boolean result = instance.isAccountNonLocked();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of isAccountNonExpired method, of class UserDetailsImpl.
     */
    @Test
    public void testIsAccountNonExpired() {
        System.out.println("isAccountNonExpired");
        UserDetailsImpl instance = new UserDetailsImpl();
        boolean expResult = false;
        boolean result = instance.isAccountNonExpired();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of isCredentialsNonExpired method, of class UserDetailsImpl.
     */
    @Test
    public void testIsCredentialsNonExpired() {
        System.out.println("isCredentialsNonExpired");
        UserDetailsImpl instance = new UserDetailsImpl();
        boolean expResult = false;
        boolean result = instance.isCredentialsNonExpired();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of isEnabled method, of class UserDetailsImpl.
     */
    @Test
    public void testIsEnabled() {
        System.out.println("isEnabled");
        UserDetailsImpl instance = new UserDetailsImpl();
        boolean expResult = false;
        boolean result = instance.isEnabled();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getUser method, of class UserDetailsImpl.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UserDetailsImpl instance = new UserDetailsImpl();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setAuthorities method, of class UserDetailsImpl.
     */
    @Test
    public void testSetAuthorities() {
        System.out.println("setAuthorities");
        List<GrantedAuthority> authorities = null;
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setAuthorities(authorities);
        
        
    }

    /**
     * Test of setUsername method, of class UserDetailsImpl.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setUsername(username);
        
        
    }

    /**
     * Test of setPassword method, of class UserDetailsImpl.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setPassword(password);
        
        
    }

    /**
     * Test of setAccountNonLocked method, of class UserDetailsImpl.
     */
    @Test
    public void testSetAccountNonLocked() {
        System.out.println("setAccountNonLocked");
        boolean accountNonLocked = false;
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setAccountNonLocked(accountNonLocked);
        
        
    }

    /**
     * Test of setAccountNonExpired method, of class UserDetailsImpl.
     */
    @Test
    public void testSetAccountNonExpired() {
        System.out.println("setAccountNonExpired");
        boolean accountNonExpired = false;
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setAccountNonExpired(accountNonExpired);
        
        
    }

    /**
     * Test of setCredentialsNonExpired method, of class UserDetailsImpl.
     */
    @Test
    public void testSetCredentialsNonExpired() {
        System.out.println("setCredentialsNonExpired");
        boolean credentialsNonExpired = false;
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setCredentialsNonExpired(credentialsNonExpired);
        
        
    }

    /**
     * Test of setEnabled method, of class UserDetailsImpl.
     */
    @Test
    public void testSetEnabled() {
        System.out.println("setEnabled");
        boolean enabled = false;
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setEnabled(enabled);
        
        
    }

    /**
     * Test of setUser method, of class UserDetailsImpl.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        UserDetailsImpl instance = new UserDetailsImpl();
        instance.setUser(user);
        
        
    }

    /**
     * Test of equals method, of class UserDetailsImpl.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        UserDetailsImpl instance = new UserDetailsImpl();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class UserDetailsImpl.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        UserDetailsImpl instance = new UserDetailsImpl();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class UserDetailsImpl.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserDetailsImpl instance = new UserDetailsImpl();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class UserDetailsImpl.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserDetailsImpl instance = new UserDetailsImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
