package com.irembo.ride.driveronboarding.permission;

import com.irembo.ride.driveronboarding.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {

    Flux<Permission> findAllBy(Pageable pageable);
}
