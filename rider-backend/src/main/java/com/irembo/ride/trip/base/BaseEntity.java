package com.irembo.ride.trip.base;

import com.irembo.ride.trip.user.User;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public abstract class BaseEntity implements Serializable {

    private Long id;

    private User createdBy;

    private Instant createdDate;

    private User modifiedBy;

    private Instant modifiedDate;
}
