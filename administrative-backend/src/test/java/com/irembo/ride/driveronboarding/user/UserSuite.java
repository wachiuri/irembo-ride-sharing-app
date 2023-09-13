/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.driveronboarding.user;

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
@Suite.SuiteClasses({com.irembo.ride.driveronboarding.user.UserRepositoryTest.class, com.irembo.ride.driveronboarding.user.UserWriteConverterTest.class, com.irembo.ride.driveronboarding.user.UserTypeTest.class, com.irembo.ride.driveronboarding.user.UserControllerTest.class, com.irembo.ride.driveronboarding.user.UserTest.class, com.irembo.ride.driveronboarding.user.UserServiceTest.class, com.irembo.ride.driveronboarding.user.UserReadConverterTest.class})
public class UserSuite {

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
