package com.reusehive.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.reusehive.entity.None;
import com.reusehive.entity.UserPurchaseInfo;
import com.reusehive.entity.database.PurchaseInfo;
import com.reusehive.service.impl.PurchaseServiceImpl;
import com.reusehive.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 交易接口
 */
@RestController
@Slf4j
public class PurchaseController {

    @Resource
    PurchaseServiceImpl purchaseService;
    /**
     * 建立交易
     */
    @PostMapping("/purchase/new")
    public Result<None> newPurchase( @RequestParam("item_id") Long ItemId,@RequestParam("price") Double price) {
        var uid = StpUtil.getLoginIdAsLong();
        try {
            purchaseService.CreatePurchase(uid, ItemId, price);
            return Result.ok();
        }catch (Exception e){
            var msg = "建立交易失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);

        }
    }

    /**
     * 结束交易
     */
    @PostMapping("/purchase/end")
    public Result<None> endPurchase(@RequestParam("purchase_id") Long purchase_id) {
        try {
            purchaseService.PurchaseComplete(purchase_id);
            return Result.ok();
        }catch (Exception e){
            var msg = "确认交易失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 取消交易
     */
    @PostMapping("/purchase/cancel")
    public Result<None> cancelPurchase(@RequestParam("purchase_id") Long purchase_id){
        try {
            purchaseService.CanclePurchase(purchase_id);
            return Result.ok();
        }catch (Exception e){
            var msg = "取消交易失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 获取用户交易列表
     */
    @GetMapping("/purchase/user/list")
    public Result<List<PurchaseInfo>> getPurchaseByUserId() {
        var uid = StpUtil.getLoginIdAsLong();
        try {
            List<PurchaseInfo> purchaseInfos = purchaseService.GetUserPurchaseList(uid);
            return Result.ok(purchaseInfos);
        }catch (Exception e){
            var msg = "获取交易列表失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 根据id获取交易信息
     */

    @GetMapping("/purchase/{purchase_id}")
    public Result<PurchaseInfo> getPurchaseById(@PathVariable Long purchase_id) {
        try {
            PurchaseInfo purchaseInfo = purchaseService.GetPurchaseInfoById(purchase_id);
            return Result.ok(purchaseInfo);
        }catch (Exception e){
            var msg = "获取交易信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     *下架物品
     */

    @PostMapping("/purchase/remove")
    public Result<None> removeItem(@RequestParam("item_id") Long item_id){
        try {
            purchaseService.RemoveItem(item_id);
            return Result.ok();
        }catch (Exception e){
            var msg = "下架物品失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }
}
