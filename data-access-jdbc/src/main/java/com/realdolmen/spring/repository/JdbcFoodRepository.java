package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// TODO: Implement the FoodRepository

@Repository
public class JdbcFoodRepository implements FoodRepository {

    @Autowired
    private JdbcTemplate jt;
    // TODO: Inject a reference to your JdbcTemplate

    // TODO: Implement findAllFood() and create a RowMapper to make this easier!

    // TODO: Implement findFoodById() and reuse your RowMapper

    // TODO: Implement findFoodForAnimalType()

    // TODO: Implement removeFood()


    public JdbcFoodRepository() {
    }

    @Override
    public Food findFoodById(int id) {
        return null;
    }

    @Override
    public List<Food> findAllFood() {
        return null;
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        return null;
    }

    @Override
    public void addFoodForAnimalType(Animal.Type animalType, Food food) {

    }

    @Override
    public void removeFood(Food food) {

    }
}
