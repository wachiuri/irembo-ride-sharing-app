package com.irembo.ride.driveronboarding.userpermission;

import com.irembo.ride.driveronboarding.base.BaseRepository;
import com.irembo.ride.driveronboarding.user.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserPermissionRepository extends BaseRepository<UserPermission, Long> {

    public Flux<UserPermission> findByUser(User user);
}
