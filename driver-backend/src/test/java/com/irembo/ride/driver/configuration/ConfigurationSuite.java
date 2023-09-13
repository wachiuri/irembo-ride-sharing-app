/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.driver.configuration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Timothy Wachiuri
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.irembo.ride.driver.configuration.AuthManagerTest.class, com.irembo.ride.driver.configuration.WebConfigTest.class, com.irembo.ride.driver.configuration.JWTServiceTest.class, com.irembo.ride.driver.configuration.kafka.KafkaSuite.class, com.irembo.ride.driver.configuration.websocket.WebsocketSuite.class, com.irembo.ride.driver.configuration.SecurityConfigurationTest.class, com.irembo.ride.driver.configuration.BearerTokenTest.class, com.irembo.ride.driver.configuration.AuthConverterTest.class})
public class ConfigurationSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
