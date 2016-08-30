package com.realdolmen.spring_course.domain;

import org.springframework.stereotype.Component;

@Component
public class RescueDamselQuest implements Quest {
    @Override
    public String embark(String who) {
        System.out.println("Going to rescue damsel from " + who);
        return "Damsel's Gold Chest";
    }
}
