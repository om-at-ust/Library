package com.AuthorServices.Author.dao;

import com.AuthorServices.Author.entity.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

}
