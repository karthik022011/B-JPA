package com.learning.entity.relations.onetomany.bi.controller;

import com.learning.entity.relations.onetomany.bi.model.Author;
import com.learning.entity.relations.onetomany.bi.service.AuthorService;
import com.learning.entity.relations.onetomany.bi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/createAuthor")
    public ResponseEntity<Author> createAuthor(@RequestBody Author entity) {
        Author savedEmployee = authorService.createAuthor(entity);
        return ResponseEntity.ok(savedEmployee);
    }
}

//http://localhost:8081/api/author/createAuthor
/*{
        "name":"Karthik"
}*/
