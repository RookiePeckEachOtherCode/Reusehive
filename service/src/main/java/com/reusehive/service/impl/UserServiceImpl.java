package com.reusehive.service.impl;

import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.User;
import com.reusehive.entity.database.UserPassword;
import com.reusehive.mapper.UserMapper;
import com.reusehive.mapper.UserPasswordMapper;
import com.reusehive.service.UserService;
import com.reusehive.utils.PasswordUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserPasswordMapper userPasswordMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Long register(User user, UserPassword userPassword) {
        userMapper.insert(user);
        userPassword.setId(user.getId());
        userPasswordMapper.insert(userPassword);
        return user.getId();
    }

    @Override
    public Long login(String name, String password) {
        var uid = userMapper.getUserIdByName(name);

        if (uid == null) {
            throw new RuntimeException("用户不存在");
        }

        var userPassword = userPasswordMapper.selectOneById(uid);

        if (!PasswordUtils.check(password, userPassword.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return uid;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserItemsInfo getUserItemsInfo(Long id) {
        return null;
    }
}
