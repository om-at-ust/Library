package com.Authenticatioon_Service.Authentication_Service.Service;

import com.Authenticatioon_Service.Authentication_Service.Dto.Userdto;
import com.Authenticatioon_Service.Authentication_Service.Entity.UserInfo;
import com.Authenticatioon_Service.Authentication_Service.Exception.UserAlreadyExistException;
import com.Authenticatioon_Service.Authentication_Service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void register(Userdto userdto) throws UserAlreadyExistException {

        if (userRepository.existsByName(userdto.getUsername())) {
            throw new UserAlreadyExistException("User already exists with username: " + userdto.getUsername());
        }

        // Create a new UserInfo object and save it
        UserInfo userInfo = new UserInfo(userdto.getUsername(), passwordEncoder.encode(userdto.getPassword()));
        userRepository.save(userInfo);
    }
}
