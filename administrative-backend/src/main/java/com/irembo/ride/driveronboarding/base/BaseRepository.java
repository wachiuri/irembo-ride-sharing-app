package com.irembo.ride.driveronboarding.base;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.NoRepositoryBean;
import reactor.core.publisher.Flux;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends R2dbcRepository<T, ID> {

    public Flux<T> findAllBy(Pageable pageable);
}
