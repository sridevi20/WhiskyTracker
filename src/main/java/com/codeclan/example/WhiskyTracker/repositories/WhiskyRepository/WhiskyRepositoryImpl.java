package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;
    @JsonIgnoreProperties

    @Transactional
    public List<Whisky> findWhiskiesInDistilleryThatHaveSpecificAge(int age){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Whisky.class);
        cr.createAlias("distillery","distilleryAlias");
        cr.add(Restrictions.eq("distilleryAlias.age",age));

         result = cr.list();
        return result;
    }

}


