package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Author;
import com.realdolmen.spring.blog.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by cda5732 on 14/04/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
// TODO Activate the test profile
// TODO Activate transactions

@ActiveProfiles("test")
@Transactional
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository author;

    // TODO wire in the dao


    @Test
    public void findAllAuthors() {
        Author a = new Author();
        a.setFirstname("David");
        a.setLastname("Matterne");
        a.setUsername("David");
        a.setPassword("Matterne");
        a.setEmail("david.matterne@test.com");

        author.save(a);

        assertEquals(1,author.findAll().size());
    }

    // TODO add unit tests to test the dao


}
