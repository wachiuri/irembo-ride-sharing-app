/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.lib.ResponseObject;
import java.security.Principal;
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
public class UserControllerTest {
    
    public UserControllerTest() {
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
     * Test of findAll method, of class UserController.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        int pageIndex = 0;
        int size = 0;
        UserController instance = new UserController();
        Mono<Page<User>> expResult = null;
        Mono<Page<User>> result = instance.findAll(pageIndex, size);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findById method, of class UserController.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        UserController instance = new UserController();
        Mono<User> expResult = null;
        Mono<User> result = instance.findById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of deleteById method, of class UserController.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Long id = null;
        UserController instance = new UserController();
        Mono<ResponseObject> expResult = null;
        Mono<ResponseObject> result = instance.deleteById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of save method, of class UserController.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        User user = null;
        UserController instance = new UserController();
        Mono<User> expResult = null;
        Mono<User> result = instance.save(user);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of principal method, of class UserController.
     */
    @Test
    public void testPrincipal() {
        System.out.println("principal");
        Principal principal = null;
        UserController instance = new UserController();
        Principal expResult = null;
        Principal result = instance.principal(principal);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of driver method, of class UserController.
     */
    @Test
    public void testDriver() {
        System.out.println("driver");
        int pageIndex = 0;
        int size = 0;
        UserController instance = new UserController();
        Mono<Page<User>> expResult = null;
        Mono<Page<User>> result = instance.driver(pageIndex, size);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of register method, of class UserController.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        User user = null;
        UserController instance = new UserController();
        Mono<User> expResult = null;
        Mono<User> result = instance.register(user);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of activate method, of class UserController.
     */
    @Test
    public void testActivate() {
        System.out.println("activate");
        Long id = null;
        UserController instance = new UserController();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.activate(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of deactivate method, of class UserController.
     */
    @Test
    public void testDeactivate() {
        System.out.println("deactivate");
        Long id = null;
        UserController instance = new UserController();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.deactivate(id);
        assertEquals(expResult, result);
        
        
    }
    
}
