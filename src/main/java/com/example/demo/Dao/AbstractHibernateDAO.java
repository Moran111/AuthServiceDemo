package com.example.demo.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Arrays;

public abstract class AbstractHibernateDAO<T extends Serializable> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T findById(final Integer id) {
        System.out.println("go to DAO Abstract findById method");
        return getCurrentSession().get(clazz, id);
    }

    public void store (T clazz) {
        System.out.println("go to DAO Abstract store method");
        getCurrentSession().save(clazz);
    }


    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
