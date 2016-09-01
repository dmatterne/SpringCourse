package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Blog;
import com.realdolmen.spring.blog.domain.Comment;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
public interface CommentRepository extends JpaRepository<Blog, Integer> {

        //List<Blog> findBlogPostOrderByCreationDateDesc();


    List<Comment> findFirst50CommentByBlogPost_IdOrderByCreationDateDesc(int id);

   // Find the first 50 comments by blog post id ordered by creation date descending

}

