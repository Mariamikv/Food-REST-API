package com.example.georgianfoodapi.controllers;

import com.example.georgianfoodapi.exceptions.IngredientModelAssembler;
import com.example.georgianfoodapi.models.Ingredient;
import com.example.georgianfoodapi.service.implementation.IngredientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

    private final IngredientServiceImpl service;
    private final IngredientModelAssembler assembler;

    @GetMapping("/list")
    public CollectionModel<EntityModel<Ingredient>> all() {
        List<EntityModel<Ingredient>> ingredient = service.list(10).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(ingredient, linkTo(methodOn(IngredientController.class).all()).withSelfRel());
    }

    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody @Valid Ingredient ingredient) {
        EntityModel<Ingredient> entityModel = assembler.toModel(service.create(ingredient));

        return ResponseEntity.created(
                entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @GetMapping("/get/{id}")
    public EntityModel<Ingredient> one(@PathVariable("id") Long id){
        Ingredient ingredient = service.get(id);

        return assembler.toModel(ingredient);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);

        // returns an HTTP 204 No Content response.
        return  ResponseEntity.noContent().build();
    }
}
