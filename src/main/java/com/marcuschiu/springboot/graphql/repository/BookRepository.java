package com.marcuschiu.springboot.graphql.repository;

import com.marcuschiu.springboot.graphql.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> { }
