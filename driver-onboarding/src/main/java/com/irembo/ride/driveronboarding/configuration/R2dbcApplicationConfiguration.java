package com.irembo.ride.driveronboarding.configuration;

import com.irembo.ride.driveronboarding.driver.DriverReadConverter;
import com.irembo.ride.driveronboarding.driver.DriverWriteConverter;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.util.List;

@Configuration
public class R2dbcApplicationConfiguration extends AbstractR2dbcConfiguration {

    @Value("${spring.r2dbc.host}")
    private String host;

    @Value("${spring.r2dbc.database}")
    private String database;

    @Value("${spring.r2dbc.port}")
    private Integer port;

    @Value("${spring.r2dbc.driver}")
    private String driver;

    @Value("${spring.r2dbc.username}")
    private String username;

    @Value("${spring.r2dbc.password}")
    private String password;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(ConnectionFactoryOptions.HOST, host)
                        .option(ConnectionFactoryOptions.DRIVER, driver)
                        .option(ConnectionFactoryOptions.PORT, port)
                        .option(ConnectionFactoryOptions.DATABASE, database)
                        .option(ConnectionFactoryOptions.USER, username)
                        .option(ConnectionFactoryOptions.PASSWORD, password)
                        .build()
        );
    }

    @Override
    protected List<Object> getCustomConverters() {
        return List.of(
                new DriverWriteConverter(),
                new DriverReadConverter()
        );
    }
}
