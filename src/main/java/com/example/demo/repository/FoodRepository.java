package com.example.demo.repository;

import com.example.demo.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Query(value = "select * from food", nativeQuery = true)
    List<Food> findAll();

    @Query(value = "select * from food where food_id = ?1", nativeQuery = true)
    Food findById(int id);

    @Modifying
    @Query(value = "delete from food where food_id = ?1", nativeQuery = true)
    void deleteById(int id);

    @Modifying
    @Query(value = "update food set price = ?1 where food_id = ?2",nativeQuery = true)
    void edit(int price, int id);

    @Query(value = "select * from food where food_name like CONCAT('%', ?1, '%')", nativeQuery = true)
    ArrayList<Food> findByName(String name);
}
