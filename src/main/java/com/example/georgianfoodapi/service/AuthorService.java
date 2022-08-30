package com.example.georgianfoodapi.service;

import com.example.georgianfoodapi.models.Author;

import java.util.Collection;
import java.util.Optional;

public interface AuthorService {
    Author create(Author author);

    Collection<Author> list(int limit);

    Author get(String username);

    Optional<Author> getById(Long id);

    Author update(Author author);

    Boolean delete(Long id);
}
