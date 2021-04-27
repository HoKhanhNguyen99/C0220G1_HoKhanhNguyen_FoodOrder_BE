package com.example.demo.service.Impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food findById(int id) {
        return foodRepository.findById(id);
    }

    @Override
    public void save(Food food) {
        foodRepository.save(food);
    }

    @Override
    public ArrayList<Food> findByName(String name) {
        return foodRepository.findByName(name);
    }

    @Override
    public void delete(int id) {
        foodRepository.deleteById(id);
    }

    @Override
    public void edit(int price, int id) {
        foodRepository.edit(price, id);
    }
}
