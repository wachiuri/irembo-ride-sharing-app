package com.irembo.ride.trip.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, AuthManager jwtAuthManager, AuthConverter jwtAuthConverter) {

        AuthenticationWebFilter jwtFilter = new AuthenticationWebFilter(jwtAuthManager);
        jwtFilter.setServerAuthenticationConverter(jwtAuthConverter);

        http.authorizeExchange(
                        exchanges -> exchanges.pathMatchers(HttpMethod.OPTIONS).permitAll()
                                .anyExchange().authenticated()
                )
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())

                .addFilterAt(jwtFilter, SecurityWebFiltersOrder.AUTHENTICATION)

        ;

        http.cors(corsSpec -> corsSpec.disable());
        http.csrf(csrf -> csrf.disable());
        http.httpBasic(basicSpec -> basicSpec.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
