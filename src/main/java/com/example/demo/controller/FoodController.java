package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.service.FoodService;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class FoodController {
    @Autowired
    FoodService foodService;

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ResponseEntity<List<Food>> listFood() {
        List<Food> foodList = foodService.findAll();
        if (foodList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(foodList, HttpStatus.OK);
    }

    @RequestMapping(value = "/food/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createFood(@RequestBody Food food) throws Exception {
        Food food1 = foodService.findById(food.getFoodId());

        if (food1 != null) {
            throw new Exception("tên món ăn đã tồn tại");
        } else {
            foodService.save(food);
            HttpHeaders headers = new HttpHeaders();
            System.out.println(headers);
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/food/search", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Food>> listRoomSearch(@RequestParam("foodName") String foodName){
        ArrayList<Food> foodArray;
        foodArray = foodService.findByName(foodName);
        if (foodArray.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodArray, HttpStatus.OK);
    }
}
