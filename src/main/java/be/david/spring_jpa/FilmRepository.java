package be.david.spring_jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by stannisbaratheon on 01/09/16.
 */
@Repository
public class FilmRepository {

    @PersistenceContext
    private EntityManager em;


    public Film findById(int id) {
        return em.find(Film.class,id);
    }

    public void save(Film f) {
        em.persist(f);
    }

    public List<Film>  findAll() {
        return em.createQuery("SELECT F FROM Film F",Film.class).getResultList();
    }



}
