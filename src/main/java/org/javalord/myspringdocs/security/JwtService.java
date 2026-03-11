package org.javalord.myspringdocs.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import org.javalord.myspringdocs.auth.response.AuthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final SecretKey key;

    @Value("{application.security.jwt.secret}")
    private String secret;

    public JwtService() {
        byte[] byteSecret = Base64.getDecoder().decode(secret);
        this.key = Keys.hmacShaKeyFor(byteSecret);
    }

    public AuthResponse generateToken(String email, String password) {
        AuthResponse response = new AuthResponse();
        response.setTokenType("Bearer");
        response.setAccessToken();

    }

    private String generateAccessToken(String email) {
        try {
            return buildToken(email, Map.of("TOKEN_TYPE", "ACCESS_TOKEN"));
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT Token");
        }
    }

    private String generateRefreshToken(String email) {
        try {
            return buildToken(email, Map.of("TOKEN_TYPE", "REFRESH_TOKEN"));
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT Token");
        }
    }

    private String buildToken(String email, Map<String, String> claims) {
        try {
            return Jwts.builder()
                    .signWith(this.key)
                    .subject(email)
                    .claims(claims)
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + 1200000))
                    .compact();
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT Token");
        }
    }

    public String extractEmail(String jwtToken) {
        try {
            return extractClaims(jwtToken).getSubject();
        }
        catch (JwtException e) {
            throw  new JwtException("Invalid JWT Token");
        }
    }

    public boolean isJwtValid(String jwtToken) {
        try {
            return extractClaims(jwtToken).getExpiration().before(new Date());
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT token");
        }

    }

    private Claims extractClaims(String jwtToken) {
        try {
            return Jwts.parser()
                    .verifyWith(this.key)
                    .build()
                    .parseSignedClaims(jwtToken)
                    .getPayload();
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT token");
        }
    }

}
