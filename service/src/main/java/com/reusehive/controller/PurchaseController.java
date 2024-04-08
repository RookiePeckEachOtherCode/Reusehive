package com.reusehive.controller;

import com.reusehive.entity.None;
import com.reusehive.entity.UserPurchaseInfo;
import com.reusehive.entity.database.PurchaseInfo;
import com.reusehive.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 交易接口
 */
@RestController
public class PurchaseController {
    /**
     * 建立交易
     */
    @PostMapping("/purchase/new")
    public Result<None> newPurchase(@RequestParam("uid") Long uid, @RequestParam("item_id") Long ItemId) {
        return Result.ok();
    }

    /**
     * 结束交易
     */
    @PostMapping("/purchase/end")
    public Result<None> endPurchase(@RequestParam("item_id") Long ItemId) {
        return Result.ok();
    }

    /**
     * 取消交易
     */
    @PostMapping("/purchase/cancel")
    public Result<None> cancelPurchase(@RequestParam("item_id") Long ItemId,@RequestParam("uid") Long uid){return  Result.ok();}

    /**
     * 获取用户交易列表
     */
    @GetMapping("/purchase/user/{uid}")
    public Result<UserPurchaseInfo> getPurchaseByUserId(@PathVariable Long uid) {
        return Result.ok();
    }

    /**
     * 根据id获取交易信息
     */

    @GetMapping("/purchase/{id}")
    public Result<PurchaseInfo> getPurchaseById(@PathVariable Long id) {
        return Result.ok();
    }

    /**
     *下架物品
     */

    @PostMapping("/purchase/remove")
    public Result<None> removeItem(@RequestParam("item_id") Long ItemId){

        return Result.ok();
    }
}
