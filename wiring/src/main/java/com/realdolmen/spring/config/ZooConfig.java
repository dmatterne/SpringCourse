package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.*;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.FoodRepositoryImpl;
import com.realdolmen.spring.service.PairiDaiza;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Created by cda5732 on 25/03/2015.
 */
@Configuration
public class ZooConfig {
    @Bean
    public Zoo zoo() {
        Zoo zoo = new PairiDaiza("Pairi Daiza");
        zoo.addAnimal(new Tiger("Bengal Tiger"));
        zoo.addAnimal(new Elephant("Indian Elephant"));
        zoo.addAnimal(new Bear("Brown Bear"));
        return zoo;
    }

    @Bean
    public FoodRepository fr () {

        FoodRepository food = new FoodRepositoryImpl();
        Food c = new MeatyFood("Chicken");
        Food s = new FishyFood("Salmon");
        Food g = new VegiFood("Grass");

        food.addFoodForAnimalType(Bear.class,s);

        food.addFoodForAnimalType(Tiger.class,c);

        food.addFoodForAnimalType(Elephant.class,g);

        return food;
    }

    // TODO Configure the FoodRepository
}
