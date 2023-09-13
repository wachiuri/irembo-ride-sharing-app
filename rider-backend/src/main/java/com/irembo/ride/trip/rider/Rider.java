package com.irembo.ride.trip.rider;

import com.irembo.ride.trip.base.BaseEntity;
import com.irembo.ride.trip.user.User;
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
