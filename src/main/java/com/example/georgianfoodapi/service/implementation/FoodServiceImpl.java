package com.example.georgianfoodapi.service.implementation;

import com.example.georgianfoodapi.models.Food;
import com.example.georgianfoodapi.repository.FoodRepository;
import com.example.georgianfoodapi.service.FoodService;
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
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public Food create(Food food) {
        log.info("saving new food: {}", food.getTitle());

        return foodRepository.save(food);
    }

    @Override
    public Food getByTitle(String title) {
        log.info("find food by title: {}", title);

        return foodRepository.findFoodByTitle(title);
    }

    @Override
    public Collection<Food> list(int limit) {
        log.info("fetching all foods");

        return foodRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Food get(Long id) {
        log.info("fetching food by Id: {}", id);

        return foodRepository.findById(id).get();
    }

    @Override
    public Food update(Food food) {
        log.info("update food: {}", food.getTitle());

        return foodRepository.save(food);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("delete food by Id: {}", id);
        foodRepository.deleteById(id);

        return true;
    }
}
