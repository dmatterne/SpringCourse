package be.david.spring_jpa;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FILM_ID")
    private Integer id;
    private String title;
    private int release_year;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FILM_ACTOR",
    joinColumns = @JoinColumn(name="FILM_ID"),
    inverseJoinColumns = @JoinColumn(name = "ACTOR_ID"))
    private List<Actor> actors = new ArrayList<>();

    public Film() {
    }

    public Film(String title, int release_year, String description) {
        this.title = title;
        this.release_year = release_year;
        this.description = description;
    }


    public List<Actor> getActors() {
        return actors;
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

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String stringFilms= "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release_year=" + release_year +
                ", description='" + description + '\'' +
                '}';


        return stringFilms;
    }
}
