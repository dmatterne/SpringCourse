package com.realdolmen.spring.domain;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
public abstract class Animal {
    private String name;


    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
