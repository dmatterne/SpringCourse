package com.realdolmen.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class ZooConfig {
    // TODO: add a datasource for the production profile. We will use BasicDataSource from Apache DBCP.
    // Use connection properties for MySQL (url = "jdbc:mysql://localhost:3306/zoo", user = "root", password = "")

    @Profile("production")
    @Bean
    public BasicDataSource bsd() {
        BasicDataSource bs = new BasicDataSource();
        bs.setDriverClassName("org.h2.Driver");
        bs.setUrl("jdbc:mysql://localhost:3306/zoo");
        bs.setUsername("root");
        bs.setPassword("");
        bs.setInitialSize(5);
        bs.setMaxActive(10);
        return bs;
    }



    // TODO: add a JDBC template
    @Bean
    public JdbcTemplate jdbc(DataSource ds) {
        JdbcTemplate jd = new JdbcTemplate(ds);

        return jd;
    }

}
