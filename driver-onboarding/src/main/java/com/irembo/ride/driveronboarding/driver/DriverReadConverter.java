package com.irembo.ride.driveronboarding.driver;

import io.r2dbc.spi.Row;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.Instant;

@Slf4j
@ReadingConverter
public class DriverReadConverter implements Converter<Row, Driver> {
    @Override
    public Driver convert(Row source) {

        source.getMetadata().getColumnMetadatas().forEach(columnMetadata -> {
            log.trace("columnMetadata {}", columnMetadata.getName());
        });

        Driver driver = Driver.builder()
                .name(source.get("name", String.class))
                .email(source.get("email", String.class))
                .pin(source.get("pin", Integer.class))
                .phoneNumber(source.get("phoneNumber", String.class))
                .address(source.get("address", String.class))
                .licenseNumber(source.get("licenseNumber", String.class))
                .vehicleMake(source.get("vehicleMake", String.class))
                .vehicleModel(source.get("vehicleModel", String.class))
                .vehicleCc(Integer.valueOf(source.get("vehicleCc", String.class)))
                .yom(source.get("yom", Integer.class))
                .vehicleColor(source.get("vehicleColor", String.class))
                .profilePicture(source.get("profilePicture", String.class))
                .vehicleImage(source.get("vehicleImage", String.class))
                .build();

        driver.setId(source.get("id", Long.class));
        driver.setCreatedDate(source.get("createdDate", Instant.class));
        driver.setModifiedDate(source.get("modifiedDate", Instant.class));

        /*log.trace("createdBy_id {}", source.get("createdBy_id", Long.class));
        if (source.get("createdBy_id", Long.class) != null) {
            User createdBy = new User();
            createdBy.setId(source.get("createdBy_id", Long.class));
            driver.setCreatedBy(createdBy);
        }

        log.trace("modifiedBy_id {}", source.get("modifiedBy_id", Long.class));
        if (source.get("modifiedBy_id", Long.class) != null) {
            User modifiedBy = new User();
            modifiedBy.setId(source.get("modifiedBy_id", Long.class));
            driver.setModifiedBy(modifiedBy);
        }*/

        return driver;
    }
}
