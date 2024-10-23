package com.AuthorServices.Author.service;

import com.AuthorServices.Author.dao.AuthorRepository;
import com.AuthorServices.Author.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }


    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthor(String id) {
        return authorRepository.findById(id).get();
    }
}
