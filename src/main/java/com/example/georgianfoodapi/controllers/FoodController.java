package com.example.georgianfoodapi.controllers;

import com.example.georgianfoodapi.exceptions.FoodModelAssembler;
import com.example.georgianfoodapi.models.Food;
import com.example.georgianfoodapi.service.implementation.FoodServiceImpl;
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
@RequestMapping("/api/v1/food")
public class FoodController {

    private final FoodServiceImpl service;
    private final FoodModelAssembler assembler;

    @GetMapping("/list")
    public CollectionModel<EntityModel<Food>> all() {
        List<EntityModel<Food>> food = service.list(10).stream()
                .map(assembler::toModel).toList();

        return CollectionModel.of(food, linkTo(methodOn(FoodController.class).all()).withSelfRel());
    }

    @PostMapping("/save")
    ResponseEntity<?> saveServer(@RequestBody @Valid Food food) {
        EntityModel<Food> entityModel = assembler.toModel(service.create(food));

        return ResponseEntity.created(
                entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @GetMapping("/get/{id}")
    public EntityModel<Food> one(@PathVariable("id") Long id){
        Food food = service.get(id);

        return assembler.toModel(food);
    }

    @GetMapping("/get/{title}")
    public EntityModel<Food> getByTitle(@PathVariable("title") String title){
        Food food = service.getByTitle(title);

        return assembler.toModel(food);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteServer(@PathVariable("id") Long id){
        service.delete(id);

        // returns an HTTP 204 No Content response.
        return  ResponseEntity.noContent().build();
    }
}
