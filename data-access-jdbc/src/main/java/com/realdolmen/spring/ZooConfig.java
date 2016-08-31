package com.realdolmen.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ZooConfig {
    // TODO: add a datasource for the production profile. We will use BasicDataSource from Apache DBCP. Use connection properties for MySQL (url = "jdbc:mysql://localhost:3306/zoo", user = "root", password = "")

    @Profile("production")
    @Bean


    // TODO: add a JDBC template
}
