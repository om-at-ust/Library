package com.AuthorServices.Author.Controller;

import com.AuthorServices.Author.entity.Author;
import com.AuthorServices.Author.service.AuthorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/getAuthor/{id}")
    private ResponseEntity<Author> getAuthor(@PathVariable String id){
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }

    @PostMapping("/addAuthor")
    private ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return  new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @PostMapping("/updateAuthor")
    private ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.updateAuthor(author), HttpStatus.CREATED);
    }
}
