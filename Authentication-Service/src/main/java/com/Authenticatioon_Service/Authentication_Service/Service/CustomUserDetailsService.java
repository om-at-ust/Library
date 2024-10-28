package com.Authenticatioon_Service.Authentication_Service.Service;

import com.Authenticatioon_Service.Authentication_Service.Entity.PrincipalUser;
import com.Authenticatioon_Service.Authentication_Service.Entity.UserInfo;
import com.Authenticatioon_Service.Authentication_Service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userRepository.findByName(username);
        if(userInfo.isPresent()){
            return new PrincipalUser(userInfo.get());
        }
        return null;
    }
}