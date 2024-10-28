package com.Authenticatioon_Service.Authentication_Service.Repository;

import com.Authenticatioon_Service.Authentication_Service.Entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, String> {
    public Optional<UserInfo> findByName(String username);
}

