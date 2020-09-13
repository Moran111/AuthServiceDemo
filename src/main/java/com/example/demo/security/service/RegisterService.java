package com.example.demo.security.service;

import com.example.demo.Dao.PermissionDaoInter;
import com.example.demo.Dao.RoleDaoInter;
import com.example.demo.Dao.UserDaoInter;
import com.example.demo.Exception.ExistInDBException;
import com.example.demo.models.domain.*;
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
    public void addUser (User user) throws ExistInDBException {
        System.out.println("access register service addUser function");
        this.userDaoInter.addUser(user);
    }

    public void addUserRole (UserRole userRole) {
        System.out.println("adding User Role in register service");
        this.roleDaoInter.addUserRole(userRole);
    }

    public void addPermission (PermissioinDomain permissioinDomain) {
        this.permissionDaoInter.addPermission(permissioinDomain);
    }

    public void addRolePermissioin (RolePermission rolePermission) {
        this.permissionDaoInter.addRolePermission(rolePermission);
    }

    public Role findRoleById (int roleId) {
        return roleDaoInter.findRoleByRoleId(roleId);
    }

    public PermissioinDomain findPermissionById (int permissionId) {
        return permissionDaoInter.findPermissionById(permissionId);
    }

}
