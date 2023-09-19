package com.irembo.ride.trip.driverlocation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DriverLocationService {

    @Autowired
    private DriverLocationRepository repository;

    public Mono<DriverLocation> save(DriverLocation driverLocation) {

        return repository.findByUserDriverId(driverLocation.getUser().getDriver().getId())
                .switchIfEmpty(Mono.just(driverLocation))
                .map(a->{
                    a.setLat(driverLocation.getLat());
                    a.setLng(driverLocation.getLng());
                    a.setCellAddress(driverLocation.getCellAddress());
                    return a;
                })
                .flatMap(a->repository.save(a));
    }

}
