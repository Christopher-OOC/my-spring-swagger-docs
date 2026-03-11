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

    @Value("{application.security.jwt.access-token-expiration}")
    private long accessTokenExpiration;

    @Value("{application.security.jwt.refresh-token-expiration}")
    private long refreshTokenExpiration;

    public JwtService() {
        byte[] byteSecret = Base64.getDecoder().decode(secret);
        this.key = Keys.hmacShaKeyFor(byteSecret);
    }

    public AuthResponse generateToken(String email, String password) {
        AuthResponse response = new AuthResponse();
        response.setTokenType("Bearer");
        response.setAccessToken(generateAccessToken(email));
        response.setRefreshToken(generateRefreshToken(email));

        return response;
    }

    public AuthResponse refreshToken(String refreshToken) {
        String email = extractEmail(refreshToken);

        if (!validateRefreshToken(refreshToken)) {
            throw new JwtException("Invalid refresh token");
        }

        AuthResponse response = new AuthResponse();
        response.setTokenType("Bearer");
        response.setAccessToken(generateAccessToken(email));
        response.setRefreshToken(generateRefreshToken(email));

        return response;
    }

    private boolean validateRefreshToken(String refreshToken) {
        if (!isJwtValid(refreshToken)) {
            throw new JwtException("Invalid refresh token");
        }

        return extractClaims(refreshToken).get("TOKEN_TYPE").equals("REFRESH_TOKEN");

    }

    private String generateAccessToken(String email) {
        try {
            return buildToken(email, Map.of("TOKEN_TYPE", "ACCESS_TOKEN"), accessTokenExpiration);
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT Token");
        }
    }

    private String generateRefreshToken(String email) {
        try {
            return buildToken(email, Map.of("TOKEN_TYPE", "REFRESH_TOKEN"), refreshTokenExpiration);
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT Token");
        }
    }

    private String buildToken(String email, Map<String, String> claims, long expiration) {
        try {
            return Jwts.builder()
                    .signWith(this.key)
                    .subject(email)
                    .claims(claims)
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + expiration))
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
