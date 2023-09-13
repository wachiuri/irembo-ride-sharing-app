/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.driver;

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
@Suite.SuiteClasses({com.irembo.ride.driver.user.UserSuite.class, com.irembo.ride.driver.driver.DriverSuite.class, com.irembo.ride.driver.DriverApplicationTest.class, com.irembo.ride.driver.configuration.ConfigurationSuite.class, com.irembo.ride.driver.rider.RiderSuite.class, com.irembo.ride.driver.websocket.WebsocketSuite.class, com.irembo.ride.driver.driverlocation.DriverlocationSuite.class})
public class DriverSuite {

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
