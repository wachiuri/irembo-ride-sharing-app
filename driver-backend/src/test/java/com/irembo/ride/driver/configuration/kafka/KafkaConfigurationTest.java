/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.configuration.kafka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.kafka.core.KafkaAdmin;

/**
 *
 * @author Timothy Wachiuri
 */
public class KafkaConfigurationTest {
    
    public KafkaConfigurationTest() {
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
     * Test of topic method, of class KafkaConfiguration.
     */
    @Test
    public void testTopic() {
        System.out.println("topic");
        KafkaConfiguration instance = new KafkaConfiguration();
        KafkaAdmin.NewTopics expResult = null;
        KafkaAdmin.NewTopics result = instance.topic();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of listenDriverMatch method, of class KafkaConfiguration.
     */
    @Test
    public void testListenDriverMatch() {
        System.out.println("listenDriverMatch");
        String in = "";
        KafkaConfiguration instance = new KafkaConfiguration();
        instance.listenDriverMatch(in);
        
        
    }
    
}
