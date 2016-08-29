package com.realdolmen.spring.repository;

import com.realdolmen.spring.annotations.Kibble;
import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.KibbleFood;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cda5732 on 13/04/2015.
 */
@Repository
@Kibble
public class KibbleFoodRepositoryImpl implements FoodRepository {
    private Map<String, Food> feed = new HashMap<>();

    @Override
    public void addFoodForAnimalType(Class<? extends Animal> c, Food food) {
        feed.put(c.getName(), food);
    }

    @Override
    public Food findFoodForAnimalType(Class<? extends Animal> c) {
        return new KibbleFood("Kibble Kibble Kibble");
    }
}
