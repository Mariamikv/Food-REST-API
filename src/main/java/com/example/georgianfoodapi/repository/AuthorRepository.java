package com.example.georgianfoodapi.repository;

import com.example.georgianfoodapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByUsername(String username);
}
