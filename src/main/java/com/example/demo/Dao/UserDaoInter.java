package com.example.demo.Dao;

import com.example.demo.Exception.ExistInDBException;
import com.example.demo.models.domain.User;

public interface UserDaoInter {

    // return all information of user given username
    public User findByUserName(String username);

    // get user by useriD
    public User findByUserId (int userId);


    public void addUser(User user) throws ExistInDBException;

}
