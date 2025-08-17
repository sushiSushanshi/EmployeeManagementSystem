package com.EmployeeManagement.controller;

import com.EmployeeManagement.configuration.security.JWTService;
import com.EmployeeManagement.entity.UserInfo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public SecurityController(JWTService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public String generateToken(@RequestBody UserInfo userInfo){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInfo.getUsername(),userInfo.getPassword()));
        if(authenticate.isAuthenticated())
            return jwtService.generateToken(userInfo.getUsername());
        else
            throw new UsernameNotFoundException("User does not exist");
    }
}
