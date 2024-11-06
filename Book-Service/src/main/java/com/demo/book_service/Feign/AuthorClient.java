package com.demo.book_service.Feign;

import com.demo.book_service.client.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="AuthorService",url="http://localhost:8989/api/author")
public interface AuthorClient {

    @GetMapping("/getauthors")
    List<Author> getAllAuthors();

    @GetMapping("/getauthor/{authorId}")
    ResponseEntity<Author> getAuthorById(String authorId);

}
