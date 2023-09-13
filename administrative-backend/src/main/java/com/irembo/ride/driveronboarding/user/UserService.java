package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.base.BaseService;
import com.irembo.ride.driveronboarding.driver.Driver;
import com.irembo.ride.driveronboarding.driver.DriverService;
import com.irembo.ride.driveronboarding.rider.Rider;
import com.irembo.ride.driveronboarding.rider.RiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Slf4j
@Service
public class UserService extends BaseService<User, Long> {

    @Autowired
    private UserRepository repository;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RiderService riderService;

    protected UserRepository getRepository() {
        return repository;
    }

    public Mono<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Mono<User> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Page<User>> findByUserType(UserType userType, int pageIndex, int size) {
        return repository.findByUserType(userType, size, pageIndex * size)
                .collectList()
                .zipWith(repository.countByUserType(userType))
                .map(t -> {
                    log.trace("total {}, count {}", t.getT2(), t.getT1().size());
                    return new PageImpl<User>(t.getT1(), PageRequest.of(pageIndex, size), t.getT2());
                });
    }

    @Override
    public Mono<User> save(User user) {

        log.trace("saving user {}", user);

        return Mono.justOrEmpty(user)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("User cannot be null")))
                .map(u -> {
                            log.trace("encoding password");
                            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                            if (u.getId() == null) {
                                u.setPassword(passwordEncoder.encode(u.getPassword()));
                            }
                            return u;
                        }
                )
                .zipWhen(u -> u.getDriver() != null ? driverService.save(u.getDriver()) : Mono.just(u))
                .map(tuple -> {
                    log.trace("user {}", tuple.getT1());
                    log.trace("driver {}", tuple.getT2());
                    if (tuple.getT2() instanceof Driver) {
                        tuple.getT1().setDriver((Driver) tuple.getT2());
                    }
                    return tuple.getT1();
                })
                .zipWhen(u -> u.getRider() != null ? riderService.save(u.getRider()) : Mono.just(u))
                .map(tuple -> {
                    log.trace("user {}", tuple.getT1());
                    log.trace("rider {}", tuple.getT2());
                    if (tuple.getT2() instanceof Rider) {
                        tuple.getT1().setRider((Rider) tuple.getT2());
                    }
                    return tuple.getT1();
                })
                .zipWhen(u -> repository.save(u))
                .map(Tuple2::getT2)
                .zipWhen(u -> this.findById(u.getId()))
                .map(Tuple2::getT2)
                ;
    }

    public Mono<Void> activate(Long id) {
        return repository.activate(id);
    }

    public Mono<Void> deactivate(Long id) {
        return repository.deactivate(id);
    }
}
