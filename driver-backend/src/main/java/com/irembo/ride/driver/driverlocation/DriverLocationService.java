package com.irembo.ride.driver.driverlocation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.irembo.ride.driver.driver.Driver;
import com.irembo.ride.driver.user.User;
import com.irembo.ride.driver.user.UserService;
import com.irembo.ride.driver.user.UserType;
import com.irembo.ride.driver.websocket.WebsocketMessage;
import com.uber.h3core.H3Core;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DriverLocationService {

    private final Map<Long, DriverLocation> driverLocations = new HashMap<>();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private UserService userService;


    public Mono<Void> generate() {
        H3Core h3Core;
        try {
            h3Core = H3Core.newInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driverLocations.put(1000L, DriverLocation.builder()
                .lat(-1.9732436)
                .lng(29.9450825)
                .cellAddress(h3Core.latLngToCellAddress(-1.9732436, 29.9450825, 1))
                .user(
                        User.builder()
                                .email("uwimana@example.com")
                                .id(1000L)
                                .userType(UserType.DRIVER)
                                .firstName("Alex")
                                .lastName("Uwimana")
                                .phoneNumber("+250722830519")
                                .driver(
                                        Driver.builder()
                                                .id(1000L)
                                                .yom(2011)
                                                .address("Runda")
                                                .licenseNumber("RAA001A")
                                                .vehicleMake("Toyota")
                                                .vehicleModel("Vitz")
                                                .vehicleCc(1500)
                                                .vehicleColor("Black")
                                                .build()
                                )
                                .build()
                )
                .build()
        );

        driverLocations.put(1001L, DriverLocation.builder()
                .lat(-2.0415479)
                .lng(29.9588765)
                .cellAddress(h3Core.latLngToCellAddress(-2.0415479, 29.9588765, 1))
                .user(
                        User.builder()
                                .email("niyonsaba@example.com")
                                .id(1001L)
                                .userType(UserType.DRIVER)
                                .firstName("Bernard")
                                .lastName("Niyonsaba")
                                .phoneNumber("+250722830519")
                                .driver(
                                        Driver.builder()
                                                .id(1001L)
                                                .yom(2012)
                                                .address("Rugalika")
                                                .licenseNumber("RAA002A")
                                                .vehicleMake("Toyota")
                                                .vehicleModel("Allion")
                                                .vehicleCc(1600)
                                                .vehicleColor("White")
                                                .build()
                                )
                                .build()
                )
                .build()
        );

        driverLocations.put(1002L, DriverLocation.builder()
                .lat(-1.9732436)
                .lng(29.9450825)
                .cellAddress(h3Core.latLngToCellAddress(-1.9732436, 29.9450825, 1))
                .user(
                        User.builder()
                                .email("niyonsaba@example.com")
                                .id(1002L)
                                .userType(UserType.DRIVER)
                                .firstName("Bernard")
                                .lastName("Niyonsaba")
                                .phoneNumber("+250722830519")
                                .driver(
                                        Driver.builder()
                                                .id(1002L)
                                                .yom(2012)
                                                .address("Rugalika")
                                                .licenseNumber("RAA002A")
                                                .vehicleMake("Toyota")
                                                .vehicleModel("Allion")
                                                .vehicleCc(1600)
                                                .vehicleColor("White")
                                                .build()
                                )
                                .build()
                )
                .build()
        );

        driverLocations.put(1003L, DriverLocation.builder()
                .lat(-2.0289808)
                .lng(30.0246309)
                .cellAddress(h3Core.latLngToCellAddress(-2.0289808, 30.0246309, 1))
                .user(
                        User.builder()
                                .email("mukantagara@example.com")
                                .id(1003L)
                                .userType(UserType.DRIVER)
                                .firstName("Charles")
                                .lastName("Mukantagara")
                                .phoneNumber("+250722750248")
                                .driver(
                                        Driver.builder()
                                                .id(1003L)
                                                .yom(2012)
                                                .address("Butamwa")
                                                .licenseNumber("RAA003A")
                                                .vehicleMake("Toyota")
                                                .vehicleModel("Paso")
                                                .vehicleCc(1600)
                                                .vehicleColor("Red")
                                                .build()
                                )
                                .build()
                )
                .build()
        );

        driverLocations.put(1004L, DriverLocation.builder()
                .lat(-2.0314639)
                .lng(30.0739606)
                .cellAddress(h3Core.latLngToCellAddress(-2.0314639, 30.0739606, 1))
                .user(
                        User.builder()
                                .email("nkurunziza@example.com")
                                .id(1004L)
                                .userType(UserType.DRIVER)
                                .firstName("Dennis")
                                .lastName("Nkurunziza")
                                .phoneNumber("+250722803719")
                                .driver(
                                        Driver.builder()
                                                .id(1004L)
                                                .yom(2012)
                                                .address("Gahanga")
                                                .licenseNumber("RAA004A")
                                                .vehicleMake("Suzuki")
                                                .vehicleModel("Ally")
                                                .vehicleCc(1600)
                                                .vehicleColor("Green")
                                                .build()
                                )
                                .build()
                )
                .build()
        );

        driverLocations.values().forEach(this::writeToMessaging);

        return Mono.empty();
    }

    public Flux<Map<Long, DriverLocation>> getDriverLocations() {
        return Flux.just(driverLocations);
    }

    public DriverLocation update(DriverLocation driverLocation) {

        try {
            H3Core h3Core = H3Core.newInstance();
            driverLocation.setCellAddress(h3Core.latLngToCellAddress(driverLocation.getLat(), driverLocation.getLng(), 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.trace("driver location {}", driverLocation);

        driverLocations.put(driverLocation.getUser().getId(), driverLocation);

        writeToMessaging(driverLocation);

        return driverLocation;
    }

    private void writeToMessaging(DriverLocation driverLocation) {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        try {
            kafkaTemplate.send(
                    "driverLocations",
                    objectMapper.writeValueAsString(
                            new WebsocketMessage("driverLocation", driverLocation)
                    )
            );
        } catch (JsonProcessingException e) {
            log.error("error writing json body", e);
            throw new RuntimeException(e);
        }
    }
}
