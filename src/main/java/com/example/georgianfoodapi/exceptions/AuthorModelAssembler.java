package com.example.georgianfoodapi.exceptions;

import com.example.georgianfoodapi.controllers.AuthorController;
import com.example.georgianfoodapi.models.Author;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AuthorModelAssembler implements RepresentationModelAssembler<Author, EntityModel<Author>> {
    @Override
    public EntityModel<Author> toModel(Author author) {
        try {
            return EntityModel.of(author,
                    linkTo(methodOn(AuthorController.class).one(author.getUsername())).withSelfRel(),
                    linkTo(methodOn(AuthorController.class).all()).withRel("authors"));
        } catch (AuthorNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CollectionModel<EntityModel<Author>> toCollectionModel(Iterable<? extends Author> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
