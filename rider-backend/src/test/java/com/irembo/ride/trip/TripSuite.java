/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.trip;

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
@Suite.SuiteClasses({com.irembo.ride.trip.rider.RiderSuite.class, com.irembo.ride.trip.websocket.WebsocketSuite.class, com.irembo.ride.trip.driver.DriverSuite.class, com.irembo.ride.trip.configuration.ConfigurationSuite.class, com.irembo.ride.trip.request.RequestSuite.class, com.irembo.ride.trip.user.UserSuite.class, com.irembo.ride.trip.TripApplicationTest.class, com.irembo.ride.trip.driverlocation.DriverlocationSuite.class})
public class TripSuite {

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
