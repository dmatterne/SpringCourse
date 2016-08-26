package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
public interface FoodRepository {
    void addFoodForAnimalType(Class<? extends Animal> clazz, Food food);
    Food findFoodForAnimalType(Class<? extends Animal> clazz);

}
