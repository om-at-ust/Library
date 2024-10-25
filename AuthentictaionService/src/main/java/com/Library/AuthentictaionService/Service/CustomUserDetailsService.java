package com.Library.AuthentictaionService.Service;

import com.Library.AuthentictaionService.entity.PrincipalUser;
import com.Library.AuthentictaionService.entity.UserInfo;
import com.Library.AuthentictaionService.repository.UserRepository;
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
