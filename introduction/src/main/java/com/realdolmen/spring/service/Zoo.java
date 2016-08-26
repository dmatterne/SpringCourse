package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
public interface Zoo {

    void addAnimal(Animal animal);
    void releaseAnimal(Animal animal);
    boolean accept(Visitor visitor);
    String getName();
    int countAnimals();

}
