package com.reusehive.service.impl;

import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.User;
import com.reusehive.entity.database.UserPassword;
import com.reusehive.mapper.UserMapper;
import com.reusehive.mapper.UserPasswordMapper;
import com.reusehive.service.UserService;
import com.reusehive.utils.PasswordUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserPasswordMapper userPasswordMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Long register(User user, UserPassword userPassword) {
        userMapper.insert(user);
        userPassword.setUid(user.getId());

        var hashPassword = PasswordUtils.encrypt(userPassword.getPassword());
        userPassword.setPassword(hashPassword);

        userPasswordMapper.insert(userPassword);
        return user.getId();
    }

    @Override
    public Long login(String name, String password) {
        var uid = userMapper.getUserByName(name).getId();

        var userPassword = userPasswordMapper.selectOneById(uid);

        if (!PasswordUtils.check(password, userPassword.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return uid;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectOneById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public void updateUser(User user, UserPassword userPassword) {
        userMapper.update(user);

        var hashPassword = PasswordUtils.encrypt(userPassword.getPassword());
        userPassword.setPassword(hashPassword);

        userPasswordMapper.update(userPassword);
    }

    @Override
    public void deleteUser(Long id) {
        var user = new User();
        user.setId(id);

        var userPassword = new UserPassword();
        userPassword.setUid(id);

        userPasswordMapper.delete(userPassword);
        userMapper.delete(user);
    }

    @Override
    public UserItemsInfo getUserItemsInfo(Long id) {
        var user = userMapper.selectOneById(id);
        return null;
    }
}
