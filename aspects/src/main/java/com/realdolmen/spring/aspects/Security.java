package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Chimp;
import com.realdolmen.spring.domain.EscapedAnimalException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Objects;

// TODO: Turn the security class into a Spring AOP aspect
@Aspect
@Component
public class Security {
    // TODO: Create an advice that is capable of preventing an animal from trying to call zoo.releaseAnimal()
    // TODO: When any animal except Chimps try to escape, prevent it from happening (preventEscapeOf()
    // TODO: When a Chimp escapes, we need to sound the alert by throwing an EscapedAnimalException


    @Around(value = "execution(void *.releaseAnimal(com.realdolmen.spring.domain.Animal)) && args(animal)")
    public void stopFromReleasingAnimal(ProceedingJoinPoint jp, Animal animal) throws Throwable {
        if (animal.getClass() != Chimp.class) {
//        if (animal instanceof Chimp) {
            preventEscapeOf(animal);
        } else {
            jp.proceed();
            throw new EscapedAnimalException(animal);
        }
    }


    /**
     * Prevents escaping of an animal.
     * @param animal The animal to prevent scape of.
     */
    private void preventEscapeOf(Animal animal) {
        Objects.requireNonNull(animal);
        System.out.println();
        System.out.println("***********************************************");
        System.out.format("Preventing %s '%s' from escaping!%n", animal.type(), animal.getName());
        System.out.println("***********************************************");
        System.out.println(
            "     ||   ||     ||   ||\n" +
            "     ||   ||, , ,||   ||\n" +
            "     ||  (||/|/(\\||/  ||\n" +
            "     ||  ||| _'_`|||  ||\n" +
            "     ||   || o o ||   ||\n" +
            "     ||  (||  - `||)  ||\n" +
            "     ||   ||  =  ||   ||\n" +
            "     ||   ||\\___/||   ||\n" +
            "     ||___||) , (||___||\n" +
            "    /||---||-\\_/-||---||\\\n" +
            "   / ||--_||_____||_--|| \\\n" +
            "  (_(||)-| S123-45 |-(||)_)\n" +
            "|\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|"
        );
        System.out.println("***********************************************");
        System.out.println();
    }
}
