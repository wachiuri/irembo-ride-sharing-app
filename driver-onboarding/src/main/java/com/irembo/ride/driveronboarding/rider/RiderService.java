package com.irembo.ride.driveronboarding.rider;

import com.irembo.ride.driveronboarding.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RiderService extends BaseService<Rider, Long> {

    private RiderRepository repository;

    @Override
    protected RiderRepository getRepository() {
        return repository;
    }
}
