package com.reusehive.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.reusehive.consts.MinioConst;
import com.reusehive.utils.MinioUtils;
import com.reusehive.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
            var uid = StpUtil.getLoginIdAsString();
            var url = minioUtils.UploadUserIcon(icon, uid);
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
    @PostMapping("/oss/upload/item_back")
    public Result<String> uploadItemBack(MultipartFile itemBack) {
        try {
            var uid = StpUtil.getLoginIdAsString();
            var url = minioUtils.UploadItemBackImg(itemBack, uid);
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
    public Result<String> uploadUserBack(MultipartFile userBack) {
        try {
            var uid = StpUtil.getLoginIdAsString();
            var url = minioUtils.UploadUserBackImg(userBack, uid);
            return Result.ok(url);
        } catch (Exception e) {
            var msg = "上传用户背景图失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 预览用户头像
     */
    @GetMapping("/oss/preview/user_icon")
    public Result<String> previewUserIcon(String uid) {
        try {
            return Result.ok(minioUtils.PreviewImg(uid, MinioConst.BUCKET_USER_ICON_IMG));
        } catch (Exception e) {
            var msg = "预览用户头像失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 预览物品背景图
     */
    @GetMapping("/oss/preview/item_back")
    public Result<String> previewItemBack(String uid) {
        try {
            return Result.ok(minioUtils.PreviewImg(uid, MinioConst.BUCKET_ITEM_BACK_IMG));
        } catch (Exception e) {
            var msg = "预览物品背景图失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 预览用户背景图
     */
    @GetMapping("/oss/preview/user_back")
    public Result<String> previewUserBack(String uid) {
        try {
            return Result.ok(minioUtils.PreviewImg(uid, MinioConst.BUCKET_USER_BACK_IMG));
        } catch (Exception e) {
            var msg = "预览用户背景图失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }
}
