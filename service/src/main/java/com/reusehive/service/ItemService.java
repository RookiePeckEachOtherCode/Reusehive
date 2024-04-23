package com.reusehive.service;

import com.reusehive.entity.ItemDetail;
import com.reusehive.entity.database.Item;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {
    void newItem(Item item, MultipartFile[] images);

    ItemDetail getItemById(Long id);

    List<ItemDetail> getItemByUid(Long uid);

    List<ItemDetail> getAllItem();

    void updateItem(Item item, Long uid);

    void deleteItem(Long id, Long uid);

    void updateItemStatus(Long id, long uid, int status);

    List<Item> getItemByType(String type);

    List<String> getItemImage(Long id);

    List<ItemDetail> getCollectionItems(Long uid);

    Boolean addCollectionItem(Long uid, Long item_id);

    Boolean isCollected(Long uid, Long item_id);

    Boolean deleteItemFromCollections(Long uid, Long item_id);

    List<ItemDetail> searchItemByCondition(String condition);
}