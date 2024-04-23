package com.reusehive.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.reusehive.utils.MinioUtils;
import com.reusehive.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 对象存储接口
 */
@RestController
@Slf4j
public class OSSController {
    @Resource
    private MinioUtils minioUtils;

    /**
     * 上传用户头像
     */
    @PostMapping("/oss/upload/user_icon")
    public Result<String> uploadIcon(MultipartFile icon) {
        try {
            var url = minioUtils.UploadUserIcon(icon);
            return Result.ok(url);
        } catch (Exception e) {
            var msg = "上传头像失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }


    /**
     * 上传物品背景图
     */
    @SaIgnore
    @PostMapping("/oss/upload/item_back")
    public Result<String> uploadItemBack(MultipartFile item_back) {
        try {
            var url = minioUtils.UploadItemBackImg(item_back);
            return Result.ok(url);
        } catch (Exception e) {
            var msg = "上传物品背景图失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 上传用户背景图
     */
    @PostMapping("/oss/upload/user_back")
    public Result<String> uploadUserBack(MultipartFile user_back) {
        try {
            var url = minioUtils.UploadUserBackImg(user_back);
            return Result.ok(url);
        } catch (Exception e) {
            var msg = "上传用户背景图失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }
}
