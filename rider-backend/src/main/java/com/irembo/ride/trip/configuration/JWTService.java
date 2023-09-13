package com.irembo.ride.trip.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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


    public String generate(String subject, Object data) {

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setClaims(Map.of("data", convertToJson(data)))
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
                log.error("exception accessing field {}", field.getName(), e);
            }
        }

        return map;
    }

    private String convertToJson(Object object) {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "{}";
        }
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

    public <T> T get(String token, Class<T> type) {
        isValid(token);
        Claims claims = parser
                .parseClaimsJws(token)
                .getBody();

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        String data = claims.get("data", String.class);

        try {
            return om.readValue(data, type);
        } catch (JsonProcessingException e) {
            log.error("error reading json body", e);
            return null;
        }
    }
}