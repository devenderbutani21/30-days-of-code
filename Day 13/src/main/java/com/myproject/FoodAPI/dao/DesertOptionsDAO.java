package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.DesertOptions;

import java.util.List;

public interface DesertOptionsDAO {

    List<DesertOptions> findAll();

    DesertOptions findById(int theId);

    DesertOptions save(DesertOptions desertOptions);

    void deleteById(int theId);
}
