package com.realdolmen.spring_course.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
//        ApplicationContext ac = SpringApplication.run(MyConfiguration.class);
        ApplicationContext ac = SpringApplication.run(Runner.class);
        Knight k = ac.getBean(Knight.class);
        k.embarkOnQuest();
    }
}
