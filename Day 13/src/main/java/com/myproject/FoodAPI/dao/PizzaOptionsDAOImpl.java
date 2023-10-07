package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.PizzaOptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaOptionsDAOImpl implements PizzaOptionsDAO {

    private EntityManager entityManager;

    @Autowired
    public PizzaOptionsDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<PizzaOptions> findAll() {

        TypedQuery<PizzaOptions> theQuery = entityManager.createQuery("from PizzaOptions", PizzaOptions.class);

        List<PizzaOptions> pizzaOptions = theQuery.getResultList();

        return pizzaOptions;
    }

    @Override
    public PizzaOptions findById(int theId) {
        PizzaOptions thePizzaOption = entityManager.find(PizzaOptions.class, theId);

        return thePizzaOption;
    }

    @Override
    public PizzaOptions save(PizzaOptions pizzaOptions) {
        PizzaOptions thePizzaOption = entityManager.merge(pizzaOptions);

        return thePizzaOption;
    }

    @Override
    public void deleteById(int theId) {
        PizzaOptions thePizzaOption = entityManager.find(PizzaOptions.class, theId);
        entityManager.remove(thePizzaOption);
    }
}
