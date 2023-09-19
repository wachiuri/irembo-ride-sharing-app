package com.irembo.ride.trip.driverlocation;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DriverLocationRepository extends ReactiveMongoRepository<DriverLocation, String> {

    public Flux<DriverLocation> findByCellAddress(String cellAddress);

    public Flux<DriverLocation> findByCellAddressIn(Iterable<String> addresses);

    public Mono<DriverLocation> findByUserDriverId(Long id);
}
