package com.irembo.ride.driveronboarding.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irembo.ride.driveronboarding.rider.Rider;
import com.irembo.ride.driveronboarding.driver.Driver;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "user",
        indexes = {
                @Index(name = "unique_email", columnList = "email", unique = true)
        }
)
public class User implements Serializable {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "email")
    private String email;

    private String phoneNumber;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastName;

    private String profilePicture;

    private boolean active = true;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Instant modifiedDate;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name="rider_id")
    private Rider rider;

}
