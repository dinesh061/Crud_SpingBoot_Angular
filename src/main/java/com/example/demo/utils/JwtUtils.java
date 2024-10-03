package com.example.demo.utils;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import  com.example.demo.common.*;



@Component
public class JwtUtils {
	
//	@Autowired
	private oww ww;
//    
	private static String secret = "This_is_secret";
    private static long expiryDuration = 60 * 60;

    public String generateJwt(User user){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);
//
//        // optional claims
        claims.put("type", user.getUserType());
        claims.put("name", user.getName());
        claims.put("emailId", user.getEmailId());

        // generate jwt using claims
        String token="";
      
       try {
    	   token = Jwts.builder()
                   .setClaims(claims)
                   .signWith(SignatureAlgorithm.HS512, secret)
                   .compact();
       }
       catch(Exception e) {
    	   System.out.println("j exception");   
       }
      
     System.out.println("generated");
       
        return token;
    }

    public void verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
           
        } catch(Exception e) {
               System.out.println("A exception");
            throw new AccessDeniedException("Access Denied");
        }

    }
}
