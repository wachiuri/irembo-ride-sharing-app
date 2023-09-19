package com.irembo.ride.driver.driverlocation;

import com.irembo.ride.driver.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverLocation {

    private String id;

    private User user;

    private Double lat;

    private Double lng;

    private String cellAddress;
}
