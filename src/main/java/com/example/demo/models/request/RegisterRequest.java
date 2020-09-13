package com.example.demo.models.request;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
public class RegisterRequest {

    // user info
    String userName;
    String userEmail;
    String password;
    String personId;

    // user role info
    int roleId;
    String roleDescription;

    // role and permission already exist in db

    // role permission
    int permissionId = 2;

    public RegisterRequest() {
        this.roleId = 2;
        this.roleDescription = "normal";
        this.permissionId = 2;
    }
}
