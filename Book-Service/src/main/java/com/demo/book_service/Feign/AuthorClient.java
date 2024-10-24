package com.demo.book_service.Feign;

import com.demo.book_service.client.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="Author",url="http://localhost:8989/api/v1")
public interface AuthorClient {

    @GetMapping("/authors")
    List<Author> getAllAuthors();

    @GetMapping("/getAuthor/{authorId}")
    ResponseEntity<Author> getAuthorById(String authorId);

}
