package com.reusehive.mapper;

import com.mybatisflex.core.BaseMapper;
import com.reusehive.entity.database.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT id FROM user WHERE name =#{name}")
    Long getUserIdByName(String name);

}

