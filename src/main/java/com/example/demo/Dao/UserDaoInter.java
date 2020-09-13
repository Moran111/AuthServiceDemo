package com.example.demo.Dao;

import com.example.demo.models.User;

public interface UserDao {

    // return all information of user given username
    public User findByUserName(String username);

    // check if username exist
    public boolean existByUserName (String username);

}
