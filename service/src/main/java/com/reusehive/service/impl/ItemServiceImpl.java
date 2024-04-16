package com.reusehive.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.reusehive.consts.ItemStatus;
import com.reusehive.entity.database.Item;
import com.reusehive.entity.database.ItemImage;
import com.reusehive.entity.database.table.ItemImageTableDef;
import com.reusehive.entity.database.table.ItemTableDef;
import com.reusehive.mapper.ItemImageMapper;
import com.reusehive.mapper.ItemMapper;
import com.reusehive.service.ItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private ItemImageMapper itemImageMapper;

    @Override
    public void newItem(Item item) {
        itemMapper.insert(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemMapper.selectOneById(id);
    }

    @Override
    public List<Item> getItemByUid(Long uid) {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.UID.eq(uid))
                .list();
    }

    @Override
    public List<Item> getAllItem() {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.ITEM_STATUS.eq(ItemStatus.UNDO))
                .list();
    }

    @Override
    public void updateItem(Item item, Long uid) {
        var dbItem = itemMapper.selectOneById(item.getId());
        if (!dbItem.getUid().equals(uid)) {
            throw new RuntimeException("无权修改");
        }
        dbItem.setName(item.getName());
        dbItem.setDescription(item.getDescription());
        dbItem.setPrices(item.getPrices());

        itemMapper.update(dbItem);
    }

    @Override
    public void deleteItem(Long id, Long uid) {
        var dbItem = itemMapper.selectOneById(id);

        if (!dbItem.getUid().equals(uid)) {
            throw new RuntimeException("无权删除");
        }

        itemMapper.deleteById(id);
    }

    @Override
    public void updateItemStatus(Long id, long uid, int status) {
        var dbItem = itemMapper.selectOneById(id);
        dbItem.setItemStatus(status);
        itemMapper.update(dbItem);
    }

    @Override
    public List<Item> getItemByType(String type) {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.ITEM_TYPE.eq(type))
                .where(ItemTableDef.ITEM.ITEM_STATUS.eq(ItemStatus.UNDO))
                .list();
    }

    @Override
    public List<String> getItemImage(Long id) {
        return QueryChain.of(itemImageMapper)
                .select(ItemImageTableDef.ITEM_IMAGE.IMAGE_URL)
                .where(ItemImageTableDef.ITEM_IMAGE.ITEM_ID.eq(id))
                .list()
                .stream().map(ItemImage::getImageUrl).toList();
    }

    @Override
    public void addItemImage(Long id, List<String> imageUrl) {
        itemImageMapper.insertBatch(imageUrl.stream().map(url -> new ItemImage(null, id, url)).toList());
    }
}
