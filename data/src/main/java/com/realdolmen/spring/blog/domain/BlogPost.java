package com.realdolmen.spring.blog.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private LocalDate creationDate;

    private LocalDate updatedDate;

    @ManyToOne
    private Blog blog;

    public BlogPost() {
    }

    public BlogPost(String title, String content, LocalDate creationDate, LocalDate updatedDate, Blog blog) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
        this.blog = blog;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", updatedDate=" + updatedDate +
                ", blog=" + blog +
                '}';
    }
}
