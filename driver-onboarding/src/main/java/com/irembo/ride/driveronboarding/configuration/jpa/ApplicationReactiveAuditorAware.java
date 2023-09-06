package com.irembo.ride.driveronboarding.configuration.jpa;

import com.irembo.ride.driveronboarding.configuration.security.UserDetailsImpl;
import com.irembo.ride.driveronboarding.user.User;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

public class ApplicationReactiveAuditorAware implements ReactiveAuditorAware<User> {

    @Override
    public Mono<User> getCurrentAuditor() {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .cast(UserDetailsImpl.class)
                .map(UserDetailsImpl::getUser)
                ;
    }
}
