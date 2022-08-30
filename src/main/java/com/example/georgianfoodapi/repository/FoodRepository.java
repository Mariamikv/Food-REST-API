package com.example.georgianfoodapi.repository;

import com.example.georgianfoodapi.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findFoodByTitle(String title);

    // find by dishType, or mealType
}
