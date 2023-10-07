package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.PizzaOptions;

import java.util.List;

public interface PizzaOptionsDAO {

    List<PizzaOptions> findAll();

    PizzaOptions findById(int theId);

    PizzaOptions save(PizzaOptions pizzaOptions);

    void deleteById(int theId);
}
