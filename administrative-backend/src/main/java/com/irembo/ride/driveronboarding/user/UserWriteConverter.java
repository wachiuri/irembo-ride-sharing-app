package com.irembo.ride.driveronboarding.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.r2dbc.core.Parameter;

import java.time.Instant;

@WritingConverter
@Slf4j
public class UserWriteConverter implements Converter<User, OutboundRow> {

    @Override
    public OutboundRow convert(User source) {

        log.trace("converting {}", source);

        OutboundRow row = new OutboundRow();

        row.put("id", Parameter.fromOrEmpty(source.getId(), Long.class));
        row.put("email", Parameter.fromOrEmpty(source.getEmail(), String.class));
        row.put("phoneNumber", Parameter.fromOrEmpty(source.getPhoneNumber(), String.class));
        row.put("password", Parameter.fromOrEmpty(source.getPassword(), String.class));
        row.put("firstName", Parameter.fromOrEmpty(source.getFirstName(), String.class));
        row.put("lastName", Parameter.fromOrEmpty(source.getLastName(), String.class));
        row.put("profilePicture", Parameter.fromOrEmpty(source.getProfilePicture(), String.class));
        row.put("active", Parameter.fromOrEmpty(source.isActive(), Boolean.class));
        row.put("createdDate", Parameter.fromOrEmpty(source.getCreatedDate(), Instant.class));
        row.put("modifiedDate", Parameter.fromOrEmpty(source.getModifiedDate(), Instant.class));
        row.put("userType", Parameter.fromOrEmpty(source.getUserType(), String.class));
        if (source.getDriver() != null) {
            row.put("driver_id", Parameter.fromOrEmpty(source.getDriver().getId(), Long.class));
        }
        if (source.getRider() != null) {
            row.put("rider_id", source.getRider() != null ? Parameter.fromOrEmpty(source.getRider().getId(), Long.class) : null);
        }

        log.trace("converted {}", row);
        return row;
    }
}
