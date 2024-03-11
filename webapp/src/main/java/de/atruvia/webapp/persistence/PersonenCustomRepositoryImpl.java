package de.atruvia.webapp.persistence;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonenCustomRepositoryImpl implements PersonenCustomRepository{


    @Autowired
    private EntityManager em;
    @Override
    @Transactional
    public void speichern(final PersonEntity p) {
        em.persist(p);
    }
}
