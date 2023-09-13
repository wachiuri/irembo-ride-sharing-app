/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.driver;

import com.irembo.ride.driveronboarding.lib.ResponseObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class DriverControllerTest {
    
    public DriverControllerTest() {
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
     * Test of findAll method, of class DriverController.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        int pageIndex = 0;
        int size = 0;
        DriverController instance = new DriverController();
        Mono<Page<Driver>> expResult = null;
        Mono<Page<Driver>> result = instance.findAll(pageIndex, size);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findById method, of class DriverController.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        DriverController instance = new DriverController();
        Mono<Driver> expResult = null;
        Mono<Driver> result = instance.findById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of deleteById method, of class DriverController.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Long id = null;
        DriverController instance = new DriverController();
        Mono<ResponseObject> expResult = null;
        Mono<ResponseObject> result = instance.deleteById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of save method, of class DriverController.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Driver driver = null;
        DriverController instance = new DriverController();
        Mono<Driver> expResult = null;
        Mono<Driver> result = instance.save(driver);
        assertEquals(expResult, result);
        
        
    }
    
}
