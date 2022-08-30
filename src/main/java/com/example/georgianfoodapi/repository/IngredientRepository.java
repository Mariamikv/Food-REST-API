package com.example.georgianfoodapi.repository;

import com.example.georgianfoodapi.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
