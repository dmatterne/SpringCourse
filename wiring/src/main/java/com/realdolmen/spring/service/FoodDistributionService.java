package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;

import java.util.List;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
public interface FoodDistributionService {

    void feedAnimalsByType(List<Animal> a);
}