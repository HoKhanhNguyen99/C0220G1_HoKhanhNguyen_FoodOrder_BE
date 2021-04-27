package com.example.demo.service;

import com.example.demo.entity.Food;

import java.util.ArrayList;
import java.util.List;

public interface FoodService {
    List<Food> findAll();

    Food findById(int id);

    void delete(int id);

    void edit(int price, int id);

    void save(Food food);

    ArrayList<Food> findByName(String name);
}
