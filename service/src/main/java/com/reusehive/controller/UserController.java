package com.reusehive.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户接口
 */
@RestController
@Slf4j
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private MinioUtils minioUtils;

    /**
     * 用户注册
     */
    @PostMapping("/user/register")
    //返回token
    public Result<String> register(
            String name,
            String password,
            String gender,
            String grade,
            String academy,
            String phone_number,
            String social_info,
            MultipartFile avatar_img,
            MultipartFile back_img
    ) {
        try {
            var avatar_img_url = minioUtils.UploadUserIcon(avatar_img);
            var back_img_url = minioUtils.UploadUserBackImg(back_img);

            var user = new User(null, name, gender, grade, academy, phone_number, social_info, avatar_img_url, back_img_url);
            var userPassword = new UserPassword(null, password);
            var uid = userService.register(user, userPassword).getId();
            StpUtil.login(uid);
            SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
            return Result.ok(saTokenInfo.tokenValue);
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
    public Result<String> login(String name, String password) {
        System.out.println("username: " + name);
        System.out.println("password: " + password);


        try {
            var uid = userService.login(name, password).getId();
            StpUtil.login(uid);
            SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
            return Result.ok(saTokenInfo.tokenValue);
        } catch (RuntimeException e) {
            var msg = "登陆失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 退出登陆
     */
    @GetMapping("/user/logout")
    public Result<None> logout() {
        StpUtil.logout();
        return Result.ok();
    }

    /**
     * 根据id获取用户信息
     */
    @GetMapping("/user/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        try {
            var user = userService.getUserById(id);
            return Result.ok(user);
        } catch (Exception e) {
            var msg = "获取用户信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 获取当前用户信息
     */
    @GetMapping("/me")
    public Result<User> getUserMe() {
        try {
            var uid = StpUtil.getLoginIdAsLong();
            var user = userService.getUserById(uid);
            return Result.ok(user);
        } catch (Exception e) {
            var msg = "获取用户信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }


    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/user/name/{name}")
    public Result<User> getUserByName(@PathVariable String name) {
        try {
            System.out.println(name);
            var user = userService.getUserByName(name);
            return Result.ok(user);
        } catch (Exception e) {
            var msg = "获取用户信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/user/update")
    public Result<None> updateUser(
            String name,
            String gender,
            String grade,
            String academy,
            String phone_number,
            String social_info,
            @RequestPart(required = false) MultipartFile avatar_img,
            @RequestPart(required = false) MultipartFile back_img
    ) {
        try {
            String avatar_img_url = null;
            String back_img_url = null;
            if (avatar_img != null) {
                avatar_img_url = minioUtils.UploadUserIcon(avatar_img);
            }
            if (back_img != null) {
                back_img_url = minioUtils.UploadUserBackImg(back_img);
            }

            var id = StpUtil.getLoginIdAsLong();
            var user = new User(id, name, gender, grade, academy, phone_number, social_info, avatar_img_url, back_img_url);

            userService.updateUser(user);
            return Result.ok();
        } catch (Exception e) {
            var msg = "修改用户信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 获取用户信息及其物品列表
     */
    @GetMapping("/user-items/{id}")
    public Result<UserItemsInfo> getUserItemsInfo(@PathVariable Long id) {
        try {
            var userItemInfo = userService.getUserItemsInfo(id);
            return Result.ok(userItemInfo);
        } catch (Exception e) {
            var msg = "获取用户信息及其物品列表失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 获取用户聊天对象
     */
    @GetMapping("/user/chatsinfo")
    public Result<List<User>> getUserChatsInfo() {
        var uid = StpUtil.getLoginIdAsLong();
        try {
            List<User> userChatInfo = userService.getUserChatInfo(uid);
            return Result.ok(userChatInfo);
        } catch (Exception e) {
            var msg = "获取用户信息聊天信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 验证token
     */
    @GetMapping("/user/verify")
    public Result<Boolean> VerifyToken() {
        return Result.ok(StpUtil.isLogin());
    }
}
