package com.irembo.ride.trip.driverlocation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverLocation {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String licenseNumber;

    private String vehicleMake;

    private String vehicleModel;

    private Integer vehicleCc;

    private Integer yom;

    private String vehicleColor;

    private String profilePicture;

    private String vehicleImage;

    private Double lat;

    private Double lng;

    private String cellAddress;
}
