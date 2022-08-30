package com.example.georgianfoodapi.service;

import com.example.georgianfoodapi.models.Food;

import java.util.Collection;

public interface FoodService {
    Food create(Food food);

    Food getByTitle(String title);

    Collection<Food> list(int limit);

    Food get(Long id);

    Food update(Food food);

    Boolean delete(Long id);
}
