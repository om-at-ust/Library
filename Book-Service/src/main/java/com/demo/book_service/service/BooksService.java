package com.demo.book_service.service;

import com.demo.book_service.Feign.AuthorClient;
import com.demo.book_service.client.Author;
import com.demo.book_service.dao.BookRepository;
import com.demo.book_service.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.List;

@Service
public class BooksService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorClient authorClient;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getABooks(String bookName) {
        return bookRepository.findBybookTitle(bookName);
    }


    public Book addBook(Book newBook) {
        return bookRepository.save(newBook);

    }


    public List<Author> getAllAuthors() {
      return authorClient.getAllAuthors();

    }

    public Author getAuthorById(String authorId) {
        return authorClient.getAuthorById(authorId).getBody();
    }

}
