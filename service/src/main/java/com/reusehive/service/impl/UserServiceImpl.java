package com.reusehive.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.util.UpdateEntity;
import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.User;
import com.reusehive.entity.database.UserPassword;
import com.reusehive.entity.database.table.UserTableDef;
import com.reusehive.mapper.UserMapper;
import com.reusehive.mapper.UserPasswordMapper;
import com.reusehive.service.ItemService;
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
    @Resource
    private ItemService itemService;

    @Override
    public Long register(User user, UserPassword userPassword) {
        var dbUser = this.getUserByName(user.getName());
        if (dbUser != null) {
            throw new RuntimeException("用户名已存在");
        }


        userMapper.insert(user);
        userPassword.setUid(user.getId());

        var hashPassword = PasswordUtils.encrypt(userPassword.getPassword());
        userPassword.setPassword(hashPassword);

        userPasswordMapper.insert(userPassword);
        return user.getId();
    }

    @Override
    public Long login(String name, String password) {
        var uid = QueryChain.of(userMapper).select(UserTableDef.USER.ID)
                .where(UserTableDef.USER.NAME.eq(name))
                .one().getId();


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
        return QueryChain.of(userMapper).where(UserTableDef.USER.NAME.eq(name)).one();
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
    public UserItemsInfo getUserItemsInfo(Long id) {
        var user = this.getUserById(id);
        var items = itemService.getItemByUid(id);

        return new UserItemsInfo(user, items);
    }

    @Override
    public void uploadUserIcon(String url, Long id) {
        User user = UpdateEntity.of(User.class, id);
        user.setAvatar_img(null);
        user.setAvatar_img(url);
        userMapper.update(user);

    }
}
