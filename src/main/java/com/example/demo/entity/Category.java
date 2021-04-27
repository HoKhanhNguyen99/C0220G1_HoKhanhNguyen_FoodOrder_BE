package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryFoodId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "category_food", //Tạo ra một join Table tên là "address_person"
            joinColumns = @JoinColumn(name = "category_id"),  // TRong đó, khóa ngoại chính là address_id trỏ tới class hiện tại (Address)
            inverseJoinColumns = @JoinColumn(name = "food_id") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Person)
    )
    private Collection<Food> food;

    public Category() {
    }

    public int getCategoryFoodId() {
        return categoryFoodId;
    }

    public void setCategoryFoodId(int categoryFoodId) {
        this.categoryFoodId = categoryFoodId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Food> getFood() {
        return food;
    }

    public void setFood(Collection<Food> food) {
        this.food = food;
    }
}
