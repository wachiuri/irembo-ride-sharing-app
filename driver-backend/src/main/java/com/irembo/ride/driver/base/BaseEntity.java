package com.irembo.ride.driver.base;

import com.irembo.ride.driver.user.User;
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
