package com.marcuschiu.springboot.graphql.component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.marcuschiu.springboot.graphql.model.Author;
import com.marcuschiu.springboot.graphql.model.Book;
import com.marcuschiu.springboot.graphql.repository.AuthorRepository;
import com.marcuschiu.springboot.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;


    // based on the graphql schemas in src/main/resources/graphql/*.graphql define methods of creating the entities

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).get();
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}