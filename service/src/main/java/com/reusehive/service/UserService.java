package com.reusehive.service;

import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.User;
import com.reusehive.entity.database.UserPassword;

import java.util.List;

public interface UserService {

    User register(User user, UserPassword userPassword);

    User login(String name, String password);

    User getUserById(Long id);

    User getUserByName(String name);

    void updateUser(User user, UserPassword userPassword);

    UserItemsInfo getUserItemsInfo(Long id);

    List<User> getUserChatInfo(Long uid);

}
