package com.reusehive.controller;

import com.reusehive.entity.None;
import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.User;
import com.reusehive.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户接口
 */
@RestController
public class UserController {
    /**
     * 用户注册
     */
    @PostMapping("/user/register")
    //返回uid
    public Result<Long> register(
            String name,
            String password,
            String gender,
            String grade,
            String academy,
            String phone_number,
            String social_info
    ) {
        return Result.ok();
    }

    /**
     * 用户登陆
     */
    @PostMapping("/user/login")
    //返回uid
    public Result<Long> login(String name, String password) {
        return Result.ok();
    }

    /**
     * 根据id获取用户信息
     */
    @GetMapping("/user/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        return Result.ok();
    }

    /**
     * 获取所有用户信息
     */
    @GetMapping("/user/all")
    public Result<List<User>> getAllUser() {
        return Result.ok();
    }

    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/user/name/{name}")
    public Result<User> getUserByName(@PathVariable String name) {
        return Result.ok();
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/user/update")
    public Result<None> updateUser(
            String name,
            String password,
            String gender,
            String grade,
            String academy,
            String phone_number,
            String social_info
    ) {
        return Result.ok();
    }

    /**
     * 删除用户
     */
    @PostMapping("/user/delete")
    public Result<None> deleteUser(Long id) {
        return Result.ok();
    }

    /**
     * 获取用户信息及其物品列表
     */
    @GetMapping("/user/{id}/items")
    public Result<UserItemsInfo> getUserItemsInfo(@PathVariable Long id) {
        return Result.ok();
    }
}
