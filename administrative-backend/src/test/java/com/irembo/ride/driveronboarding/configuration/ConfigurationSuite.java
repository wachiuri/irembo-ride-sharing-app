/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration;

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
@Suite.SuiteClasses({com.irembo.ride.driveronboarding.configuration.security.SecuritySuite.class, com.irembo.ride.driveronboarding.configuration.WebConfigTest.class, com.irembo.ride.driveronboarding.configuration.jpa.JpaSuite.class, com.irembo.ride.driveronboarding.configuration.ApplicationConfigurationTest.class, com.irembo.ride.driveronboarding.configuration.R2dbcApplicationConfigurationTest.class})
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
