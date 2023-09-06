package com.irembo.ride.driveronboarding.driver;

import com.irembo.ride.driveronboarding.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DriverRepository extends BaseRepository<Driver, Long> {

    Flux<Driver> findAllBy(Pageable pageable);
}
