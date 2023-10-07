package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.DesertOptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesertOptionsDAOImpl implements DesertOptionsDAO {
    private EntityManager entityManager;

    @Autowired
    public DesertOptionsDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<DesertOptions> findAll() {

        TypedQuery<DesertOptions> theQuery = entityManager.createQuery("from DesertOptions", DesertOptions.class);

        List<DesertOptions> desertOptions = theQuery.getResultList();

        return desertOptions;
    }

    @Override
    public DesertOptions findById(int theId) {
        DesertOptions theDesertOption = entityManager.find(DesertOptions.class, theId);

        return theDesertOption;
    }

    @Override
    public DesertOptions save(DesertOptions DesertOptions) {
        DesertOptions theDesertOption = entityManager.merge(DesertOptions);

        return theDesertOption;
    }

    @Override
    public void deleteById(int theId) {
        DesertOptions theDesertOption = entityManager.find(DesertOptions.class, theId);
        entityManager.remove(theDesertOption);
    }
}
