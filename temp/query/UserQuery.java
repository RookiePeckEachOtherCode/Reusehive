package com.reusehive.query;

import com.reusehive.mapper.UserMapper;
import com.reusehive.mapper.UserPasswordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserQuery {
    @Resource
    public UserMapper userMapper;
    @Resource
    public UserPasswordMapper userPasswordMapper;
}
