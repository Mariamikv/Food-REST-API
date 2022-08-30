package com.example.georgianfoodapi.service;

import com.example.georgianfoodapi.models.Ingredient;

import java.util.Collection;

public interface IngredientService {
    Ingredient create(Ingredient ingredient);

    Collection<Ingredient> list(int limit);

    Ingredient get(Long id);

    Ingredient update(Ingredient ingredient);

    Boolean delete(Long id);
}
