package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JpaFoodRepository implements FoodRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Food findFoodById(int id) {
        return em.find(Food.class,id);
    }

    @Override
    public List<Food> findAllFood() {
        return em.createQuery("SELECT f FROM Food f",Food.class).getResultList();
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        System.out.println(type.name() + "/" + type.toString());
        return em.createQuery("select d.food from DietEntry d where d.animalType = :aType order by d.food.name ASC",Food.class).setParameter("aType",type).getResultList();
    }

    @Override
    public void removeFood(Food food) {
         em.remove(food);
    }

    // TODO: Create a transactional dao bean implementing FoodRepository

    // TODO: implement findFoodById()

    // TODO: implement findAllFood()

    // TODO: implement findFoodForAnimalType()

    // TODO: implement removeFood()
}
