package com.teb.training.ee.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@ApplicationScoped
public class JWTService {

    private final Key myKey;

    public JWTService() {
        this.myKey = Keys.hmacShaKeyFor("ILovejwttokens126347862387y28746283746823746".getBytes());
    }

    public String generateJwtToken(final String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("mytest",
                   "xyz");
        claims.put("role",
                   "USER");
        String tokenLoc = Jwts.builder()
                              .setSubject(username)
                              .setIssuedAt(new Date())
                              .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                              .addClaims(claims)
                              .signWith(this.myKey)
                              .compact();
        return tokenLoc;
    }

    public Jws<Claims> validate(final String token) {
        try {
            JwtParser parserLoc = Jwts.parserBuilder()
                                      .setSigningKey(this.myKey)
                                      .build();
            Jws<Claims> parseClaimsJwsLoc = parserLoc.parseClaimsJws(token);
            return parseClaimsJwsLoc;
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
            return null;
        }

    }

}
