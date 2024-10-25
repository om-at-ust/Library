package com.Library.AuthentictaionService.repository;

import com.Library.AuthentictaionService.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, String> {
    public Optional<UserInfo> findByName(String username);
}
