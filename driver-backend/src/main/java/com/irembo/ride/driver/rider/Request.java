package com.irembo.ride.driver.rider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private Rider rider;

    private Double departureLatitude;

    private Double departureLongitude;

    private Double arrivalLatitude;

    private Double arrivalLongitude;

}
