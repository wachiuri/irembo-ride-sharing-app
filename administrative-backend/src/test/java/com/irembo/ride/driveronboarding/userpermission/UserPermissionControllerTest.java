/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.userpermission;

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
public class UserPermissionControllerTest {
    
    public UserPermissionControllerTest() {
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
     * Test of findAll method, of class UserPermissionController.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        int pageIndex = 0;
        int size = 0;
        UserPermissionController instance = new UserPermissionController();
        Mono<Page<UserPermission>> expResult = null;
        Mono<Page<UserPermission>> result = instance.findAll(pageIndex, size);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findById method, of class UserPermissionController.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        UserPermissionController instance = new UserPermissionController();
        Mono<UserPermission> expResult = null;
        Mono<UserPermission> result = instance.findById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of deleteById method, of class UserPermissionController.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Long id = null;
        UserPermissionController instance = new UserPermissionController();
        Mono<ResponseObject> expResult = null;
        Mono<ResponseObject> result = instance.deleteById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of save method, of class UserPermissionController.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        UserPermission userPermission = null;
        UserPermissionController instance = new UserPermissionController();
        Mono<UserPermission> expResult = null;
        Mono<UserPermission> result = instance.save(userPermission);
        assertEquals(expResult, result);
        
        
    }
    
}
