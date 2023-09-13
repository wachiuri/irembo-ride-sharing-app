/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.irembo.ride.driveronboarding.configuration.security;

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
@Suite.SuiteClasses({com.irembo.ride.driveronboarding.configuration.security.GrantedAuthorityImplTest.class, com.irembo.ride.driveronboarding.configuration.security.BearerTokenTest.class, com.irembo.ride.driveronboarding.configuration.security.ApplicationServerAuthenticationSuccessHandlerTest.class, com.irembo.ride.driveronboarding.configuration.security.ApplicationWebSecurityConfigurerTest.class, com.irembo.ride.driveronboarding.configuration.security.ApplicationGrantedAuthorityTest.class, com.irembo.ride.driveronboarding.configuration.security.JWTServiceTest.class, com.irembo.ride.driveronboarding.configuration.security.SecurityConfigurationTest.class, com.irembo.ride.driveronboarding.configuration.security.AuthConverterTest.class, com.irembo.ride.driveronboarding.configuration.security.ApplicationReactiveUserDetailsServiceTest.class, com.irembo.ride.driveronboarding.configuration.security.UserDetailsImplTest.class, com.irembo.ride.driveronboarding.configuration.security.ApplicationServerAuthenticationFailureHandlerTest.class, com.irembo.ride.driveronboarding.configuration.security.AuthManagerTest.class, com.irembo.ride.driveronboarding.configuration.security.SuccessfulLoginResponseTest.class})
public class SecuritySuite {

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
