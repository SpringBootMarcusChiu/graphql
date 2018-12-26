package com.marcuschiu.springboot.graphql.component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.marcuschiu.springboot.graphql.model.Author;
import com.marcuschiu.springboot.graphql.model.Book;
import com.marcuschiu.springboot.graphql.repository.AuthorRepository;
import com.marcuschiu.springboot.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}