package com.irembo.ride.driver.user;

import com.irembo.ride.driver.driver.Driver;
import com.irembo.ride.driver.rider.Rider;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private Long id;

    @Email
    private String email;

    private String phoneNumber;

    private String password;

    private String firstName;

    private String lastName;

    private String profilePicture;

    private boolean active = true;

    private Instant createdDate;

    private Instant modifiedDate;

    private UserType userType;

    private Driver driver;

    private Rider rider;

}
