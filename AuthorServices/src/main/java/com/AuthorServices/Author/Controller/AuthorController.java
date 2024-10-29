package com.AuthorServices.Author.Controller;

import com.AuthorServices.Author.dto.Authordto;
import com.AuthorServices.Author.entity.Author;
import com.AuthorServices.Author.service.AuthorService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/getauthor/{authorId}")
    private ResponseEntity<Author> getAuthor(@PathVariable String authorId){
//        ObjectId objectId = new ObjectId(authorId);
        return new ResponseEntity<>(authorService.getAuthor(authorId), HttpStatus.OK);
    }


    @PostMapping("/addauthor")
    private ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return  new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @PostMapping("/updateauthor")
    private ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.updateAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping("/getauthors")
    private List<Authordto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

}
