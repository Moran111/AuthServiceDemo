package com.example.demo.Dao;

import com.example.demo.models.domain.PermissioinDomain;
import com.example.demo.models.domain.RolePermission;
import com.example.demo.models.domain.User;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository("PermissionDaoInter")
public class PermissionDaoImple extends AbstractHibernateDAO implements PermissionDaoInter{

    public PermissionDaoImple () {
        setClazz(PermissioinDomain.class);
    }

    @Override
    public PermissioinDomain findPermissionByRoleId(int roleId) {

        return null;
    }

    @Override
    public void addPermission(PermissioinDomain permission) {

        Transaction transaction = getCurrentSession().beginTransaction();

        try {
            store(permission);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Failed to add role to db");
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public void addRolePermission(RolePermission rolePermission) {

        Transaction transaction = getCurrentSession().beginTransaction();

        try {
            store(rolePermission);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Failed to add role to db");
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }
}
