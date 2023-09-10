package com.irembo.ride.driveronboarding.permission;

import com.irembo.ride.driveronboarding.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService extends BaseService<Permission, Long> {

    @Autowired
    private PermissionRepository repository;

    protected PermissionRepository getRepository() {
        return repository;
    }

}
