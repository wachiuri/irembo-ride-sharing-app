/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.trip.user;

import com.irembo.ride.trip.driver.Driver;
import com.irembo.ride.trip.rider.Rider;
import java.time.Instant;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of builder method, of class User.
     */
    @Test
    public void testBuilder() {
        System.out.println("builder");
        User.UserBuilder expResult = null;
        User.UserBuilder result = User.builder();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getPhoneNumber method, of class User.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        User instance = new User();
        String expResult = "";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getProfilePicture method, of class User.
     */
    @Test
    public void testGetProfilePicture() {
        System.out.println("getProfilePicture");
        User instance = new User();
        String expResult = "";
        String result = instance.getProfilePicture();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of isActive method, of class User.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCreatedDate method, of class User.
     */
    @Test
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        User instance = new User();
        Instant expResult = null;
        Instant result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getModifiedDate method, of class User.
     */
    @Test
    public void testGetModifiedDate() {
        System.out.println("getModifiedDate");
        User instance = new User();
        Instant expResult = null;
        Instant result = instance.getModifiedDate();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getUserType method, of class User.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        User instance = new User();
        UserType expResult = null;
        UserType result = instance.getUserType();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getDriver method, of class User.
     */
    @Test
    public void testGetDriver() {
        System.out.println("getDriver");
        User instance = new User();
        Driver expResult = null;
        Driver result = instance.getDriver();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getRider method, of class User.
     */
    @Test
    public void testGetRider() {
        System.out.println("getRider");
        User instance = new User();
        Rider expResult = null;
        Rider result = instance.getRider();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        User instance = new User();
        instance.setId(id);
        
        
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
        
        
    }

    /**
     * Test of setPhoneNumber method, of class User.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "";
        User instance = new User();
        instance.setPhoneNumber(phoneNumber);
        
        
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
        
        
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        User instance = new User();
        instance.setFirstName(firstName);
        
        
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        User instance = new User();
        instance.setLastName(lastName);
        
        
    }

    /**
     * Test of setProfilePicture method, of class User.
     */
    @Test
    public void testSetProfilePicture() {
        System.out.println("setProfilePicture");
        String profilePicture = "";
        User instance = new User();
        instance.setProfilePicture(profilePicture);
        
        
    }

    /**
     * Test of setActive method, of class User.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = false;
        User instance = new User();
        instance.setActive(active);
        
        
    }

    /**
     * Test of setCreatedDate method, of class User.
     */
    @Test
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        Instant createdDate = null;
        User instance = new User();
        instance.setCreatedDate(createdDate);
        
        
    }

    /**
     * Test of setModifiedDate method, of class User.
     */
    @Test
    public void testSetModifiedDate() {
        System.out.println("setModifiedDate");
        Instant modifiedDate = null;
        User instance = new User();
        instance.setModifiedDate(modifiedDate);
        
        
    }

    /**
     * Test of setUserType method, of class User.
     */
    @Test
    public void testSetUserType() {
        System.out.println("setUserType");
        UserType userType = null;
        User instance = new User();
        instance.setUserType(userType);
        
        
    }

    /**
     * Test of setDriver method, of class User.
     */
    @Test
    public void testSetDriver() {
        System.out.println("setDriver");
        Driver driver = null;
        User instance = new User();
        instance.setDriver(driver);
        
        
    }

    /**
     * Test of setRider method, of class User.
     */
    @Test
    public void testSetRider() {
        System.out.println("setRider");
        Rider rider = null;
        User instance = new User();
        instance.setRider(rider);
        
        
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class User.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
