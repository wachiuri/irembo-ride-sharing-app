/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.base;

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
public class BaseServiceTest {
    
    public BaseServiceTest() {
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
     * Test of getRepository method, of class BaseService.
     */
    @Test
    public void testGetRepository() {
        System.out.println("getRepository");
        BaseService instance = new BaseServiceImpl();
        Object expResult = null;
        Object result = instance.getRepository();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findAll method, of class BaseService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        int pageIndex = 0;
        int size = 0;
        BaseService instance = new BaseServiceImpl();
        Mono<Page<Object>> expResult = null;
        Mono<Page<Object>> result = instance.findAll(pageIndex, size);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findById method, of class BaseService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Object id = null;
        BaseService instance = new BaseServiceImpl();
        Mono expResult = null;
        Mono result = instance.findById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of deleteById method, of class BaseService.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Object id = null;
        BaseService instance = new BaseServiceImpl();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.deleteById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of save method, of class BaseService.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Object entity = null;
        BaseService instance = new BaseServiceImpl();
        Mono expResult = null;
        Mono result = instance.save(entity);
        assertEquals(expResult, result);
        
        
    }

    public class BaseServiceImpl extends BaseService {

        public BaseRepository getRepository() {
            return null;
        }
    }
    
}
