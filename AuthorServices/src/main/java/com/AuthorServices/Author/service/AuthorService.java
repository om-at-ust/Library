package com.AuthorServices.Author.service;

import com.AuthorServices.Author.dao.AuthorRepository;
import com.AuthorServices.Author.dto.Authordto;
import com.AuthorServices.Author.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Authordto> getAllAuthors() {
        return authorRepository.findAll().stream().map(this::convertToAuthordto).toList();
    }

    private Authordto convertToAuthordto(Author author) {
        Authordto authordto = new Authordto(author.getAuthorId(), author.getAuthorName());
        return authordto;
    }
}
