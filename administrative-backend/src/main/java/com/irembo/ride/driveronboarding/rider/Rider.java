package com.irembo.ride.driveronboarding.rider;

import com.irembo.ride.driveronboarding.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@AllArgsConstructor
@Builder
@Table(name = "rider")
public class Rider extends BaseEntity {

}
