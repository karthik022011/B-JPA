package com.learning.entity.relations.onetomany.bi.service;

import com.learning.entity.relations.onetomany.bi.model.Author;
import com.learning.entity.relations.onetomany.bi.repository.AuthorRepository;
import com.learning.entity.relations.onetomany.bi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    public Author createAuthor(@RequestBody Author entity) {
        // save Employee
        Author  author = authorRepository.save(entity);
        return author;
    }
}
