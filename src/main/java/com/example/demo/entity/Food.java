package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;


@Entity
@Data
@Builder
@Table(name = "food")
public class Food {
    @Id
    @Column(name = "food_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    @NotNull
    @Size(max = 255, min = 1)
//    @Pattern(regexp = "^[a-zA-Z0-9\\,\\.\\-\\_\\@]{1,}$")
    @Column(name = "food_name", nullable = false, unique = true)
    @NotBlank(message = "Tên không được để trống")
    private String foodName;

    @NotNull
    @Column(name = "price", nullable = false)
    private int price;

    @ManyToMany(mappedBy = "food")
    private Collection<Category> category;

}
