package com.reusehive.service.impl;

import static com.reusehive.entity.database.table.ItemImageTableDef.ITEM_IMAGE;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatisflex.core.query.QueryChain;
import com.reusehive.consts.ItemStatus;
import com.reusehive.entity.ItemDetail;
import com.reusehive.entity.database.Item;
import com.reusehive.entity.database.ItemImage;
import com.reusehive.entity.database.table.ItemTableDef;
import com.reusehive.mapper.ItemMapper;
import com.reusehive.service.ItemService;

import jakarta.annotation.Resource;

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;

    @Override
    public void newItem(Item item) {
        itemMapper.insert(item);
    }

    @Override
    public ItemDetail getItemById(Long id) {
//        return itemMapper.selectOneById(id);
        var item=itemMapper.selectOneById(id);
        var images=QueryChain.of(itemImageMapper).select(ITEM_IMAGE.IMAGE_URL)
                .where(ITEM_IMAGE.ITEM_ID.eq(id))
                .list()
                .stream()
                .map(ItemImage::getImageUrl)
                .toList();
        return new ItemDetail(item,images);

    }

    @Override
    public List<Item> getItemByUid(Long uid) {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.UID.eq(uid))
                .list();
    }

    @Override
    public List<ItemDetail> getAllItem() {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.ITEM_STATUS.eq(ItemStatus.UNDO))
                .list()
                .stream()
                .map(it-> new ItemDetail(it,this.getItemImage(it.getId())))
                .toList();
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
                .select(ITEM_IMAGE.IMAGE_URL)
                .where(ITEM_IMAGE.ITEM_ID.eq(id))
                .list()
                .stream().map(ItemImage::getImageUrl).toList();
    }

    @Override
    public void addItemImage(Long id, List<String> imageUrl) {
        itemImageMapper.insertBatch(imageUrl.stream().map(url -> new ItemImage(null, id, url)).toList());
    }
}
