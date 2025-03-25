package com.example.crud.infra.security;

import com.auth0.jwt.JWT;
import com.example.crud.entity.User.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;
        }catch(Exception e){
            throw new RuntimeException("Error while generating token",e);
        }
    }
    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch(Exception e){
            return "";
        }
    }

    private Instant getExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(java.time.ZoneOffset.of("-03:00"));
    }
}
