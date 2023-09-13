/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.trip.configuration;

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
@Suite.SuiteClasses({com.irembo.ride.trip.configuration.AuthConverterTest.class, com.irembo.ride.trip.configuration.JWTServiceTest.class, com.irembo.ride.trip.configuration.WebConfigTest.class, com.irembo.ride.trip.configuration.SecurityConfigurationTest.class, com.irembo.ride.trip.configuration.websocket.WebsocketSuite.class, com.irembo.ride.trip.configuration.AuthManagerTest.class, com.irembo.ride.trip.configuration.kafka.KafkaSuite.class, com.irembo.ride.trip.configuration.BearerTokenTest.class})
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
