package com.example.usermgmntservice.config.security.v2;

import com.example.usermgmntservice.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;
import java.util.List;

public class JwtTokenUtil {

    private static final String SECRET_KEY = "-j]#)z4.+A_xbKQQC@h2FxCGzattHr";

    // Generate JWT token with username and roles
    public static String generateToken(String username, List<Role> role) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date()) // Current timestamp
                .claim("role", role) // Add roles as claim
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Signing the token with HS256 algorithm and secret key
                .compact();
    }

    // Extract the username from JWT token
    public static String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // Use the same secret key for verification
                .parseClaimsJws(token) // Parse the JWT to retrieve claims
                .getBody()
                .getSubject(); // Get the subject (username) from the token
    }

    // Extract roles from JWT token
    public static List<String> extractRoles(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.get("role", List.class); // Retrieve roles from the claims
    }

    // Check if the token has expired
    public static boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date()); // Compare expiration date with the current date
    }

    // Extract the expiration date from the token
    public static Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration(); // Extract expiration date from the claims
    }

    // Validate the token (check username and expiration)
    public static boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token)); // Ensure username matches and token is not expired
    }

    // Encode data into Base64 using Java's built-in Base64 class
    public static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data); // Use Base64 encoder to encode byte array
    }

    // Decode Base64 data using Java's built-in Base64 class
    public static byte[] decodeBase64(String data) {
        return Base64.getDecoder().decode(data); // Use Base64 decoder to decode Base64 string
    }
}
