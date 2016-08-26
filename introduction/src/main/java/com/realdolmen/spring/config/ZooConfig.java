package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Bear;
import com.realdolmen.spring.domain.Elephant;
import com.realdolmen.spring.domain.Tiger;
import com.realdolmen.spring.service.Zoo;
import com.realdolmen.spring.service.ZooImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by stannisbaratheon on 26/08/16.
 */
@Configuration
public class ZooConfig {

    @Bean
    public Zoo zoo() {
        Zoo z = new ZooImpl("Pairi Daiza");
        Animal t  = new Tiger();
        t.setName("Tijgertje");
        Animal b = new Bear();
        b.setName("Baloo");
        Animal e = new Elephant();
        e.setName("Dumbo");

        z.addAnimal(t);
        z.addAnimal(b);
        z.addAnimal(e);
        z.releaseAnimal(t);

        return z;
    }
}
