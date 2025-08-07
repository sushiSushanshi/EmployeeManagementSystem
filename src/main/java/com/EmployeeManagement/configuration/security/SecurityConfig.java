package com.EmployeeManagement.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(c -> c.disable())
                .authorizeHttpRequests(request -> request.requestMatchers("/employee/register") .permitAll())
                .authorizeHttpRequests((request ->  request.anyRequest().authenticated()))
                .httpBasic()
                .and()
                .build();
    }

}
