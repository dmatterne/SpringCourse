package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JpaAnimalRepository implements AnimalRepository {
    // TODO: create a transactional dao bean from this class

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Animal animal) {
        em.persist(animal);
    }

    @Override
    public Animal findById(int id) {
        return em.find(Animal.class,id);
    }

    @Override
    public List<Animal> findAll() {
        return em.createQuery("SELECT a FROM Animal a",Animal.class).getResultList();
    }

    @Override
    public void update(Animal animal) {
        em.merge(animal);
    }

    @Override
    public void remove(Animal animal) {
        em.remove(animal);
    }

    // TODO: inject a persistence context

    // TODO: implement AnimalRepository

    // TODO: implement findById()

    // TODO: implement findAll()

    // TODO: implement create()

    // TODO: implement update()

    // TODO: implement delete()
}