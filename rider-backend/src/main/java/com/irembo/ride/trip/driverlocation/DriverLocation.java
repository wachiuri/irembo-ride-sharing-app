package com.irembo.ride.trip.driverlocation;

import com.irembo.ride.trip.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class DriverLocation {

    @Id
    private String id;

    private User user;

    private Double lat;

    private Double lng;

    private String cellAddress;
}
