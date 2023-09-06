package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.base.BaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    public Mono<User> findByEmail(String email);
}
