package com.reusehive.controller;

import com.reusehive.entity.None;
import com.reusehive.entity.database.Item;
import com.reusehive.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 物品接口
 */
@RestController
public class ItemController {
    /**
     * 新建物品
     */
    @PostMapping("/item/new")
    public Result<Item> newItem(
            Long uid,
            Long name,
            Long description,
            Double prices
    ) {
        return Result.ok();
    }

    /**
     * 根据id获取物品信息
     */
    @GetMapping("/item/{id}")
    public Result<Item> getItemById(@PathVariable Long id) {
        return Result.ok();
    }

    /**
     * 获取所有物品列表
     */
    @GetMapping("/item/all")
    public Result<List<Item>> getAllItem() {
        return Result.ok();
    }

    /**
     * 更新物品信息
     */
    @PostMapping("/item/update")
    public Result<None> updateItem(
            Long name,
            Long description,
            Double prices
    ) {
        return Result.ok();
    }

    /**
     * 删除物品
     */
    @PostMapping("/item/delete")
    public Result<None> deleteItem(Long id) {
        return Result.ok();
    }

}
