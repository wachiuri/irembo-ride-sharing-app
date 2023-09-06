package com.irembo.ride.trip.driverlocation;

import com.uber.h3core.H3Core;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverLocationService {

    private final List<DriverLocation> driverLocations = new ArrayList<>();

    @PostConstruct
    private void init() {

        H3Core h3;

        try {
            h3 = H3Core.newInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driverLocations.add(DriverLocation.builder()
                .id(1L)
                .email("junctionmall@example.com")
                .lat(-1.298489)
                .lng(36.7624734)
                .name("Junction Mall Driver")
                .profilePicture("profilePicture")
                .vehicleImage("vehicleImage")
                .licenseNumber("KCS234")
                .yom(2015)
                .vehicleCc(1600)
                .vehicleModel("Vitz")
                .vehicleMake("Toyota")
                .phoneNumber("+250734098234")
                .vehicleColor("White")
                .cellAddress(h3.latLngToCellAddress(-1.298489, 36.7624734, 1))
                .build()
        );

        driverLocations.add(DriverLocation.builder()
                .id(2L)
                .email("capitalcentre@example.com")
                .lat(-1.3163515)
                .vehicleMake("Suzuki")
                .vehicleCc(1400)
                .vehicleModel("Alto")
                .yom(2012)
                .licenseNumber("KCD764")
                .vehicleImage("vehicleImage")
                .profilePicture("profilePicture")
                .name("Capital Centre Driver")
                .phoneNumber("+250194047923")
                .lng(36.8345509)
                .vehicleColor("Blue")
                .cellAddress(h3.latLngToCellAddress(-1.3163515, 36.8345509, 1))
                .build()
        );

        driverLocations.add(DriverLocation.builder()
                .id(3L)
                .email("imara@example.com")
                .lat(-1.3278078)
                .vehicleMake("Suzuki")
                .vehicleCc(1400)
                .vehicleModel("Fuji")
                .yom(2012)
                .licenseNumber("KVG873")
                .vehicleImage("vehicleImage")
                .profilePicture("profilePicture")
                .name("Imara Driver")
                .phoneNumber("+25078364324")
                .lng(36.8815573)
                .vehicleColor("Green")
                .cellAddress(h3.latLngToCellAddress(-1.3278078, 36.8815573, 1))
                .build()
        );

        driverLocations.add(DriverLocation.builder()
                .id(3L)
                .email("tworivers@example.com")
                .lat(-1.2107673)
                .vehicleMake("Suzuki")
                .vehicleCc(1400)
                .vehicleModel("Vitara")
                .yom(2012)
                .licenseNumber("KRS230")
                .vehicleImage("vehicleImage")
                .profilePicture("profilePicture")
                .name("Two Rivers Driver")
                .phoneNumber("+25078364324")
                .lng(36.7946368)
                .vehicleColor("Pink")
                .cellAddress(h3.latLngToCellAddress(-1.2107673, 36.7946368, 1))
                .build()
        );

        driverLocations.add(DriverLocation.builder()
                .id(3L)
                .email("muthaigadriver@example.com")
                .lat(-1.2614312)
                .vehicleMake("Suzuki")
                .vehicleCc(1400)
                .vehicleModel("Vitara")
                .yom(2012)
                .licenseNumber("KRS230")
                .vehicleImage("vehicleImage")
                .profilePicture("profilePicture")
                .name("Muthaiga Square Driver")
                .phoneNumber("+25078364324")
                .lng(36.8423486)
                .vehicleColor("Grey")
                .cellAddress(h3.latLngToCellAddress(-1.2614312, 36.8423486, 1))
                .build()
        );

        driverLocations.add(DriverLocation.builder()
                .id(3L)
                .email("abc@example.com")
                .lat(-1.2444047)
                .vehicleMake("Toyota")
                .vehicleCc(1400)
                .vehicleModel("Vitz")
                .yom(2012)
                .licenseNumber("KYR230")
                .vehicleImage("vehicleImage")
                .profilePicture("profilePicture")
                .name("ABC Driver")
                .phoneNumber("+25078364324")
                .lng(36.8017112)
                .vehicleColor("Grey")
                .cellAddress(h3.latLngToCellAddress(-1.2444047, 36.8017112, 1))
                .build()
        );
    }

    public Flux<DriverLocation> list() {
        return Flux.fromIterable(driverLocations);
    }

    public DriverLocation update(DriverLocation driverLocation) {
        driverLocations.add(driverLocation);
        return driverLocation;
    }
}
