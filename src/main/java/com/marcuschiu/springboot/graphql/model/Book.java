package com.marcuschiu.springboot.graphql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String title;
    String isbn;
    int pageCount;
    @ManyToOne
    @JoinColumn(name = "author_id",
            nullable = false, updatable = false)
    Author author;

    public Book() {
    }

    public Book(String title, String isbn, int pageCount, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.author = author;
    }
}