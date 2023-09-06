package com.irembo.ride.driveronboarding.userpermission;

import com.irembo.ride.driveronboarding.base.BaseEntity;
import com.irembo.ride.driveronboarding.permission.Permission;
import com.irembo.ride.driveronboarding.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "user_permission",
        indexes = {
            @Index(name = "unique_user_permission", columnList = "user_id,permission_id", unique = true),
        }
)
public class UserPermission extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="permission_id")
    private Permission permission;
}
