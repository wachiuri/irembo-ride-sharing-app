package com.irembo.ride.trip.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private Long customerId;

    private String name;

    private String phoneNumber;

    private String email;

    private Double departureLatitude;

    private Double departureLongitude;

    private Double arrivalLatitude;

    private Double arrivalLongitude;

}
