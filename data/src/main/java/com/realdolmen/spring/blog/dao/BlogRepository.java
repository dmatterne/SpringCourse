package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {

        //List<Blog> findBlogPostOrderByCreationDateDesc();

}

