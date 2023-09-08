package com.irembo.ride.driveronboarding.configuration.security;

import com.irembo.ride.driveronboarding.user.UserService;
import com.irembo.ride.driveronboarding.userpermission.UserPermission;
import com.irembo.ride.driveronboarding.userpermission.UserPermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ApplicationReactiveUserDetailsService implements ReactiveUserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Override
    public Mono<UserDetails> findByUsername(String email) {

        logger.debug("logging in with user name {}", email);

        return userService.findByEmail(email)
                .zipWhen(u -> userPermissionRepository.findByUser(u).collectList())
                .flatMap(tuple2 -> {
                    UserDetailsImpl userDetails = UserDetailsImpl.builder()
                            .accountNonExpired(tuple2.getT1().isActive())
                            .username(tuple2.getT1().getEmail())
                            .password(tuple2.getT1().getPassword())
                            .accountNonLocked(tuple2.getT1().isActive())
                            .enabled(tuple2.getT1().isActive())
                            .credentialsNonExpired(tuple2.getT1().isActive())
                            .user(tuple2.getT1())
                            .build();

                    for (UserPermission permissionGroup : tuple2.getT2()) {

                        ApplicationGrantedAuthority authority = new GrantedAuthorityImpl(
                                permissionGroup.getPermission().getPermission()
                        );
                        userDetails.getAuthorities().add(authority);
                    }

                    logger.debug("User details: {}", userDetails);

                    return Mono.just(userDetails);

                });
    }
}
