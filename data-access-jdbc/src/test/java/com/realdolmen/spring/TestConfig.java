package com.realdolmen.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class TestConfig {
    // TODO: Use this class to add an embedded datasource for the test profile (you will have to set this up yourself)

    @Profile("test")
    @Bean
    private DataSource embeddedDataSource () {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("")
                .addScript("")
                .build();

    }

}
