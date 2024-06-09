package com.learning.entity.relations.onetomany.bi.service;

import com.learning.entity.relations.onetomany.bi.model.Author;
import com.learning.entity.relations.onetomany.bi.model.Book;
import com.learning.entity.relations.onetomany.bi.repository.AuthorRepository;
import com.learning.entity.relations.onetomany.bi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    public Book createBook(Book entity) {
        // save Employee
        Book  book = bookRepository.save(entity);
        return book;
    }

    public Author createBookAndAssignToAuthor(Book entity, Integer authorId) {
        // fetch Author
        Author authorTemp = authorRepository.getById(authorId);

        //set author to book
        entity.setAuthor(authorTemp);

        // add Book  to Author
        authorTemp.getBooks().add(entity);

        // save Author
        Author  savedAuthor = authorRepository.save(authorTemp);
        return savedAuthor;
    }
}
