package com.irembo.ride.driveronboarding.driver;

import com.irembo.ride.driveronboarding.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends BaseService<Driver, Long> {

    @Autowired
    private DriverRepository repository;

    protected DriverRepository getRepository() {
        return repository;
    }
}
