package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.PastaOptions;

import java.util.List;

public interface PastaOptionsDAO {

    List<PastaOptions> findAll();

    PastaOptions findById(int theId);

    PastaOptions save(PastaOptions pastaOptions);

    void deleteById(int theId);
}
