package com.sena.chef_control.utilidad;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jws;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtilidad {
    private final Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    private final long tokenExpiration = 86400000; // 24 horas en milisegundos

    public String generateToken(String correo) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + tokenExpiration);

        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }

    public String extractCorreo(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            JwtParser parser = Jwts.parser().setSigningKey(key).build(); // Build the parser
            parser.parseClaimsJws(token); // Use parseClaimsJws on the built parser
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractClaims(String token) {
        JwtParser parser = Jwts.parser().setSigningKey(key).build(); // Build the parser
        try {
            Jws<Claims> claimsJws = parser.parseClaimsJws(token); // Parse the token
            return claimsJws.getBody(); // Extract claims
        } catch (Exception e) {
            // Handle parsing errors appropriately, e.g., log or throw a custom exception
            throw new RuntimeException("Invalid JWT token", e);
        }
    }
}