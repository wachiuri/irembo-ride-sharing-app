/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.user;

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
public class UserServiceTest {
    
    public UserServiceTest() {
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
     * Test of getRepository method, of class UserService.
     */
    @Test
    public void testGetRepository() {
        System.out.println("getRepository");
        UserService instance = new UserService();
        UserRepository expResult = null;
        UserRepository result = instance.getRepository();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findByEmail method, of class UserService.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        UserService instance = new UserService();
        Mono<User> expResult = null;
        Mono<User> result = instance.findByEmail(email);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findById method, of class UserService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        UserService instance = new UserService();
        Mono<User> expResult = null;
        Mono<User> result = instance.findById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findByUserType method, of class UserService.
     */
    @Test
    public void testFindByUserType() {
        System.out.println("findByUserType");
        UserType userType = null;
        int pageIndex = 0;
        int size = 0;
        UserService instance = new UserService();
        Mono<Page<User>> expResult = null;
        Mono<Page<User>> result = instance.findByUserType(userType, pageIndex, size);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of save method, of class UserService.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        User user = null;
        UserService instance = new UserService();
        Mono<User> expResult = null;
        Mono<User> result = instance.save(user);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of activate method, of class UserService.
     */
    @Test
    public void testActivate() {
        System.out.println("activate");
        Long id = null;
        UserService instance = new UserService();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.activate(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of deactivate method, of class UserService.
     */
    @Test
    public void testDeactivate() {
        System.out.println("deactivate");
        Long id = null;
        UserService instance = new UserService();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.deactivate(id);
        assertEquals(expResult, result);
        
        
    }
    
}
