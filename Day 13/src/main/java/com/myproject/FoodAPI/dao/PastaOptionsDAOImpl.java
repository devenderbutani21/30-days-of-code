package com.myproject.FoodAPI.dao;

import com.myproject.FoodAPI.entity.PastaOptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PastaOptionsDAOImpl implements PastaOptionsDAO {

    private EntityManager entityManager;

    @Autowired
    public PastaOptionsDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<PastaOptions> findAll() {
        TypedQuery<PastaOptions> theQuery = entityManager.createQuery("from PastaOptions", PastaOptions.class);

        List<PastaOptions> pastaOptions = theQuery.getResultList();

        return pastaOptions;
    }

    @Override
    public PastaOptions findById(int theId) {
        PastaOptions thePastaOption = entityManager.find(PastaOptions.class, theId);

        return thePastaOption;
    }

    @Override
    public PastaOptions save(PastaOptions pastaOptions) {
        PastaOptions thePastaOption = entityManager.merge(pastaOptions);

        return thePastaOption;
    }

    @Override
    public void deleteById(int theId) {
        PastaOptions thePastaOption = entityManager.find(PastaOptions.class, theId);
        entityManager.remove(thePastaOption);
    }
}
