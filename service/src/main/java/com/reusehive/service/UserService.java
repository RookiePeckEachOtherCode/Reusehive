package com.reusehive.service;

import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.User;
import com.reusehive.entity.database.UserPassword;

import java.util.List;

public interface UserService {
    Long register(User user, UserPassword userPassword);

    Long login(String name, String password);

    User getUserById(Long id);

    User getUserByName(String name);

    List<User> getAllUser();

    void updateUser(User user, UserPassword userPassword);

    void deleteUser(Long id);


    UserItemsInfo getUserItemsInfo(Long id);

}
