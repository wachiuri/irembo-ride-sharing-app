package com.irembo.ride.trip.request;

import com.irembo.ride.trip.rider.Rider;
import com.irembo.ride.trip.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private String id;

    private User user;

    private Double departureLatitude;

    private Double departureLongitude;

    private Double arrivalLatitude;

    private Double arrivalLongitude;

}
