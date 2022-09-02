package com.example.georgianfoodapi.controllers;

import com.example.georgianfoodapi.exceptions.AuthorModelAssembler;
import com.example.georgianfoodapi.exceptions.AuthorNotFoundException;
import com.example.georgianfoodapi.models.Author;
import com.example.georgianfoodapi.service.implementation.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorServiceImpl authorService;
    private final AuthorModelAssembler assembler;

    @GetMapping("/list")
    public CollectionModel<EntityModel<Author>> all() {
        List<EntityModel<Author>> authors = authorService.list(5).stream()
                .map(assembler::toModel).toList();

        return CollectionModel.of(authors, linkTo(methodOn(AuthorController.class).all()).withSelfRel());
    }

    @PostMapping("/save")
    ResponseEntity<?> saveAuthor(@RequestBody @Valid Author author) {
        EntityModel<Author> authorEntityModel = assembler.toModel(authorService.create(author));

        return ResponseEntity.created(
                authorEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()
        ).body(authorEntityModel);
    }

    @GetMapping("get/{username}")
    public EntityModel<Author> one(@PathVariable("username") String username) throws AuthorNotFoundException {
        Author author = authorService.get(username);
                //.orElseThrow(() -> new AuthorNotFoundException(username));

        return assembler.toModel(author);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id){
        authorService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
