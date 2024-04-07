package com.reusehive.entity;

import com.reusehive.entity.database.Item;
import com.reusehive.entity.database.User;

import java.util.List;

// 用户及其所有物品信息
public class UserItemsInfo {
    private User user;
    private List<Item> items;
}
