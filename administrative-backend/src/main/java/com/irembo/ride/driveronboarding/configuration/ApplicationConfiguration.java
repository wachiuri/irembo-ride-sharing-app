package com.irembo.ride.driveronboarding.configuration;

import com.irembo.ride.driveronboarding.configuration.jpa.ApplicationReactiveAuditorAware;
import com.irembo.ride.driveronboarding.configuration.jpa.PhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.relational.core.mapping.NamingStrategy;

@Configuration
@EnableR2dbcAuditing
public class ApplicationConfiguration {

    @Bean
    public NamingStrategy namingStrategy() {
        return new PhysicalNamingStrategy();
    }

    @Bean
    public ReactiveAuditorAware reactiveAuditorAware() {
        return new ApplicationReactiveAuditorAware();
    }
}
