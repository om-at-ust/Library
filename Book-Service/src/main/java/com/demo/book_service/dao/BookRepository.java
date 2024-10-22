package com.demo.book_service.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.book_service.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
    Book findBybookTitle(String bookName);
}
