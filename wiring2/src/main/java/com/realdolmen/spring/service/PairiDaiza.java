package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cda5732 on 25/03/2015.
 */
public class PairiDaiza implements Zoo {

    // TODO Add maxAnimalCount, ownerName and ticketPrice, and load from properties


    @Value("${zoo.name}")
    private String name;
    @Value("${zoo.maxAnimalCount}")
    private int maxAnimalCount;
    @Value("${zoo.owner.name}")
    private String ownerName;
    @Value("${zoo.ticket.price}")
    private double ticketPrice;

    @Autowired
    private Environment env;


    private List<Animal> animals = new ArrayList<>();

    @Autowired
    private FoodDistributionService foodDistributionService;

    public PairiDaiza() {
    }

    public PairiDaiza(String name) {
        this.name = name;
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
        System.out.println("Welcome visitor to " + getName());
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }

    @Override
    public void feedAnimals() {
        foodDistributionService.feedAnimalsByType(animals);
    }


    @Override
    public double getAnimalPrice() {
        return this.ticketPrice;
    }

    @Override
    public String getZooOwnerName() {
        return this.ownerName;
    }

    @Override
    public int getMaxAnimalCount() {
        return this.maxAnimalCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxAnimalCount(int maxAnimalCount) {
        this.maxAnimalCount = maxAnimalCount;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
