package com.irembo.ride.driver.driver;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {

    private Long id;

    private String address;

    private String licenseNumber;

    private String vehicleMake;

    private String vehicleModel;

    private Integer vehicleCc;

    @Min(2009)
    @Max(2100)
    private Integer yom;

    private String vehicleColor;

    private String vehicleImage;
}
