package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.BowlOptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BowlOptionsDAOImpl implements BowlOptionsDAO {


    private EntityManager entityManager;

    @Autowired
    public BowlOptionsDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<BowlOptions> findAll() {
        TypedQuery<BowlOptions> theQuery = entityManager.createQuery("from BowlOptions", BowlOptions.class);

        List<BowlOptions> bowlOptions = theQuery.getResultList();

        return bowlOptions;
    }

    @Override
    public BowlOptions findById(int theId) {
        BowlOptions theBowlOption = entityManager.find(BowlOptions.class, theId);

        return theBowlOption;
    }

    @Override
    public BowlOptions save(BowlOptions BowlOptions) {
        BowlOptions theBowlOption = entityManager.merge(BowlOptions);

        return theBowlOption;
    }

    @Override
    public void deleteById(int theId) {
        BowlOptions theBowlOption = entityManager.find(BowlOptions.class, theId);
        entityManager.remove(theBowlOption);
    }

}
