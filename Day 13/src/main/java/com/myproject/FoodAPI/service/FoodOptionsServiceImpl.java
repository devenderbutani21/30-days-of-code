package com.myproject.FoodAPI.service;

import com.myproject.FoodAPI.dao.*;
import com.myproject.FoodAPI.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOptionsServiceImpl implements FoodOptionsService{

    private BeverageOptionsDAO beverageOptionsDAO;

    private BowlOptionsDAO bowlOptionsDAO;

    private DesertOptionsDAO desertOptionsDAO;

    private PastaOptionsDAO pastaOptionsDAO;

    private PizzaOptionsDAO pizzaOptionsDAO;

    public FoodOptionsServiceImpl(BeverageOptionsDAO thebeverageOptionsDAO, BowlOptionsDAO thebowlOptionsDAO, DesertOptionsDAO thedesertOptionsDAO, PastaOptionsDAO thePastaOptionsDAO,PizzaOptionsDAO thePizzaOptionsDAO) {
        beverageOptionsDAO = thebeverageOptionsDAO;
        bowlOptionsDAO = thebowlOptionsDAO;
        desertOptionsDAO = thedesertOptionsDAO;
        pastaOptionsDAO = thePastaOptionsDAO;
        pizzaOptionsDAO = thePizzaOptionsDAO;
    }

    // Beverage
    @Override
    public List<BeverageOptions> findAllBeverageOptions() {
        return beverageOptionsDAO.findAll();
    }

    @Override
    public BeverageOptions findBeverageOptionById(int theId) {
        return beverageOptionsDAO.findById(theId);
    }

    @Transactional
    @Override
    public BeverageOptions saveBeverageOption(BeverageOptions beverageOptions) {
        return beverageOptionsDAO.save(beverageOptions);
    }

    @Transactional
    @Override
    public void deleteBeverageOptionById(int theId) {
        beverageOptionsDAO.deleteById(theId);
    }

    // Bowl
    @Override
    public List<BowlOptions> findAllBowlOptions() {
        return bowlOptionsDAO.findAll();
    }

    @Override
    public BowlOptions findBowlOptionById(int theId) {
        return bowlOptionsDAO.findById(theId);
    }

    @Transactional
    @Override
    public BowlOptions saveBowlOption(BowlOptions bowlOptions) {
        return bowlOptionsDAO.save(bowlOptions);
    }

    @Transactional
    @Override
    public void deleteBowlOptionById(int theId) {
        bowlOptionsDAO.deleteById(theId);
    }

    // Desert
    @Override
    public List<DesertOptions> findAllDesertOptions() {
        return desertOptionsDAO.findAll();
    }

    @Override
    public DesertOptions findDesertOptionById(int theId) {
        return desertOptionsDAO.findById(theId);
    }

    @Transactional
    @Override
    public DesertOptions saveDesertOption(DesertOptions desertOptions) {
        return desertOptionsDAO.save(desertOptions);
    }

    @Transactional
    @Override
    public void deleteDesertOptionById(int theId) {
        desertOptionsDAO.deleteById(theId);
    }

    // Pasta
    @Override
    public List<PastaOptions> findAllPastaOptions() {
        return pastaOptionsDAO.findAll();
    }

    @Override
    public PastaOptions findPastaOptionById(int theId) {
        return pastaOptionsDAO.findById(theId);
    }

    @Transactional
    @Override
    public PastaOptions savePastaOption(PastaOptions PastaOptions) {
        return pastaOptionsDAO.save(PastaOptions);
    }

    @Transactional
    @Override
    public void deletePastaOptionById(int theId) {
        pastaOptionsDAO.deleteById(theId);
    }

    // Pizza
    @Override
    public List<PizzaOptions> findAllPizzaOptions() {
        return pizzaOptionsDAO.findAll();
    }

    @Override
    public PizzaOptions findPizzaOptionById(int theId) {
        return pizzaOptionsDAO.findById(theId);
    }

    @Transactional
    @Override
    public PizzaOptions savePizzaOption(PizzaOptions pizzaOptions) {
        return pizzaOptionsDAO.save(pizzaOptions);
    }

    @Transactional
    @Override
    public void deletePizzaOptionById(int theId) {
        pizzaOptionsDAO.deleteById(theId);
    }

}
