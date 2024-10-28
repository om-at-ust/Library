package com.Authenticatioon_Service.Authentication_Service.controller;

import com.Authenticatioon_Service.Authentication_Service.Dto.Userdto;
import com.Authenticatioon_Service.Authentication_Service.Service.JwtService;
import com.Authenticatioon_Service.Authentication_Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwt;

    @GetMapping("/health")
    public String getHealth(){
        return "ok";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Userdto userdto){
        userService.register(userdto);
        return new ResponseEntity<>("User created Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Userdto userdto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userdto.getUsername(), userdto.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>(jwt.generateToken(userdto.getUsername()), HttpStatus.OK);
        }
        return new ResponseEntity<>("Login FAILED", HttpStatus.OK);

    }




    @PostMapping("/validate/token")
    public ResponseEntity<String> validate(@RequestParam String token){
        try{
            jwt.validateToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("Token not valid", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Token is valid", HttpStatus.OK);
    }

}

