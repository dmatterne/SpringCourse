package com.realdolmen.spring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// TODO: Turn this class into a Spring Bean and an Aspect
@Aspect
@Component
public class BookKeeping {
    // TODO: Add an advice that advises the Zoo.accept(Visitor) method

    private int happyVisitor = 0;
    private int unhappyVisitor = 0;

    @Pointcut("execution(boolean *..Zoo.accept(com.realdolmen.spring.domain.Visitor))")
    public void adviseZooAccept () {

    }

    // TODO: Make sure the advice uses the return value of the the adviced method to keep track of happy and unhappy visitors


    @AfterReturning(value = "adviseZooAccept()", returning = "happyBln")
    public void checkVisitor(boolean happyBln) {
        if (happyBln)
        {
            happyVisitor += 1;
        } else {
            unhappyVisitor += 1;
        }
    }


    public int getHappyVisitorCount() {

        return happyVisitor;
    }

    public int getUnhappyVisitorCount() {

        return unhappyVisitor;
    }
}
