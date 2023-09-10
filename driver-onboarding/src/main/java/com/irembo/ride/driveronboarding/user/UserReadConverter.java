package com.irembo.ride.driveronboarding.user;

import com.irembo.ride.driveronboarding.driver.Driver;
import com.irembo.ride.driveronboarding.rider.Rider;
import io.r2dbc.spi.Row;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.Instant;

@Slf4j
@ReadingConverter
public class UserReadConverter implements Converter<Row, User> {
    @Override
    public User convert(Row source) {

        source.getMetadata().getColumnMetadatas().stream().map(
                col -> "column ".concat(col.getName()).concat(" ").concat(source.get(col.getName(), col.getJavaType()) != null ? source.get(col.getName(), col.getJavaType()).toString() : "")
        ).forEach(log::trace);

        User user = new User();
        user.setId(source.get("id", Long.class));
        user.setEmail(source.get("email", String.class));
        user.setPhoneNumber(source.get("phoneNumber", String.class));
        user.setPassword(source.get("password", String.class));
        user.setFirstName(source.get("firstName", String.class));
        user.setLastName(source.get("lastName", String.class));
        user.setProfilePicture(source.get("profilePicture", String.class));
        user.setActive(source.get("active", Boolean.class));
        user.setCreatedDate(source.get("createdDate") != null ? source.get("createdDate", Instant.class) : null);
        user.setModifiedDate(source.get("createdDate") != null ? source.get("modifiedDate", Instant.class) : null);
        user.setUserType(source.get("userType", String.class) != null ? UserType.valueOf(source.get("userType", String.class)) : null);

        if (source.get("driver_id", Long.class) != null) {
            Driver driver = Driver.builder()
                    .address(source.get("address", String.class))
                    .licenseNumber(source.get("licenseNumber", String.class))
                    .vehicleMake(source.get("vehicleMake", String.class))
                    .vehicleModel(source.get("vehicleModel", String.class))
                    .vehicleCc(source.get("vehicleCc", String.class) != null ? Integer.parseInt(source.get("vehicleCc", String.class)) : null)
                    .yom(source.get("yom", Integer.class))
                    .vehicleColor(source.get("vehicleColor", String.class))
                    .vehicleImage(source.get("vehicleImage", String.class))
                    .build();
            driver.setId(source.get("driver_id", Long.class));
            user.setDriver(driver);
        }

        if (source.get("rider_id", Long.class) != null) {
            Rider rider = new Rider();
            rider.setId(source.get("rider_id", Long.class));
            user.setRider(rider);
        }
        return user;

    }
}
