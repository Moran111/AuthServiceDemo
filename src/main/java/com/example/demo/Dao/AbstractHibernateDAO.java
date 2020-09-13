package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractHibernateDAO<T extends Serializable> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T findById(final Integer id) {
        return getCurrentSession().get(clazz, id);
    }

    public void store (T clazz) {
        System.out.println("go to DAO Abstract store method");
        System.out.println("if currenct session is null or not " + getCurrentSession());
        getCurrentSession().persist(clazz);
    }
    
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
