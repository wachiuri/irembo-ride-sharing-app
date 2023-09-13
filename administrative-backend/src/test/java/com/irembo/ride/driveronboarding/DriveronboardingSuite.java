/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.driveronboarding;

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
@Suite.SuiteClasses({com.irembo.ride.driveronboarding.userpermission.UserpermissionSuite.class, com.irembo.ride.driveronboarding.base.BaseSuite.class, com.irembo.ride.driveronboarding.RideApplicationTest.class, com.irembo.ride.driveronboarding.lib.LibSuite.class, com.irembo.ride.driveronboarding.permission.PermissionSuite.class, com.irembo.ride.driveronboarding.configuration.ConfigurationSuite.class, com.irembo.ride.driveronboarding.driver.DriverSuite.class, com.irembo.ride.driveronboarding.rider.RiderSuite.class, com.irembo.ride.driveronboarding.user.UserSuite.class})
public class DriveronboardingSuite {

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
