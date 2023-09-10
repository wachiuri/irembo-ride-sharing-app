package com.irembo.ride.driveronboarding.userpermission;

import com.irembo.ride.driveronboarding.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService extends BaseService<UserPermission, Long> {

    @Autowired
    private UserPermissionRepository repository;

    protected UserPermissionRepository getRepository() {
        return repository;
    }
}
