package com.irembo.ride.driveronboarding.configuration.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessfulLoginResponse {

    private String token;
    private int status;
}
