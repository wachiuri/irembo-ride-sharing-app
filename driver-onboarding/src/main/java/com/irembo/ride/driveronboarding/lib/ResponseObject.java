package com.irembo.ride.driveronboarding.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {

    private int status;
    private String message;
}
