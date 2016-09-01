package com.realdolmen.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;

@ComponentScan
@EnableTransactionManagement
public class ZooConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


    @Bean
    @Profile("production")
    public DataSource ds () {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setPassword("root");
        ds.setUsername("root");
        ds.setUrl("jdbc:mysql://localhost:3306/sakila");

        return ds;

    }

//    @Bean
//    @Profile("production")
//    private Database db () {
//        return Database.MYSQL;
//    }
//
//    @Bean
//    @Profile("test")
//    private Database db2 () {
//        return Database.H2;
//    }


    @Bean
    @Profile("test")
    public DataSource ds2 () {

        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:/schema.sql").build();


    }


//    @Bean
//    private JpaVendorAdapter jv (Database  db) {
//        HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
//        jpa.setGenerateDdl(false);
//        jpa.setShowSql(true);
//        jpa.setDatabase(db);
//        return jpa;
//
//    }


    @Bean
    private JpaVendorAdapter jpaVendorAdapter () {

        HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
        jpa.setGenerateDdl(false);
        jpa.setShowSql(true);
        if(Arrays.asList(applicationContext.getEnvironment().getActiveProfiles()).contains("production")) {
            jpa.setDatabase(Database.MYSQL);
        } else {
            jpa.setDatabase(Database.H2);
        }
        return jpa;
    }


    @Bean
    private LocalContainerEntityManagerFactoryBean emf (DataSource ds, JpaVendorAdapter jp) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(ds);
        emf.setJpaVendorAdapter(jp);
        emf.setPackagesToScan("com.realdolmen.spring");
        return emf;

    }

    // TODO: Configure a DataSource for MySQL in the production profile (BasicDataSource)

    // TODO: configure an embedded DataSource for H2 in the test profile

    // TODO: Configure an EntityManagerFactory bean for use with Hibernate

    // TODO: Make sure your EntityManagerFactoryBean is set up for using dialect H2 in test and dialect MySQL in production
}
