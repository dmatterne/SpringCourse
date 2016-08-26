package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.FoodRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
@Component
public class FoodDistributionServiceImpl implements FoodDistributionService {

    @Autowired
    private FoodRepository fr;

    @Override
    public void feedAnimalsByType(List<Animal> a) {
            for(Animal an: a) {

                an.feed(fr.findFoodForAnimalType(an.getClass()));
            }
    }
}
