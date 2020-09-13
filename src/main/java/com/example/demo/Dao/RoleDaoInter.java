package com.example.demo.Dao;

import com.example.demo.models.domain.Role;
import com.example.demo.models.domain.UserRole;

import java.util.*;

public interface RoleDaoInter {

    // given the user name or user id, return role
    public List<UserRole> findUserRoleByUserId (int userId);

    // find the use role given role id
    public Role findRoleByRoleId (int roleId);

    public void addRole (Role role);

    public void addUserRole (UserRole userRole);
}
