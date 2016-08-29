package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.*;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.FoodRepositoryImpl;
import com.realdolmen.spring.service.PairiDaiza;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Configuration
@Profile("test")
@PropertySource("classpath:test.properties")
@ComponentScan(basePackages = "com.realdolmen.spring")
// TODO load test properties
// TODO configure a profile
// TODO use component scanning
public class TestConfig {


    @Bean
    public Zoo zoo() {
        Zoo zoo = new PairiDaiza();
        zoo.addAnimal(new Tiger("Bengal Tiger 2"));
        zoo.addAnimal(new Elephant("Indian Elephant"));
        zoo.addAnimal(new Bear("Brown Bear"));
        return zoo;
    }

    @Bean
    public FoodRepository foodRepository2() {
        FoodRepository foodRepository = new FoodRepositoryImpl();
        foodRepository.addFoodForAnimalType(Tiger.class, new MeatyFood("Red Antilope Meat 2"));
        foodRepository.addFoodForAnimalType(Bear.class, new MeatyFood("Pink Salmon"));
        foodRepository.addFoodForAnimalType(Elephant.class, new VegiFood("Cabbage"));
        return foodRepository;
    }

   // TODO configure the properties loader

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
