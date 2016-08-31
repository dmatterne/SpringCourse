package be.david.spring.jdbc;

import be.david.spring.jdbc.domain.Film;
import be.david.spring.jdbc.repositories.FilmRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by stannisbaratheon on 31/08/16.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

        FilmRepositoryImpl f = context.getBean(FilmRepositoryImpl.class);

        List<Film> fi = f.findAllFilms();

        for(Film film: fi) {
            System.out.println(film.toString());
        }

    }


    @Bean
    public DataSource ds () {

        DriverManagerDataSource dds = new DriverManagerDataSource();
        dds.setDriverClassName("com.mysql.jdbc.Driver");
        dds.setUrl("jdbc:mysql://localhost:3306/sakila");
        dds.setPassword("root");
        dds.setUsername("root");


        return dds;
    }
}
