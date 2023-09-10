package com.irembo.ride.driveronboarding.configuration.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Class that extends AbstractAuthenticationToken and returns JWT token on the overridden methods
 */
public class BearerToken extends AbstractAuthenticationToken {
    private final String token;

    public BearerToken(String token) {

        super(AuthorityUtils.NO_AUTHORITIES);
        this.token = token;
    }

    @Override
    public String getCredentials() {
        return this.token;
    }

    @Override
    public String getPrincipal() {
        return this.token;
    }
}