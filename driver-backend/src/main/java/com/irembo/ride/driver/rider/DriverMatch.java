package com.irembo.ride.driver.rider;

import com.irembo.ride.driver.driverlocation.DriverLocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverMatch {

    private DriverMatchStage stage;
    private Request request;
    private DriverLocation driverLocation;
}
