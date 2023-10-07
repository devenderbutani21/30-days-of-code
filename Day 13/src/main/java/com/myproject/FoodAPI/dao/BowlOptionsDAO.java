package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.BowlOptions;

import java.util.List;

public interface BowlOptionsDAO {

    List<BowlOptions> findAll();

    BowlOptions findById(int theId);

    BowlOptions save(BowlOptions bowlOptions);

    void deleteById(int theId);

}
