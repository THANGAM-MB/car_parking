package com.SlotBooking.CarParking.JWTFilter;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class CarParkingJWTService {
	public static final String SECRECT="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	private Key getSignKey() {
		byte[] key=Decoders.BASE64.decode(SECRECT);
		return Keys.hmacShaKeyFor(key); 
	}
	

	public String createToken(Map<String, Object> claims ,String email) {
		return Jwts.builder()
		.setClaims(claims)
		.setSubject(email)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
		.signWith(getSignKey(),SignatureAlgorithm.HS256)
		.compact();
		
	}
	

	public String generateToken(String email) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims,email);
	}
	
	
	public String extractUsername(String token) { 
		
        return extractClaim(token, Claims::getSubject); 
    } 
  
    public Date extractExpiration(String token) { 
        return extractClaim(token, Claims::getExpiration); 
    } 
    
    private Claims extractAllClaims(String token) { 
        return Jwts 
                .parserBuilder() 
                .setSigningKey(getSignKey()) 
                .build() 
                .parseClaimsJws(token) 
                .getBody(); 
    } 
	
	
    public <T> T extractClaim(String token, Function<Claims, T> funtion) { 
        final Claims claims = extractAllClaims(token); 
        return funtion.apply(claims); 
    } 

    private Boolean isTokenExpired(String token) { 
        return extractExpiration(token).before(new Date()); 
    } 
  
    public Boolean validateToken(String token, UserDetails userDetails) { 
        final String email = extractUsername(token); 
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token)); 
    } 
    
    public String destroyToken(String token) {
    	
    	return "token Expired";
    }
	
	
	
}
