/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.driveronboarding.userpermission;

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
@Suite.SuiteClasses({com.irembo.ride.driveronboarding.userpermission.UserPermissionTest.class, com.irembo.ride.driveronboarding.userpermission.UserPermissionRepositoryTest.class, com.irembo.ride.driveronboarding.userpermission.UserPermissionControllerTest.class, com.irembo.ride.driveronboarding.userpermission.UserPermissionServiceTest.class})
public class UserpermissionSuite {

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
