package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.BeverageOptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeverageOptionsDAOImpl implements BeverageOptionsDAO {

    private EntityManager entityManager;

    @Autowired
    public BeverageOptionsDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<BeverageOptions> findAll() {
        TypedQuery<BeverageOptions> theQuery = entityManager.createQuery("from BeverageOptions", BeverageOptions.class);

        List<BeverageOptions> beverageOptions = theQuery.getResultList();

        return beverageOptions;
    }

    @Override
    public BeverageOptions findById(int theId) {
        BeverageOptions theBeverageOption = entityManager.find(BeverageOptions.class, theId);

        return theBeverageOption;
    }

    @Override
    public BeverageOptions save(BeverageOptions BeverageOptions) {
        BeverageOptions theBeverageOption = entityManager.merge(BeverageOptions);

        return theBeverageOption;
    }

    @Override
    public void deleteById(int theId) {
        BeverageOptions theBeverageOption = entityManager.find(BeverageOptions.class, theId);
        entityManager.remove(theBeverageOption);
    }

}
