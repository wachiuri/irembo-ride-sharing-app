package com.irembo.ride.trip.driverlocation;

import com.irembo.ride.trip.driver.Driver;
import com.irembo.ride.trip.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverLocation {

    private User user;

    private Double lat;

    private Double lng;

    private String cellAddress;
}
