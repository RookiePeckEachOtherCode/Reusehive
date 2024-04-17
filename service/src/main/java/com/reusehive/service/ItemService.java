package com.reusehive.service;

import com.reusehive.entity.ItemDetail;
import com.reusehive.entity.database.Item;

import java.util.List;

public interface ItemService {
    void newItem(Item item);

    ItemDetail getItemById(Long id);

    List<Item> getItemByUid(Long uid);

    List<ItemDetail> getAllItem();

    void updateItem(Item item, Long uid);

    void deleteItem(Long id, Long uid);

    void updateItemStatus(Long id, long uid, int status);

    List<Item> getItemByType(String type);

    List<String> getItemImage(Long id);

    void addItemImage(Long id, List<String> imageUrl);
}
