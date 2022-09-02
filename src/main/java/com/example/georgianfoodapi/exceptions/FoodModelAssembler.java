package com.example.georgianfoodapi.exceptions;

import com.example.georgianfoodapi.controllers.FoodController;
import com.example.georgianfoodapi.models.Food;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FoodModelAssembler implements RepresentationModelAssembler<Food, EntityModel<Food>> {
    @Override
    public EntityModel<Food> toModel(Food food) {
        return EntityModel.of(food,
                linkTo(methodOn(FoodController.class).one(food.getFoodId())).withSelfRel(),
                linkTo(methodOn(FoodController.class).all()).withRel("foods"));
    }

    @Override
    public CollectionModel<EntityModel<Food>> toCollectionModel(Iterable<? extends Food> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
