package com.reusehive.entity;

import com.reusehive.entity.database.Item;
import com.reusehive.entity.database.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 用户及其所有物品信息
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserItemsInfo {
    private User user;
    private List<Item> items;
}
