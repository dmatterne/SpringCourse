package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.domain.VegiFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// TODO: Implement the FoodRepository

@Repository
public class JdbcFoodRepository implements FoodRepository {

    @Autowired
    private JdbcTemplate jt;
    // TODO: Inject a reference to your JdbcTemplate

    // TODO: Implement findAllFood() and create a RowMapper to make this easier!

    // TODO: Implement findFoodById() and reuse your RowMapper

    // TODO: Implement findFoodForAnimalType()

    // TODO: Implement removeFood()


    private RowMapper<Food> rm = (rs, i) -> {

        int id = rs.getInt("id");
        String name = rs.getNString("name");
        int cal = rs.getInt("calories");
        String fclass = rs.getNString("food_class");
        String mtype = rs.getNString("meaty_food_type");
        boolean fruit = rs.getBoolean("fruit");
        boolean veg = rs.getBoolean("vegetables");

        if (fclass.equals(MeatyFood.class.getSimpleName())) {
            if (mtype != null) {
                return new MeatyFood(id, name, cal, MeatyFood.Type.valueOf(mtype));
            } else {
                return new MeatyFood(id, name, cal, null);
            }
        } else if (fclass.equals(VegiFood.class.getSimpleName())) {

            return new VegiFood (id,name,cal,fruit,veg);
        } else {
            return null;
        }



    };



    public JdbcFoodRepository() {
    }

    @Override
    public Food findFoodById(int id) {

        return jt.queryForObject("SELECT * FROM FOOD WHERE id = ?",rm,id);
    }

    @Override
    public List<Food> findAllFood() {
        return jt.query("SELECT * FROM FOOD",rm);
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {

        return jt.query("SELECT f.* FROM FOOD f\n" +
                "INNER JOIN ANIMAL_DIET ad ON ad.FOOD_ID = f.ID\n" +
                "WHERE ad.ANIMAL_TYPE = ? ORDER BY f.NAME ASC" , rm, type.name() );
    }

    @Override
    public void addFoodForAnimalType(Animal.Type animalType, Food food) {
        if (food instanceof VegiFood) {
            addFood((VegiFood) food);
        }

        if (food instanceof MeatyFood){
           addFood((MeatyFood) food);
        }

        jt.update("INSERT INTO ANIMAL_DIET (ANIMAL_TYPE,FOOD_ID) VALUES (?,?)",animalType.name(),food.getId());
    }


    private void addFood(MeatyFood food) {

        jt.update("INSERT INTO FOOD(ID,NAME,CALORIES,FOOD_CLASS, MEATY_FOOD_TYPE) VALUES (?,?,?,?,?)"
                , food.getId()
                , food.getName()
                , food.getCalories()
                , food.getClass().getName()
                , food.getType()
        );
    }

    private void addFood(VegiFood food) {

            jt.update("INSERT INTO FOOD (ID,NAME,CALORIES,FOOD_CLASS,FRUIT,VEGETABLES) VALUES (?,?,?,?,?,?)"
                    , food.getId()
                    , food.getName()
                    , food.getCalories()
                    , food.getClass().getName()
                    , food.isFruit()
                    , food.isVegetables()
            );
    }

    @Override
    public void removeFood(Food food) {
        jt.update("DELETE FROM ANIMAL_DIET WHERE FOOD_ID = ?", food.getId());
        jt.update("DELETE FROM FOOD WHERE ID = ?", food.getId());
    }
}
