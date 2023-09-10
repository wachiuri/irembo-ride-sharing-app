package com.irembo.ride.driveronboarding.base;

import com.irembo.ride.driveronboarding.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "createdBy_id")
    private User createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdDate;

    @LastModifiedBy
    @ManyToOne
    @JoinColumn(name = "modifiedBy_id")
    private User modifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Instant modifiedDate;
}
