package com.irembo.ride.driveronboarding.driver;

import com.irembo.ride.driveronboarding.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "driver",
        indexes = {
                @Index(name = "unique_license_number", columnList = "licenseNumber", unique = true)
        }
)
public class Driver extends BaseEntity {

    private String address;

    @Column(name = "licenseNumber")
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