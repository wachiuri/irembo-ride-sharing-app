package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.base.BaseService;
import com.irembo.ride.driveronboarding.driver.DriverService;
import com.irembo.ride.driveronboarding.rider.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Flux<User> findByUserType(UserType userType, int pageIndex, int size) {
        return repository.findByUserType(userType, Pageable.ofSize(size).withPage(pageIndex + 1));
    }

    @Override
    public Mono<User> save(User user) {

        if(user.getDriver()!=null){
           driverService.save(user.getDriver());
        }

        if(user.getRider()!=null){
            riderService.save(user.getRider());
        }
        return super.save(user);
    }
}
