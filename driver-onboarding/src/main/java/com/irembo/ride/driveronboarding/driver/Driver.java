package com.irembo.ride.driveronboarding.driver;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irembo.ride.driveronboarding.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
                @Index(name = "unique_email", columnList = "email", unique = true),
                @Index(name = "unique_phone_number", columnList = "phoneNumber", unique = true),
                @Index(name = "unique_license_number", columnList = "licenseNumber", unique = true)
        }
)
public class Driver extends BaseEntity {

    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Min(1000)
    @Max(9999)
    @JsonIgnore
    private Integer pin;

    @Column(name = "phoneNumber")
    private String phoneNumber;

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

    private String profilePicture;

    private String vehicleImage;
}
