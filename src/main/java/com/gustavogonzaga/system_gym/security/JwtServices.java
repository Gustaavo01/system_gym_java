package com.gustavogonzaga.system_gym.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gustavogonzaga.system_gym.entities.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtServices {
    private final String secret = "my-secret-key";
    public String gerarToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create().withSubject(user.getEmail()).withExpiresAt(Instant.now().plus(2, ChronoUnit.HOURS)).sign(algorithm);
    }
}
