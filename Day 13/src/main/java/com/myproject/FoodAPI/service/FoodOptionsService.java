package com.myproject.FoodAPI.service;

import com.myproject.FoodAPI.entity.*;

import java.util.List;

public interface FoodOptionsService {
    // Beverage
    List<BeverageOptions> findAllBeverageOptions();

    BeverageOptions findBeverageOptionById(int theId);

    BeverageOptions saveBeverageOption(BeverageOptions beverageOptions);

    void deleteBeverageOptionById(int theId);

    // Bowl
    List<BowlOptions> findAllBowlOptions();

    BowlOptions findBowlOptionById(int theId);

    BowlOptions saveBowlOption(BowlOptions bowlOptions);

    void deleteBowlOptionById(int theId);

    // Desert
    List<DesertOptions> findAllDesertOptions();

    DesertOptions findDesertOptionById(int theId);

    DesertOptions saveDesertOption(DesertOptions desertOptions);

    void deleteDesertOptionById(int theId);

    // Pasta
    List<PastaOptions> findAllPastaOptions();

    PastaOptions findPastaOptionById(int theId);

    PastaOptions savePastaOption(PastaOptions pastaOptions);

    void deletePastaOptionById(int theId);

    // Pizza
    List<PizzaOptions> findAllPizzaOptions();

    PizzaOptions findPizzaOptionById(int theId);

    PizzaOptions savePizzaOption(PizzaOptions pizzaOptions);

    void deletePizzaOptionById(int theId);
}
