package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.BeverageOptions;

import java.util.List;

public interface BeverageOptionsDAO {

    List<BeverageOptions> findAll();

    BeverageOptions findById(int theId);

    BeverageOptions save(BeverageOptions beverageOptions);

    void deleteById(int theId);
}
