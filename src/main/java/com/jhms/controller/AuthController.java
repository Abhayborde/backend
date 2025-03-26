package com.jhms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000") // Add this for React frontend
public class AuthController {
    private static final String ADMIN_USERNAME = "Sandip";
    private static final String ADMIN_PASSWORD = "Sandip@2023";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if (ADMIN_USERNAME.equals(loginRequest.getUsername()) 
            && ADMIN_PASSWORD.equals(loginRequest.getPassword())) {
            
            Map<String, String> response = new HashMap<>();
            response.put("token", "dummy-admin-token");
            response.put("message", "Login successful");
            
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.badRequest().body(Map.of("error", "Invalid credentials"));
    }

    // Inner class to handle login request
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}