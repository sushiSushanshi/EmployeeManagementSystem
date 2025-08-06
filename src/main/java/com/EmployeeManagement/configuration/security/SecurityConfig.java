//package com.EmployeeManagement.configuration.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.csrf(c -> c.disable())
//                .authorizeHttpRequests(request -> request.anyRequest() .permitAll())
////                .authorizeHttpRequests((request ->  request.anyRequest().authenticated()))
//                .build();
//    }
//
//}
