package com.reusehive.service;

import com.reusehive.entity.database.Item;

import java.util.List;

public interface ItemService {
    void newItem(Item item);

    Item getItemById(Long id);

    List<Item> getItemByUid(Long uid);

    List<Item> getAllItem();

    void updateItem(Item item, Long uid);

    void deleteItem(Long id, Long uid);

    void updateItemStatus(Long id, long uid, int type);
}
