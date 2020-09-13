package com.example.demo.Dao;

import com.example.demo.models.domain.Role;
import com.example.demo.models.domain.UserRole;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.*;

@Repository("RoleDaoInter")
public class RoleDaoImple extends AbstractHibernateDAO implements RoleDaoInter{

    //constructor
    public RoleDaoImple () {
        setClazz(Role.class);
    }

    @Override
    public List<UserRole> findUserRoleByUserId(int userId) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserRole> cr = cb.createQuery(UserRole.class);

        // create query
        Root<UserRole> root = cr.from(UserRole.class);
        // using where clause
        Predicate predicate = root.get("userId").in(Arrays.asList(userId));
        cr.select(root).where(predicate);

        List<UserRole> result = session.createQuery(cr).getResultList();
        return result;
    }

    @Override
    public Role findRoleByRoleId(int roleId) {
        return (Role) findById(roleId);

    }

    @Override
    public void addRole(Role role)  {
        Transaction transaction = getCurrentSession().beginTransaction();

        try {
            store(role);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Failed to add role to db");
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void addUserRole(UserRole userRole) {
        Transaction transaction = getCurrentSession().beginTransaction();

        try {
            store(userRole);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("User id or role id dosen't exist in user table or role table");
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }


}
