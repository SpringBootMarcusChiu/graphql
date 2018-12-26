package com.marcuschiu.springboot.graphql.component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.marcuschiu.springboot.graphql.model.Author;
import com.marcuschiu.springboot.graphql.model.Book;
import com.marcuschiu.springboot.graphql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        Optional opt = authorRepository.findById(book.getAuthor().getId());
        return opt.isPresent() ? (Author)opt.get() : null;
    }
}