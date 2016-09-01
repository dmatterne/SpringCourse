package be.david.spring_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        FilmRepository fr  = context.getBean(FilmRepository.class);
        //System.out.println(fr.findById(1));

        List<Film> lf = fr.findAll();

        for (Film f: lf) {

            System.out.println(f);
            for (Actor a: f.getActors()) {
                System.out.println("\t - " + a.getFirstName() + " " + a.getLastName());
            }
        }



    }


    @Bean
    public DataSource ds () {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/sakila");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public HibernateJpaVendorAdapter jva () {
        HibernateJpaVendorAdapter jp = new HibernateJpaVendorAdapter();
        jp.setDatabase(Database.MYSQL);
        jp.setShowSql(true);
        jp.setGenerateDdl(false);
        return jp;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean (DataSource ds,JpaVendorAdapter jp) {
        LocalContainerEntityManagerFactoryBean lb = new LocalContainerEntityManagerFactoryBean();
        lb.setDataSource(ds);
        lb.setJpaVendorAdapter(jp);
        lb.setPackagesToScan("be.david.spring_jpa");
        return lb;
    }

}
