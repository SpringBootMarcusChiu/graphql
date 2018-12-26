package com.marcuschiu.springboot.graphql.repository;

import com.marcuschiu.springboot.graphql.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> { }
