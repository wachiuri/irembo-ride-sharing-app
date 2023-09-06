package com.irembo.ride.driveronboarding.permission;

import com.irembo.ride.driveronboarding.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "permission")
public class Permission extends BaseEntity {

    private String permission;
}
