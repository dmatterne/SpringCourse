package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Blog;
import com.realdolmen.spring.blog.domain.Comment;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

        //List<Blog> findBlogPostOrderByCreationDateDesc();


    ArrayList<Comment> findFirst2CommentByBlogPost_IdOrderByCreationDateDesc(int id);

   // Find the first 50 comments by blog post id ordered by creation date descending

}

