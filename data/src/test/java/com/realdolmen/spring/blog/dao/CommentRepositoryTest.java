package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.config.TestConfig;
import com.realdolmen.spring.blog.domain.Author;
import com.realdolmen.spring.blog.domain.Blog;
import com.realdolmen.spring.blog.domain.BlogPost;
import com.realdolmen.spring.blog.domain.Comment;
import com.sun.tools.javac.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by cda5732 on 14/04/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
@Transactional
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // TODO wire in the dao


    @Test
    public void findFirstComments() {

        Author a = new Author();
        a.setFirstname("David");
        a.setLastname("Matterne");
        a.setUsername("David");
        a.setPassword("Matterne");
        a.setEmail("david.matterne@test.com");

        authorRepository.save(a);

        Blog b = new Blog("The Newest Blog",LocalDate.now(),a);

        blogRepository.save(b);

        BlogPost bp1 = new BlogPost("MyTestBlogPost1","Today was the last day we get lessons from Kevin",LocalDate.now(),LocalDate.now(),b);
        BlogPost bp2 = new BlogPost("MyTestBlogPost2","Today was the last day we get lessons from Kevin",LocalDate.now(),LocalDate.now(),b);
        BlogPost bp3 = new BlogPost("MyTestBlogPost3","Today was the last day we get lessons from Kevin",LocalDate.now(),LocalDate.now(),b);

        blogPostRepository.save(bp1);
        blogPostRepository.save(bp2);
        blogPostRepository.save(bp3);

        Comment c1 = new Comment("Comment1 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-01"),"ThisIsMyName",bp1);
        Comment c2 = new Comment("Comment2 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-02"),"ThisIsMyName",bp1);
        Comment c3 = new Comment("Comment3 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-03"),"ThisIsMyName",bp1);
        Comment d1 = new Comment("Comment4 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-01"),"ThisIsMyName",bp2);
        Comment d2 = new Comment("Comment5 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-02"),"ThisIsMyName",bp2);
        Comment d3 = new Comment("Comment6 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-03"),"ThisIsMyName",bp2);
        Comment e1 = new Comment("Comment7 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-01"),"ThisIsMyName",bp3);
        Comment e2 = new Comment("Comment8 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-02"),"ThisIsMyName",bp3);
        Comment e3 = new Comment("Comment9 Comment Comment Comment Comment Comment",LocalDate.parse("2010-01-03"),"ThisIsMyName",bp3);


        commentRepository.save(c1);
        commentRepository.save(c2);
        commentRepository.save(c3);
        commentRepository.save(d1);
        commentRepository.save(d2);
        commentRepository.save(d3);
        commentRepository.save(e1);
        commentRepository.save(e2);
        commentRepository.save(e3);

        ArrayList<Comment> listcomments = commentRepository.findFirst2CommentByBlogPost_IdOrderByCreationDateDesc(bp3.getId());

        for (Comment com: listcomments) {
            System.out.println(com);
        }

        assertEquals(2,listcomments.size());

    }

    // TODO add unit tests to test the dao


}
