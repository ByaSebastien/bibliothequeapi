package bstorm.bibliothequeapi.utils;

import bstorm.bibliothequeapi.configs.JwtConfig;
import bstorm.bibliothequeapi.models.entities.securities.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final JwtConfig config;

    private final JwtParser parser;

    private final JwtBuilder builder;

    public JwtUtil(JwtConfig config){
        this.config = config;
        this.parser = Jwts.parserBuilder().setSigningKey(config.getKey()).build();
        this.builder = Jwts.builder().signWith(config.getKey());
    }

    public String generateToken(User user){
        return builder
                .claim("id",user.getId())
                .claim("username",user.getUsername())
                .claim("role",user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + config.getExpiration() * 1000L))
                .compact();
    }

    public Claims getClaims(String token){
        return parser.parseClaimsJws(token).getBody();
    }

    public Long getId(String token){
        return getClaims(token).get("id", Long.class);
    }

    public String getUsername(String token){
        return getClaims(token).get("username", String.class);
    }

    public String getRole(String token){
        return getClaims(token).get("role", String.class);
    }

    public boolean isValid(String token){
        Claims claims = getClaims(token);
        Date now = new Date();
        return getRole(token) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}
