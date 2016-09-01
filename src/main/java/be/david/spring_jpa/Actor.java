package be.david.spring_jpa;

import javax.persistence.*;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACTOR_ID")
    private Integer id;
    private String first_name;
    private String last_name;

    public Actor() {
    }

    public Actor(String firstName, String lastName) {
        first_name = firstName;
        last_name = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        last_name = lastName;
    }
}
