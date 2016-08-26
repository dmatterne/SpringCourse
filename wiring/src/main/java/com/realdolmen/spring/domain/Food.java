package com.realdolmen.spring.domain;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
public class Food {

    private String name;

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
