package com.irembo.ride.driver.request;

import com.irembo.ride.driver.user.User;
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
