package com.example.demo.Dao;

import com.example.demo.Exception.ExistInDBException;
import com.example.demo.models.domain.User;
import com.example.demo.models.response.LoginResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

@Repository("UserDaoInter")
public class UserDaoImple extends AbstractHibernateDAO implements UserDaoInter{

    //constructor
    public UserDaoImple () {
        setClazz(User.class);
    }

    @Override
    public User findByUserName(String username) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);

        // create query
        Root<User> root = cr.from(User.class);
        // using where clause
        Predicate predicate = root.get("userName").in(Arrays.asList(username));
        cr.select(root).where(predicate);

        User result = session.createQuery(cr).getSingleResult();

        return result;
    }

    @Override
    public User findByUserId(int userId) {
        return (User)findById(userId);
    }

    @Override
    public void addUser(User user) throws ExistInDBException {

        Transaction transaction = getCurrentSession().beginTransaction();
        try {
            // if exist in database, throw exception
            // if not store in db and commit it
            store(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ExistInDBException("user name, user email or user personal id exist in db");
        }
    }


}
