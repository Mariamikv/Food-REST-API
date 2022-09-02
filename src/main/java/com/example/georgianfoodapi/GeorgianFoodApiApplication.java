package com.example.georgianfoodapi;

import com.example.georgianfoodapi.models.Author;
import com.example.georgianfoodapi.models.Food;
import com.example.georgianfoodapi.models.Ingredient;
import com.example.georgianfoodapi.repository.AuthorRepository;
import com.example.georgianfoodapi.repository.FoodRepository;
import com.example.georgianfoodapi.repository.IngredientRepository;
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
    CommandLineRunner run(AuthorRepository repository, IngredientRepository ingredientRepository, FoodRepository foodRepository) {

        return args -> {
          repository.save(new Author(
                  1L,
                  "Mariam",
                  "Kvantaliani",
                  "mariamikv",
                  new ArrayList<>()
          ));

          foodRepository.save(new Food(
                  1L,
                  "food",
                  "imageUrl",
                  "smallDesc",
                  "longDesc",
                  MealType.BRANCH.getMealType(),
                  DishType.BREAD.getDishType(),
                  new ArrayList<>(),
                  "how to",
                  new Author(1L,
                          "Mariam",
                          "Kvantaliani",
                          "mariamikv",
                          new ArrayList<>())
          ));
        };
    }
}
