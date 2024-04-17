package com.reusehive.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.reusehive.consts.ItemStatus;
import com.reusehive.entity.ItemDetail;
import com.reusehive.entity.None;
import com.reusehive.entity.database.Item;
import com.reusehive.service.ItemService;
import com.reusehive.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 物品接口
 */
@RestController
@Slf4j
public class ItemController {
    @Resource
    private ItemService itemService;

    /**
     * 新建物品
     */
    @PostMapping("/item/new")
    public Result<Long> newItem(
            String name,
            String description,
            Double prices,
            String itemType
    ) {
        var uid = StpUtil.getLoginIdAsLong();
        var item = new Item(null, uid, name, description, prices, ItemStatus.UNDO, itemType);
        try {
            itemService.newItem(item);
            return Result.ok(item.getId());
        } catch (RuntimeException e) {
            var msg = "新建物品失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 根据id获取物品信息
     */
    @GetMapping("/item/{id}")
    public Result<ItemDetail> getItemById(@PathVariable Long id) {
        try {
            var itemDetail = itemService.getItemById(id);
            return Result.ok(itemDetail);
        } catch (RuntimeException e) {
            var msg = "获取物品信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 根据uid获取用户所有物品信息
     */
    @GetMapping("/item/user/{uid}")
    public Result<List<Item>> getItemByUid(@PathVariable Long uid) {
        try {
            var items = itemService.getItemByUid(uid);
            return Result.ok(items);
        } catch (RuntimeException e) {
            var msg = "获取用户物品信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }


    /**
     * 获取所有物品列表
     */
    @GetMapping("/item/all")
    public Result<List<ItemDetail>> getAllItem() {
        try {
            var itemDetails = itemService.getAllItem();
            return Result.ok(itemDetails);
        } catch (RuntimeException e) {
            var msg = "获取所有物品列表失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 更新物品信息
     */
    @PostMapping("/item/update")
    public Result<None> updateItem(
            Long id,
            String name,
            String description,
            Double prices,
            String type
    ) {
        var uid = StpUtil.getLoginIdAsLong();
        var item = new Item(id, null, name, description, prices, -1, type);

        try {
            itemService.updateItem(item, uid);
            return Result.ok();
        } catch (RuntimeException e) {
            var msg = "更新物品信息失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 删除物品
     */
    @PostMapping("/item/delete")
    public Result<None> deleteItem(Long id) {
        var uid = StpUtil.getLoginIdAsLong();
        try {
            itemService.deleteItem(id, uid);
            return Result.ok();
        } catch (RuntimeException e) {
            var msg = "删除物品失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 更新物品状态为未交易
     */
    @PostMapping("/item/update/status/undo")
    public Result<None> updateItemStatusUndo(Long id) {
        var uid = StpUtil.getLoginIdAsLong();
        try {
            itemService.updateItemStatus(id, uid, ItemStatus.UNDO);
            return Result.ok();
        } catch (RuntimeException e) {
            var msg = "更新物品状态为未交易失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 更新物品状态为交易中
     */
    @PostMapping("/item/update/status/trading")
    public Result<None> updateItemStatusTrading(Long id) {
        var uid = StpUtil.getLoginIdAsLong();
        try {
            itemService.updateItemStatus(id, uid, ItemStatus.TRADING);
            return Result.ok();
        } catch (RuntimeException e) {
            var msg = "更新物品状态为交易中失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 更新物品状态为已完成
     */
    @PostMapping("/item/update/status/done")
    public Result<None> updateItemStatusDone(Long id) {
        var uid = StpUtil.getLoginIdAsLong();
        try {
            itemService.updateItemStatus(id, uid, ItemStatus.DONE);
            return Result.ok();
        } catch (RuntimeException e) {
            var msg = "更新物品状态为已完成失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

    /**
     * 根据物品类型获取物品列表
     */
    @GetMapping("/item/type/{type}")
    public Result<List<Item>> getItemByType(@PathVariable String type) {
        try {
            var items = itemService.getItemByType(type);
            return Result.ok(items);
        } catch (RuntimeException e) {
            var msg = "获取物品列表失败: " + e.getMessage();
            log.error(msg);
            return Result.error(msg);
        }
    }

}
