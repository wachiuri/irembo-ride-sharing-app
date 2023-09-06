package com.irembo.ride.driveronboarding.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irembo.ride.driveronboarding.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Core JWT Services such as generating JWT token based on username,
 * Getting username,
 * Validating token.
 */
@Service
@Slf4j
public class JWTService {

    final private SecretKey key;
    final private JwtParser parser;

    public JWTService() {
        key = Keys.hmacShaKeyFor("Keys.hmacShaKeyFor(\"1234567890\".getBytes(StandardCharsets.UTF_8));".getBytes(StandardCharsets.UTF_8));
        parser = Jwts.parserBuilder().setSigningKey(key).build();
    }


    public String generateUser(User user) {

        JwtBuilder builder = Jwts.builder()
                .setSubject(user.getEmail())
                .setClaims(convertToMap(user))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(15, ChronoUnit.DAYS)))
                .signWith(key);

        return builder.compact();
    }

    private Map<String, Object> convertToMap(Object object) {
        Map<String, Object> map = new HashMap<>();

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equals("password")) continue;
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                log.error("exception accessing field {} {}", field.getName(), e);
            }
        }

        return map;
    }

    public String getUserID(String token) {
        //Subject is where we store the ID
        String a = parser
                .parseClaimsJws(token)
                .getBody().getSubject();
        return a;
    }

    public boolean isValid(String token) {
        Claims claims = parser
                .parseClaimsJws(token)
                .getBody();

        log.trace("claims {} expiration {}", claims, claims.getExpiration());
        return claims.getExpiration().after(Date.from(Instant.now()));
    }

    public User getUser(String token) {
        isValid(token);
        Claims claims = parser
                .parseClaimsJws(token)
                .getBody();

        ObjectMapper om = new ObjectMapper();
        return om.convertValue(claims, User.class);
    }
}