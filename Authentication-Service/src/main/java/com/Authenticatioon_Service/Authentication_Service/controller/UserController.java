package com.Authenticatioon_Service.Authentication_Service.controller;

import com.Authenticatioon_Service.Authentication_Service.Dto.Userdto;
import com.Authenticatioon_Service.Authentication_Service.Exception.UserAlreadyExistException;
import com.Authenticatioon_Service.Authentication_Service.Service.JwtService;
import com.Authenticatioon_Service.Authentication_Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwt;


//    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Userdto userdto){

        Map<String, Object> response = new HashMap<>();
        try {
            userService.register(userdto); // Attempt to register the user
            response.put("status", "success");
            response.put("message", "User registered successfully");
            return ResponseEntity.ok(response); // 200 OK with success message
        } catch (UserAlreadyExistException e) {
            response.put("status", "error");
            response.put("message", "User already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response); // 409 Conflict for user already existing
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Registration failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error for other exceptions
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Userdto userdto) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Attempt to authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userdto.getUsername(), userdto.getPassword())
            );

            // Check if authentication is successful
            if (authentication.isAuthenticated()) {
                // Generate and return the JWT token
                String token = jwt.generateToken(userdto.getUsername());
                response.put("status", "success");
                response.put("message", "Login successful");
                response.put("token", token);
                return ResponseEntity.ok(response);
            }
        } catch (BadCredentialsException e) {
            // Handle bad credentials
            response.put("status", "error");
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (Exception e) {
            // Handle any other exceptions
            response.put("status", "error");
            response.put("message", "Login failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        // If we reach this point, something went wrong
        response.put("status", "error");
        response.put("message", "Login failed");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }





    @GetMapping("/validate/token")
    public Boolean validate(@RequestParam String token){
        jwt.validateToken(token);

        return true;
    }

}

