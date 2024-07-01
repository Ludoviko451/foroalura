package com.laqf.foroalura.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.laqf.foroalura.domain.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
      try {
          Algorithm algorithm = Algorithm.HMAC256(apiSecret);
          String token = JWT.create()
                  .withIssuer("voll med")
                  .withSubject(usuario.getLogin())
                  .withClaim("id", usuario.getId())
                  .withExpiresAt(generarFechaExp())
                  .sign(algorithm);

          return token;
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
    }
    public String getSubject(String token) {
        if (token == null){
            throw new RuntimeException();
        }
        return JWT.require(Algorithm.HMAC256(apiSecret))
                .withIssuer("voll med")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant generarFechaExp(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
