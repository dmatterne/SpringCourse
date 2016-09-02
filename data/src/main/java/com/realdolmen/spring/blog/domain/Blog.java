package com.realdolmen.spring.blog.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "id")
    private Author author;

    public Blog() {

    }

    public Blog(String title, LocalDate creationDate, Author author) {
        this.title = title;
        this.creationDate = creationDate;
        this.author = author;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", author=" + author +
                '}';
    }
}
