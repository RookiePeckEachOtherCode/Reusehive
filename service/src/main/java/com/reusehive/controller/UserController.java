package com.reusehive.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.reusehive.entity.None;
import com.reusehive.entity.UserItemsInfo;
import com.reusehive.entity.database.User;
import com.reusehive.entity.database.UserPassword;
import com.reusehive.service.UserService;
import com.reusehive.utils.MinioUtils;
import com.reusehive.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户接口
 */
@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private MinioUtils minioUtils;
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
            String social_info,
            String avatar_img,
            String back_img
    ) {
        var user = new User(null, name, gender, grade, academy, phone_number, social_info, avatar_img, back_img);
        var userPassword = new UserPassword(null, password);
        try {
            var uid = userService.register(user, userPassword);
            return Result.ok(uid);
        } catch (Exception e) {
            var msg = "注册失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 用户登陆
     */
    @PostMapping("/user/login")
    //返回uid
    public Result<Long> login(String name, String password) {
        try {
            var uid = userService.login(name, password);
            StpUtil.login(uid);
            return Result.ok(uid);
        } catch (RuntimeException e) {
            var msg = "登陆失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 根据id获取用户信息
     */
    @GetMapping("/user/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        var user = userService.getUserById(id);
        return Result.ok(user);
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

    @PostMapping("/user/{id}/upload")
    public Result<String> UploadIcon(MultipartFile file,@PathVariable Long id){
        String url = minioUtils.UploadUserIcon(file, id.toString());
        userService.uploadUserIcon(url,id);
        return Result.ok(url);
    }


}
