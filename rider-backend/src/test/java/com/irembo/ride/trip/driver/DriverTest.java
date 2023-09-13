/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.trip.driver;

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
public class DriverTest {
    
    public DriverTest() {
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
     * Test of builder method, of class Driver.
     */
    @Test
    public void testBuilder() {
        System.out.println("builder");
        Driver.DriverBuilder expResult = null;
        Driver.DriverBuilder result = Driver.builder();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getId method, of class Driver.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Driver instance = new Driver();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getAddress method, of class Driver.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getLicenseNumber method, of class Driver.
     */
    @Test
    public void testGetLicenseNumber() {
        System.out.println("getLicenseNumber");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getLicenseNumber();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getVehicleMake method, of class Driver.
     */
    @Test
    public void testGetVehicleMake() {
        System.out.println("getVehicleMake");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getVehicleMake();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getVehicleModel method, of class Driver.
     */
    @Test
    public void testGetVehicleModel() {
        System.out.println("getVehicleModel");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getVehicleModel();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getVehicleCc method, of class Driver.
     */
    @Test
    public void testGetVehicleCc() {
        System.out.println("getVehicleCc");
        Driver instance = new Driver();
        Integer expResult = null;
        Integer result = instance.getVehicleCc();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getYom method, of class Driver.
     */
    @Test
    public void testGetYom() {
        System.out.println("getYom");
        Driver instance = new Driver();
        Integer expResult = null;
        Integer result = instance.getYom();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getVehicleColor method, of class Driver.
     */
    @Test
    public void testGetVehicleColor() {
        System.out.println("getVehicleColor");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getVehicleColor();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getVehicleImage method, of class Driver.
     */
    @Test
    public void testGetVehicleImage() {
        System.out.println("getVehicleImage");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.getVehicleImage();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setId method, of class Driver.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Driver instance = new Driver();
        instance.setId(id);
        
        
    }

    /**
     * Test of setAddress method, of class Driver.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Driver instance = new Driver();
        instance.setAddress(address);
        
        
    }

    /**
     * Test of setLicenseNumber method, of class Driver.
     */
    @Test
    public void testSetLicenseNumber() {
        System.out.println("setLicenseNumber");
        String licenseNumber = "";
        Driver instance = new Driver();
        instance.setLicenseNumber(licenseNumber);
        
        
    }

    /**
     * Test of setVehicleMake method, of class Driver.
     */
    @Test
    public void testSetVehicleMake() {
        System.out.println("setVehicleMake");
        String vehicleMake = "";
        Driver instance = new Driver();
        instance.setVehicleMake(vehicleMake);
        
        
    }

    /**
     * Test of setVehicleModel method, of class Driver.
     */
    @Test
    public void testSetVehicleModel() {
        System.out.println("setVehicleModel");
        String vehicleModel = "";
        Driver instance = new Driver();
        instance.setVehicleModel(vehicleModel);
        
        
    }

    /**
     * Test of setVehicleCc method, of class Driver.
     */
    @Test
    public void testSetVehicleCc() {
        System.out.println("setVehicleCc");
        Integer vehicleCc = null;
        Driver instance = new Driver();
        instance.setVehicleCc(vehicleCc);
        
        
    }

    /**
     * Test of setYom method, of class Driver.
     */
    @Test
    public void testSetYom() {
        System.out.println("setYom");
        Integer yom = null;
        Driver instance = new Driver();
        instance.setYom(yom);
        
        
    }

    /**
     * Test of setVehicleColor method, of class Driver.
     */
    @Test
    public void testSetVehicleColor() {
        System.out.println("setVehicleColor");
        String vehicleColor = "";
        Driver instance = new Driver();
        instance.setVehicleColor(vehicleColor);
        
        
    }

    /**
     * Test of setVehicleImage method, of class Driver.
     */
    @Test
    public void testSetVehicleImage() {
        System.out.println("setVehicleImage");
        String vehicleImage = "";
        Driver instance = new Driver();
        instance.setVehicleImage(vehicleImage);
        
        
    }

    /**
     * Test of equals method, of class Driver.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Driver instance = new Driver();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class Driver.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Driver instance = new Driver();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class Driver.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Driver instance = new Driver();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class Driver.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Driver instance = new Driver();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
