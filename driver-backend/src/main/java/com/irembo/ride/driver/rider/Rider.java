package com.irembo.ride.driver.rider;

import com.irembo.ride.driver.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rider {

    private Long id;

    private User createdBy;

    private Instant createdDate;

    private User modifiedBy;

    private Instant modifiedDate;
}
