package com.example.demo.controller;

import com.example.demo.Exception.ExistInDBException;
import com.example.demo.models.domain.Role;
import com.example.demo.models.common.ServiceStatus;
import com.example.demo.models.domain.RolePermission;
import com.example.demo.models.domain.User;
import com.example.demo.models.domain.PermissioinDomain;
import com.example.demo.models.domain.UserRole;
import com.example.demo.models.request.LoginRequest;
import com.example.demo.models.request.RegisterRequest;
import com.example.demo.models.response.LoginResponse;
import com.example.demo.models.response.RegisterResponse;
import com.example.demo.security.jwt.CookieUtil;
import com.example.demo.security.jwt.JwtUtil;
import com.example.demo.security.service.LoginService;
import com.example.demo.security.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class AuthController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    private LoginService loginService;
    private RegisterService registerService;

    @Autowired
    public void setLoginService(LoginService loginService){
        this.loginService = loginService;
    }

    @Autowired
    public void setRegisterService(RegisterService registerService){
        this.registerService = registerService;
    }

    @RequestMapping("/register")
    public String register() {
        return "Register Page";
    }

    @PostMapping("/register")
    public RegisterResponse register (HttpServletResponse httpServletResponse,@RequestBody RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        // put in db
        // redirect to login page
        // user info
        String userName = request.getUserName();
        String userEmail = request.getUserEmail();
        String password = request.getPassword();
        String personId = request.getPersonId();

        int roleId = request.getRoleId();
        String roleDescription = request.getRoleDescription();

        int permissionId = request.getPermissionId();

        // add user
        User user = new User();
        user.setEmail(userEmail);
        user.setPassword(password);
        user.setUserName(userName);
        user.setPersonId(Integer.parseInt(personId));
        try {
            System.out.println("read to add user in controller");
            registerService.addUser(user);
        } catch(ExistInDBException e) {
            prepareRegisterResponse(response, false, "User name , User email or User Personal Id exist in database");
            return response;
        }

        // find role given role Id
        Role role = registerService.findRoleById(roleId);

       // add user_role
        UserRole userRole = new UserRole();
        userRole.setRoleId(role);
        userRole.setUserId(user);
        System.out.println("before adding User Role function");
        registerService.addUserRole(userRole);
        
        prepareRegisterResponse(response, true, "");
        response.setUsername(userName);
        return response;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public LoginResponse login(HttpServletResponse httpServletResponse,@RequestBody LoginRequest request){
        LoginResponse response = new LoginResponse();
        String username = request.getUsername();
        String password = request.getPassword();

        User userinfo = loginService.getUserByUsername(username);

        if (userinfo == null || !userinfo.getUserName().equals(username) || !userinfo.getPassword().equals(password)){
            prepareResponse(response, false, "Invalid User name or password!");
            return response;
        }

        String token = JwtUtil.generateToken(signingKey, username);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        // get user id and find the role of user
        List<Role> userRole = loginService.getUserRole(username);

        // send userid, username, userpassword, userrole to json format
        List<String> roleNameList = new ArrayList<>();
        List<Integer> roleIdList = new ArrayList<>();
        for (Role role: userRole) {
            roleNameList.add(role.getRoleName());
            roleIdList.add(role.getId());
        }

        // set response
        response.setRoleIdList(roleIdList);
        response.setRoleNameList(roleNameList);
        response.setUsername(username);
        prepareResponse(response, true, "");
        response.setJwtInfo(token);

        return response;
    }

    private void prepareResponse(LoginResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }

    private void prepareRegisterResponse(RegisterResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }

}
