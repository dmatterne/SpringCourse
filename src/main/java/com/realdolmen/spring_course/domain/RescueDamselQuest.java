package com.realdolmen.spring_course.domain;

import org.springframework.stereotype.Component;

@Component
public class RescueDamselQuest implements Quest {
    @Override
    public String embark() {
        System.out.println("Going to rescue damsel!");
        return "Damsel's Gold Chest";
    }
}
