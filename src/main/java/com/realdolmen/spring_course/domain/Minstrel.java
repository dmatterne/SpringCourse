package com.realdolmen.spring_course.domain;


import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by stannisbaratheon on 30/08/16.
 */
@Component
@Aspect
public class Minstrel {

    public Minstrel() {
    }

    @Pointcut("execution(* *.embarkOnQuest(..))")
    public void embarksOnQuest() {

    }

    @Pointcut("execution(* *.embark(..))")
    public void embarks() {

    }

    @Before("embarksOnQuest()")
    public void singBeforeQuest() {
        System.out.println("Is het een vliegtuig, is het een vogel, nee dat is het NIET, het is MEGA-KNIGHT die je aan de hemel ziet!");
    }

    @After("embarks()")
    @Order(2)
    public void singAfterQuest() {
        System.out.println("La la la the quest has ended");
    }

    @AfterReturning("embarks()")
    @Order(1)
    public void singAfterQuestComplete() {
        System.out.println("And he lived happily ever after!");
    }

    @AfterThrowing("embarks()")
    @Order(1)
    public void singAfterQuestFails() {
        System.out.println("Ding Dong The Knight is dead, which old knight, the wicked Knight");
    }


}
