package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.DefaultRestaurant;
import com.realdolmen.spring.domain.Restaurant;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

// TODO: Create a new Aspect Facilities
@Aspect
@Component
public class Facilities {
    // TODO: Configure a new introduction that combines Zoo and Restaurant

    @DeclareParents(value = "com.realdolmen.spring.domain.Zoo+", defaultImpl = DefaultRestaurant.class)
    public Restaurant rest;

}



