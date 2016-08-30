package com.realdolmen.spring_course.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Primary
public class SlayDragonQuest implements Quest {
    @Override
    public void embark() {
        if(new Random().nextBoolean()) {
            throw new RuntimeException("Knight gets eaten ");
        } else {
            System.out.println("Going to slay dragon");
        }


    }
}
