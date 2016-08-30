package com.realdolmen.spring_course.domain;


import org.aspectj.lang.ProceedingJoinPoint;
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

    @Pointcut("execution(* *.embarkOnQuest())")
    public void embarksOnQuest() {

    }

//    @Pointcut("execution(* *.embark(..))")
//    public void embarks() {
//
//    }

    @Before("embarksOnQuest()")
    public void singBeforeQuest() {
        System.out.println("Is het een vliegtuig, is het een vogel, nee dat is het NIET, het is MEGA-KNIGHT die je aan de hemel ziet!");
    }

    @After("execution(* *.embark(java.lang.String))")
    public void singAfterQuest() {
        System.out.println("La la la the quest has ended");
    }

    @AfterReturning(value = "execution(* *.embark(java.lang.String)) && args(who)", returning = "spoils")
    @Order(1)
    public void singAfterQuestComplete(String spoils, String who) {
        System.out.println("And he lived happily ever after with his " + spoils + " from " + who);
    }

    @AfterThrowing(value = "execution(* *.embark(java.lang.String))", throwing = "error")
    public void singAfterQuestFails(RuntimeException error) {
        System.out.println("Ding Dong The Knight is dead, which old knight, the wicked Knight " + error.getMessage());
    }


    @Around(value = "execution(* *.embark(java.lang.String))")
    public void watchQuest(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("##################" + jp.getSignature() +"#####################");
        //jp.proceed();
    }

}
