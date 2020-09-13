package com.example.demo.security.service;

import com.example.demo.Dao.PermissionDaoInter;
import com.example.demo.Dao.RoleDaoInter;
import com.example.demo.Dao.UserDaoInter;
import com.example.demo.Exception.ExistInDBException;
import com.example.demo.models.domain.PermissioinDomain;
import com.example.demo.models.domain.RolePermission;
import com.example.demo.models.domain.User;
import com.example.demo.models.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterService {

    private PermissionDaoInter permissionDaoInter;
    private RoleDaoInter roleDaoInter;
    private UserDaoInter userDaoInter;

    @Autowired
    public void setPermissionDaoInter (PermissionDaoInter permissionDaoInter) {
        this.permissionDaoInter = permissionDaoInter;
    }

    @Autowired
    public void setRoleDaoInter (RoleDaoInter roleDaoInter) {
        this.roleDaoInter = roleDaoInter;
    }

    @Autowired
    public void setUserDaoInter (UserDaoInter userDaoInter) {
        this.userDaoInter = userDaoInter;
    }

    // add user, role, permission, user role, role permissioin
    public void addUer (User user, UserRole userRole) throws ExistInDBException {
        this.userDaoInter.addUser(user);
    }

    public void addUserRole (UserRole userRole) {
        this.roleDaoInter.addUserRole(userRole);
    }

    public void addPermission (PermissioinDomain permissioinDomain) {
        this.permissionDaoInter.addPermission(permissioinDomain);
    }

    public void addRolePermissioin (RolePermission rolePermission) {
        this.permissionDaoInter.addRolePermission(rolePermission);
    }

}
