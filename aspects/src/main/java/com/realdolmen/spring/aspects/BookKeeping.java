package com.realdolmen.spring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// TODO: Turn this class into a Spring Bean and an Aspect
@Aspect
public class BookKeeping {
    // TODO: Add an advice that advises the Zoo.accept(Visitor) method

    @Pointcut("execution( boolean Zoo.accept(Visitor))")
    public void adviseZooAccept () {

    }

    // TODO: Make sure the advice uses the return value of the the adviced method to keep track of happy and unhappy visitors

    @After(value = "")
    public int getHappyVisitorCount() {
        return 0;
    }

    public int getUnhappyVisitorCount() {
        return 0;
    }
}
