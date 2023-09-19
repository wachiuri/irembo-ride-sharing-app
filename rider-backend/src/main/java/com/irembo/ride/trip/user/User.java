package com.irembo.ride.trip.user;

import com.irembo.ride.trip.driver.Driver;
import com.irembo.ride.trip.rider.Rider;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class User implements Serializable {

    @Id
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
