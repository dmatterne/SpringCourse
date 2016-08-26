package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.repository.FoodRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
public class FoodRepositoryImpl implements FoodRepository {

    private Map<String, Food> feed = new HashMap<>();

    @Override
    public void addFoodForAnimalType(Class<? extends Animal> clazz, Food food) {
        feed.put(clazz.getName(),food);
    }

    @Override
    public Food findFoodForAnimalType(Class<? extends Animal> clazz) {
        return feed.get(clazz.getName());
    }

    public FoodRepositoryImpl() {

    }


}
