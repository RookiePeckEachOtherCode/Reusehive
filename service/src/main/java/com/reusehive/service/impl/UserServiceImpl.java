package com.reusehive.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.reusehive.consts.CacheKey;
import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.Message;
import com.reusehive.entity.database.User;
import com.reusehive.entity.database.UserPassword;
import com.reusehive.entity.database.table.MessageTableDef;
import com.reusehive.entity.database.table.UserTableDef;
import com.reusehive.mapper.MessageMapper;
import com.reusehive.mapper.UserMapper;
import com.reusehive.mapper.UserPasswordMapper;
import com.reusehive.service.ItemService;
import com.reusehive.service.UserService;
import com.reusehive.utils.PasswordUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    MessageMapper messageMapper;
    @Resource
    private UserPasswordMapper userPasswordMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ItemService itemService;

    @Override
    public User register(User user, UserPassword userPassword) {
        var dbUser = this.getUserByName(user.getName());
        if (dbUser != null) {
            throw new RuntimeException("用户名已存在");
        }


        userMapper.insert(user);
        userPassword.setUid(user.getId());

        var hashPassword = PasswordUtils.encrypt(userPassword.getPassword());
        userPassword.setPassword(hashPassword);

        userPasswordMapper.insert(userPassword);
        return user;
    }

    @Override
//    @Caching(
//            put = {
//                    @CachePut(cacheNames = CacheKey.USER_NAME, key = "#name"),
//                    @CachePut(cacheNames = CacheKey.USER_ID, key = "#result.id")
//            }
//    )
    public User login(String name, String password) {
        var user = QueryChain.of(userMapper).select(UserTableDef.USER.ID)
                .where(UserTableDef.USER.NAME.eq(name))
                .one();

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        var userPassword = userPasswordMapper.selectOneById(user.getId());

        if (!PasswordUtils.check(password, userPassword.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    @Cacheable(cacheNames = CacheKey.USER_ID, key = "#id")
    public User getUserById(Long id) {
        return userMapper.selectOneById(id);
    }

    @Override
    @Cacheable(cacheNames = CacheKey.USER_NAME, key = "#name")
    public User getUserByName(String name) {
        return QueryChain.of(userMapper).where(UserTableDef.USER.NAME.eq(name)).one();
    }


    @Override
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = CacheKey.USER_NAME, key = "#user.name"),
                    @CacheEvict(cacheNames = CacheKey.USER_ID, key = "#user.id"),
            }
    )
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
    public List<User> getUserChatInfo(Long uid) {
        List<User> userList = new ArrayList<>();
        User user = getUserById(uid);
        List<Message> messages = QueryChain.of(messageMapper)
                .where(MessageTableDef.MESSAGE.FROMUSERNAME.eq(user.getName()))
                .list();
        Set<String> tousernameSet = new HashSet<>();
        for (Message message : messages) {
            User user1 = getUserByName(message.getTousername());
            if (!tousernameSet.contains(message.getTousername())) {
                userList.add(user1);
                tousernameSet.add(message.getTousername());
            }
        }

        return userList;
    }
}
