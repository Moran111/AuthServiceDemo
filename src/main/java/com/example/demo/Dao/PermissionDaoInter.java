package com.example.demo.Dao;

import com.example.demo.models.domain.PermissioinDomain;
import com.example.demo.models.domain.RolePermission;

public interface PermissionDaoInter {

    // given the role id, find the permission of that role
    public PermissioinDomain findPermissionByRoleId (int roleId);

    public void addPermission (PermissioinDomain permission);

    public void addRolePermission (RolePermission rolePermission);
}
