package com.EmployeeManagement.configuration.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTService {

    private static final CharSequence SECRETE = "499022ea00f02bc4c7325cc7cf1d1e1e5cc7066149b21f365611412d93871b4d";

    public String generateToken(String usename){
        Map<String, Object> claims = new HashMap<>();
        return createToken(usename,claims);
    }

    private String createToken(String username, Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRETE);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
