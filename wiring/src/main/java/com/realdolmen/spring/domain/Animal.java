package com.realdolmen.spring.domain;

/**
 * Created by cda5732 on 25/03/2015.
 */
public abstract class Animal {
    private String name;


    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Food f) {
        System.out.println("Feeding food " + f.getName() + " to " + this.getName());
    }

    // TODO Feed the Animal some Food
}
