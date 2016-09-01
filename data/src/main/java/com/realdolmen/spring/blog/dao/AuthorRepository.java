package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {

        //List<Blog> findBlogPostOrderByCreationDateDesc();

}

