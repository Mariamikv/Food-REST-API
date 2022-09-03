package com.example.georgianfoodapi;

import com.example.georgianfoodapi.models.Author;
import com.example.georgianfoodapi.models.Food;
import com.example.georgianfoodapi.models.Ingredient;
import com.example.georgianfoodapi.repository.AuthorRepository;
import com.example.georgianfoodapi.repository.FoodRepository;
import com.example.georgianfoodapi.repository.IngredientRepository;
import com.example.georgianfoodapi.service.AuthorService;
import com.example.georgianfoodapi.service.IngredientService;
import com.example.georgianfoodapi.service.implementation.AuthorServiceImpl;
import com.example.georgianfoodapi.service.implementation.FoodServiceImpl;
import com.example.georgianfoodapi.service.implementation.IngredientServiceImpl;
import com.example.georgianfoodapi.utils.DishType;
import com.example.georgianfoodapi.utils.MealType;
import com.example.georgianfoodapi.utils.MeasureType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class GeorgianFoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeorgianFoodApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AuthorServiceImpl authorService, IngredientServiceImpl ingredientService, FoodServiceImpl foodService) {

        return args -> {

            Author author = new Author(
                    "Mariam",
                    "Kvantaliani",
                    "mariamikv"
            );
            authorService.create(author);

            Food food = new Food(
                    "title",
                    "imageUrl",
                    "smallDesc",
                    "longDesc",
                    MealType.LUNCH.getMealType(),
                    DishType.DESSERTS.getDishType(),
                    "how to cook",
                    author
            );

            foodService.create(food);

            Ingredient ingredient = new Ingredient(
                    "title",
                    23F,
                    MeasureType.GRAM.getMeasureType(),
                    12F,
                    food
            );

            ingredientService.create(ingredient);

        };
    }
}
