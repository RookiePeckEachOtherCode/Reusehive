package com.reusehive.mapper;

import com.mybatisflex.core.BaseMapper;
import com.reusehive.entity.database.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("select id from user where name = #{name}")
    User getUserIdByName(String name);
}

