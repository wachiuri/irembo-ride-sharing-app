package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    @Query(
            "SELECT " +
                    "u.id,u.email,u.phoneNumber,u.password,u.firstName,u.lastName,u.profilePicture,u.active,u.createdDate,u.modifiedDate,u.userType, " +
                    "d.id as driver_id,d.address,d.licenseNumber,d.vehicleMake,d.vehicleModel,d.vehicleCc,d.yom,d.vehicleColor,d.vehicleImage, " +
                    "r.id as rider_id " +
                    "FROM User u " +
                    "LEFT JOIN Driver d ON u.driver_id=d.id " +
                    "LEFT JOIN Rider r ON u.rider_id=r.id " +
                    "WHERE u.email = :email"
    )
    public Mono<User> findByEmail(@Param("email") String email);

    @Query(
            "SELECT " +
            "u.id,u.email,u.phoneNumber,u.password,u.firstName,u.lastName,u.profilePicture,u.active,u.createdDate,u.modifiedDate,u.userType, " +
            "d.id as driver_id,d.address,d.licenseNumber,d.vehicleMake,d.vehicleModel,d.vehicleCc,d.yom,d.vehicleColor,d.vehicleImage, " +
            "r.id as rider_id " +
            "FROM User u " +
            "LEFT JOIN Driver d ON u.driver_id=d.id " +
            "LEFT JOIN Rider r ON u.rider_id=r.id " +
            "WHERE u.id = :id"
    )
    public Mono<User> findById(@Param("id") Long id);

    @Query(
            "SELECT " +
                    "u.id,u.email,u.phoneNumber,u.password,u.firstName,u.lastName,u.profilePicture,u.active,u.createdDate,u.modifiedDate,u.userType, " +
                    "d.id as driver_id,d.address,d.licenseNumber,d.vehicleMake,d.vehicleModel,d.vehicleCc,d.yom,d.vehicleColor,d.vehicleImage, " +
                    "r.id as rider_id " +
                    "FROM User u " +
                    "LEFT JOIN Driver d ON u.driver_id=d.id " +
                    "LEFT JOIN Rider r ON u.rider_id=r.id " +
                    "WHERE u.userType = :userType"
    )
    public Flux<User> findByUserType(@Param("userType") UserType userType, Pageable pageable);
}
