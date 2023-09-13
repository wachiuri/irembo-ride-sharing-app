/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.base;

import com.irembo.ride.driveronboarding.user.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Timothy Wachiuri
 */
public class BaseEntityTest {
    
    public BaseEntityTest() {
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
     * Test of getId method, of class BaseEntity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        BaseEntity instance = new BaseEntityImpl();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCreatedBy method, of class BaseEntity.
     */
    @Test
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        BaseEntity instance = new BaseEntityImpl();
        User expResult = null;
        User result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCreatedDate method, of class BaseEntity.
     */
    @Test
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        BaseEntity instance = new BaseEntityImpl();
        Instant expResult = null;
        Instant result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getModifiedBy method, of class BaseEntity.
     */
    @Test
    public void testGetModifiedBy() {
        System.out.println("getModifiedBy");
        BaseEntity instance = new BaseEntityImpl();
        User expResult = null;
        User result = instance.getModifiedBy();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getModifiedDate method, of class BaseEntity.
     */
    @Test
    public void testGetModifiedDate() {
        System.out.println("getModifiedDate");
        BaseEntity instance = new BaseEntityImpl();
        Instant expResult = null;
        Instant result = instance.getModifiedDate();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setId method, of class BaseEntity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setId(id);
        
        
    }

    /**
     * Test of setCreatedBy method, of class BaseEntity.
     */
    @Test
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        User createdBy = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setCreatedBy(createdBy);
        
        
    }

    /**
     * Test of setCreatedDate method, of class BaseEntity.
     */
    @Test
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        Instant createdDate = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setCreatedDate(createdDate);
        
        
    }

    /**
     * Test of setModifiedBy method, of class BaseEntity.
     */
    @Test
    public void testSetModifiedBy() {
        System.out.println("setModifiedBy");
        User modifiedBy = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setModifiedBy(modifiedBy);
        
        
    }

    /**
     * Test of setModifiedDate method, of class BaseEntity.
     */
    @Test
    public void testSetModifiedDate() {
        System.out.println("setModifiedDate");
        Instant modifiedDate = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setModifiedDate(modifiedDate);
        
        
    }

    /**
     * Test of equals method, of class BaseEntity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        BaseEntity instance = new BaseEntityImpl();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class BaseEntity.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        BaseEntity instance = new BaseEntityImpl();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class BaseEntity.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        BaseEntity instance = new BaseEntityImpl();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class BaseEntity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BaseEntity instance = new BaseEntityImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }

    public class BaseEntityImpl extends BaseEntity {
    }
    
}
