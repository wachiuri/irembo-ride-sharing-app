/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.trip.request;

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
@Suite.SuiteClasses({com.irembo.ride.trip.request.DriverMatchTest.class, com.irembo.ride.trip.request.RequestTest.class, com.irembo.ride.trip.request.RequestControllerTest.class, com.irembo.ride.trip.request.RequestServiceTest.class})
public class RequestSuite {

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
