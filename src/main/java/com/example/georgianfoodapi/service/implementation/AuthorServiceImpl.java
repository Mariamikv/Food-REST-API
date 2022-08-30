package com.example.georgianfoodapi.service.implementation;

import com.example.georgianfoodapi.models.Author;
import com.example.georgianfoodapi.repository.AuthorRepository;
import com.example.georgianfoodapi.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author create(Author author) {
        log.info("saving new author: {}", author.getUsername());

        return authorRepository.save(author);
    }

    @Override
    public Collection<Author> list(int limit) {
        log.info("fetching all servers");

        return authorRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Author get(String username) {
        log.info("fetching author by username: {}", username);

        return authorRepository.findAuthorByUsername(username);
    }

    @Override
    public Optional<Author> getById(Long id) {
        log.info("fetching author by Id: {}", id);

        return Optional.of(authorRepository.findById(id).get());
    }

    @Override
    public Author update(Author author) {
        log.info("update author: {}", author.getUsername());

        return authorRepository.save(author);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("delete author by Id: {}", id);
        authorRepository.deleteById(id);

        return true;
    }
}
