package com.EmployeeManagement.configuration.security;

import com.EmployeeManagement.entity.UserInfo;
import com.EmployeeManagement.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userInfoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username does not exist"));
    }

    public UserInfo createUser(UserInfo userInfo){
        userInfo.setPassword(securityConfig.bCryptPasswordEncoder().encode(userInfo.getPassword()));
        return userInfoRepository.save(userInfo);
    }
}
