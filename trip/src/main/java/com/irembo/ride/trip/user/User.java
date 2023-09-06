package com.irembo.ride.trip.user;

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

    private String password;

    private String firstName;

    private String lastName;

    private boolean active = true;

    private User createdBy;

    private Instant createdDate;

    private User modifiedBy;

    private Instant modifiedDate;

}
