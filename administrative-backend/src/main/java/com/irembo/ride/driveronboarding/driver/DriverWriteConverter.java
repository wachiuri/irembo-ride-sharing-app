package com.irembo.ride.driveronboarding.driver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.r2dbc.core.Parameter;

import java.time.Instant;

@Slf4j
@WritingConverter
public class DriverWriteConverter implements Converter<Driver, OutboundRow> {

    @Override
    public OutboundRow convert(Driver driver) {

        log.trace("converting {}", driver);

        OutboundRow row = new OutboundRow();

        row.append("id", driver.getId() != null ? Parameter.from(driver.getId()) : Parameter.empty(Long.class))
                .append("address", Parameter.from(driver.getAddress() != null ? driver.getAddress() : ""))
                .append("licenseNumber", Parameter.from(driver.getLicenseNumber() != null ? driver.getLicenseNumber() : ""))
                .append("vehicleMake", Parameter.from(driver.getVehicleMake() != null ? driver.getVehicleMake() : ""))
                .append("vehicleModel", Parameter.from(driver.getVehicleModel() != null ? driver.getVehicleModel() : ""))
                .append("vehicleCc", Parameter.from(driver.getVehicleCc() != null ? driver.getVehicleCc() : 0))
                .append("yom", Parameter.from(driver.getYom() != null ? driver.getYom() : 0))
                .append("vehicleColor", Parameter.from(driver.getVehicleColor() != null ? driver.getVehicleColor() : ""))
                .append("vehicleImage", Parameter.from(driver.getVehicleImage() != null ? driver.getVehicleImage() : ""))
                .append("createdBy_id", driver.getCreatedBy() != null ? Parameter.from(driver.getCreatedBy().getId()) : Parameter.empty(Long.class))
                .append("createdDate", driver.getCreatedDate() != null ? Parameter.from(driver.getCreatedDate()) : Parameter.empty(Instant.class))
                .append("modifiedBy_id", driver.getModifiedBy() != null ? Parameter.from(driver.getModifiedBy().getId()) : Parameter.empty(Long.class))
                .append("modifiedDate",driver.getModifiedDate() != null ? Parameter.from(driver.getModifiedDate()): Parameter.empty(Instant.class))
        ;

        log.trace("outbound row {}", row);

        return row;
    }
}
