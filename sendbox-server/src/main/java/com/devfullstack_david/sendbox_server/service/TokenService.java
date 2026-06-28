package com.devfullstack_david.sendbox_server.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.devfullstack_david.sendbox_server.model.Administrator;

@Service
public class TokenService {
    private final String secret = "a1RzF3g1kL6JFdzgcGdMU52R";

    public String generateToken (Administrator admin) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                .withIssuer("sendbox-server")
                .withSubject(admin.getUsername())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
                
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generate JWT", exception);
        }
    }

    private Instant generateExpirationDate () {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")); // 2 hours
    }

}
