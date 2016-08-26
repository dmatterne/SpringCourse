package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
public class ZooImpl implements Zoo {

    private String name;
    private List<Animal> animals;

    public ZooImpl(String name) {
        this.name = name;
        animals = new ArrayList<Animal>();
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public boolean accept(Visitor visitor) {
        System.out.println("Welcome visitor " + visitor.getName());
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }
}
