package com.realdolmen.spring.blog.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private LocalDate creationDate;

    private String authorName;

    @ManyToOne
    private BlogPost blogPost;


    public Comment() {
    }

    public Comment(String content, LocalDate creationDate, String authorName, BlogPost blogPost) {
        this.content = content;
        this.creationDate = creationDate;
        this.authorName = authorName;
        this.blogPost = blogPost;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }
}
