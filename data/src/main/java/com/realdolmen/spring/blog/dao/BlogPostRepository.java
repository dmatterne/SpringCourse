package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {

        //List<Blog> findBlogPostOrderByCreationDateDesc();

}
