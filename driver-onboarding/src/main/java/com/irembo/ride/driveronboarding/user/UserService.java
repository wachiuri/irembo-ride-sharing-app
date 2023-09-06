package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService extends BaseService<User, Long> {

    @Autowired
    private UserRepository repository;

    protected UserRepository getRepository() {
        return repository;
    }

    public Mono<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
