package com.example.demo.Dao;

import com.example.demo.Exception.ExistInDBException;
import com.example.demo.models.domain.User;

public interface UserDaoInter {

    // return all information of user given username
    public User findByUserName(String username);

    // get user by useriD
    public User findByUserId (int userId);

    // check if username exist
    public boolean existByUserName (String userName, String input) throws ExistInDBException;

    // check if username email
    public boolean existByEmail (String email, String input);

    // check if username person id exist
    public boolean existByPersonId (String personId, int  input);

    public void addUser(User user) throws ExistInDBException;
}
