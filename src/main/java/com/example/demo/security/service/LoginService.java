package com.example.demo.security.service;

import com.example.demo.Dao.RoleDaoInter;
import com.example.demo.Dao.UserDaoInter;
import com.example.demo.models.domain.Role;
import com.example.demo.models.domain.User;
import com.example.demo.models.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LoginService {

    private UserDaoInter userInterface;
    private RoleDaoInter roleInterface;

    @Autowired
    public void setUserDaoInter(UserDaoInter userDaoInter) {
        this.userInterface = userDaoInter;
    }
    @Autowired
    public void setRoleDaoInter(RoleDaoInter roleInterface) {
        this.roleInterface = roleInterface;
    }

    public List<Role> getUserRole (String username) {
        // find user by id
        User userInfo = userInterface.findByUserName(username);
        if (userInfo == null) {
            // user name doesn't exist
            return null;
        }
        List<UserRole> userRoleList = roleInterface.findUserRoleByUserId(userInfo.getId());

        List<Role> result = new ArrayList<>();
        for (UserRole l: userRoleList) {
            Role userRole  = roleInterface.findRoleByRoleId(l.getRoleId().getId());
            result.add(userRole);
        }
        return result;
    }

    public User getUserByUsername (String username) {
        User userInfo = userInterface.findByUserName(username);
        return userInfo;
    }

}
