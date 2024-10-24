package com.Library.AuthentictaionService.controller;

import com.Library.AuthentictaionService.Service.UserService;
import com.Library.AuthentictaionService.dto.Userdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody Userdto userdto){
        return new ResponseEntity<>("User created Successfully", HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody Userdto userdto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userdto.getUsername(), userdto.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>("Login Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Login FAILED", HttpStatus.OK);

    }

}
