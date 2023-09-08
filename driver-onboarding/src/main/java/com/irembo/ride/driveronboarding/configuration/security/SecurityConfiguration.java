package com.irembo.ride.driveronboarding.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebFluxSecurity
//@EnableReactiveMethodSecurity(useAuthorizationManager = true)
public class SecurityConfiguration {

    @Autowired
    private ApplicationServerAuthenticationSuccessHandler successHandler;

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, AuthManager jwtAuthManager, AuthConverter jwtAuthConverter) {

        AuthenticationWebFilter jwtFilter = new AuthenticationWebFilter(jwtAuthManager);
        jwtFilter.setServerAuthenticationConverter(jwtAuthConverter);

        http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/login", "/user/register").permitAll()
                        .pathMatchers(HttpMethod.OPTIONS).permitAll()
                        .anyExchange().authenticated()
                )
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .formLogin(formLoginSpec
                        -> formLoginSpec
                        .authenticationSuccessHandler(
                                successHandler
                        )
                        .authenticationFailureHandler(
                                new ApplicationServerAuthenticationFailureHandler()
                        )
                )
                .addFilterAt(jwtFilter, SecurityWebFiltersOrder.AUTHENTICATION)
        ;

        http.cors(corsSpec -> corsSpec.configurationSource(
                new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(ServerWebExchange exchange) {
                        CorsConfiguration corsConfig = new CorsConfiguration();
                        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:4201", "http://localhost:4202"));
                        corsConfig.setMaxAge(8000L);
                        corsConfig.setAllowedMethods(List.of("*"));
                        corsConfig.setAllowedHeaders(List.of("*"));
                        corsConfig.setAllowCredentials(true);

                        return corsConfig;
                    }
                }
        ));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
