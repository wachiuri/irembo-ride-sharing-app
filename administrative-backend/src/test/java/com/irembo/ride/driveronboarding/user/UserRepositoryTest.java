/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driveronboarding.user;

import java.util.function.Function;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Timothy Wachiuri
 */
public class UserRepositoryTest {
    
    public UserRepositoryTest() {
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
     * Test of findByEmail method, of class UserRepository.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        UserRepository instance = new UserRepositoryImpl();
        Mono<User> expResult = null;
        Mono<User> result = instance.findByEmail(email);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findById method, of class UserRepository.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        UserRepository instance = new UserRepositoryImpl();
        Mono<User> expResult = null;
        Mono<User> result = instance.findById(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of findByUserType method, of class UserRepository.
     */
    @Test
    public void testFindByUserType() {
        System.out.println("findByUserType");
        UserType userType = null;
        int size = 0;
        int offset = 0;
        UserRepository instance = new UserRepositoryImpl();
        Flux<User> expResult = null;
        Flux<User> result = instance.findByUserType(userType, size, offset);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of countByUserType method, of class UserRepository.
     */
    @Test
    public void testCountByUserType() {
        System.out.println("countByUserType");
        UserType userType = null;
        UserRepository instance = new UserRepositoryImpl();
        Mono<Long> expResult = null;
        Mono<Long> result = instance.countByUserType(userType);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of activate method, of class UserRepository.
     */
    @Test
    public void testActivate() {
        System.out.println("activate");
        Long id = null;
        UserRepository instance = new UserRepositoryImpl();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.activate(id);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of deactivate method, of class UserRepository.
     */
    @Test
    public void testDeactivate() {
        System.out.println("deactivate");
        Long id = null;
        UserRepository instance = new UserRepositoryImpl();
        Mono<Void> expResult = null;
        Mono<Void> result = instance.deactivate(id);
        assertEquals(expResult, result);
        
        
    }

    public class UserRepositoryImpl implements UserRepository {

        public Mono<User> findByEmail(String email) {
            return null;
        }

        public Mono<User> findById(Long id) {
            return null;
        }

        public Flux<User> findByUserType(UserType userType, int size, int offset) {
            return null;
        }

        public Mono<Long> countByUserType(UserType userType) {
            return null;
        }

        public Mono<Void> activate(Long id) {
            return null;
        }

        public Mono<Void> deactivate(Long id) {
            return null;
        }

        @Override
        public Flux<User> findAllBy(Pageable pageable) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Mono<S> save(S entity) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Flux<S> saveAll(Iterable<S> entities) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Flux<S> saveAll(Publisher<S> entityStream) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<User> findById(Publisher<Long> id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Boolean> existsById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Boolean> existsById(Publisher<Long> id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Flux<User> findAll() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Flux<User> findAllById(Iterable<Long> ids) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Flux<User> findAllById(Publisher<Long> idStream) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Long> count() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Void> deleteById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Void> deleteById(Publisher<Long> id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Void> delete(User entity) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Void> deleteAllById(Iterable<? extends Long> ids) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Void> deleteAll(Iterable<? extends User> entities) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Void> deleteAll(Publisher<? extends User> entityStream) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Mono<Void> deleteAll() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Flux<User> findAll(Sort sort) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Mono<S> findOne(Example<S> example) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Flux<S> findAll(Example<S> example) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Flux<S> findAll(Example<S> example, Sort sort) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Mono<Long> count(Example<S> example) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User> Mono<Boolean> exists(Example<S> example) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public <S extends User, R, P extends Publisher<R>> P findBy(Example<S> example, Function<FluentQuery.ReactiveFluentQuery<S>, P> queryFunction) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
    
}
