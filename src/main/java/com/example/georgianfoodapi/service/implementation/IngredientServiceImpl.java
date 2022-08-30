package com.example.georgianfoodapi.service.implementation;

import com.example.georgianfoodapi.models.Ingredient;
import com.example.georgianfoodapi.repository.IngredientRepository;
import com.example.georgianfoodapi.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient create(Ingredient ingredient) {
        log.info("saving new Ingredient: {}", ingredient.getFood());

        return ingredientRepository.save(ingredient);
    }

    @Override
    public Collection<Ingredient> list(int limit) {
        log.info("fetching all Ingredient");

        return ingredientRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Ingredient get(Long id) {
        log.info("fetching ingredient by Id: {}", id);

        return ingredientRepository.findById(id).get();
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        log.info("update ingredient: {}", ingredient.getFood());

        return ingredientRepository.save(ingredient);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("delete ingredient by Id: {}", id);
        ingredientRepository.deleteById(id);

        return true;
    }
}
