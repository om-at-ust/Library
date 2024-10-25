package com.Library.AuthentictaionService.Service;

import com.Library.AuthentictaionService.dto.Userdto;
import com.Library.AuthentictaionService.entity.UserInfo;
import com.Library.AuthentictaionService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void register(Userdto userdto) {
        UserInfo userInfo = new UserInfo(userdto.getUsername(), passwordEncoder.encode(userdto.getPassword()));
        userRepository.save(userInfo);
    }
}
