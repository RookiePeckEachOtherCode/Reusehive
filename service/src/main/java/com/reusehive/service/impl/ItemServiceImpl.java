package com.reusehive.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.reusehive.consts.CacheKey;
import com.reusehive.consts.ItemStatus;
import com.reusehive.entity.ItemDetail;
import com.reusehive.entity.database.Collection;
import com.reusehive.entity.database.Item;
import com.reusehive.entity.database.ItemImage;
import com.reusehive.entity.database.table.CollectionTableDef;
import com.reusehive.entity.database.table.ItemImageTableDef;
import com.reusehive.entity.database.table.ItemTableDef;
import com.reusehive.mapper.CollectionMapper;
import com.reusehive.mapper.ItemImageMapper;
import com.reusehive.mapper.ItemMapper;
import com.reusehive.service.ItemService;
import com.reusehive.utils.MinioUtils;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private ItemImageMapper itemImageMapper;
    @Resource
    private MinioUtils minioUtils;
    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public void newItem(Item item, MultipartFile[] images) {
        var imageUrls = new CopyOnWriteArrayList<String>();

        for (var image : images) {
            try {
                imageUrls.add(minioUtils.UploadItemBackImg(image));
            } catch (IOException | ServerException | InsufficientDataException | ErrorResponseException |
                     NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                     InternalException e) {
                throw new RuntimeException(e);
            }
        }
        itemMapper.insert(item);


        itemImageMapper.insertBatch(imageUrls.stream().map(url -> new ItemImage(null, item.getId(), url)).toList());
    }

    @Override
    @Cacheable(value = CacheKey.ITEM_DETAIL_ID, key = "#id")
    public ItemDetail getItemById(Long id) {
        var item = itemMapper.selectOneById(id);
        var images = QueryChain.of(itemImageMapper).select(ItemImageTableDef.ITEM_IMAGE.IMAGE_URL)
                .where(ItemImageTableDef.ITEM_IMAGE.ITEM_ID.eq(id))
                .list()
                .stream()
                .map(ItemImage::getImageUrl)
                .toList();
        return new ItemDetail(item, images);
    }

    @Override
    @Cacheable(value = CacheKey.ITEM_LIST_UID, key = "#uid")
    public List<ItemDetail> getItemByUid(Long uid) {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.UID.eq(uid))
                .list()
                .stream()
                .map(it -> new ItemDetail(it, this.getItemImage(it.getId())))
                .toList();
    }

    @Override
    @Cacheable(value = CacheKey.ITEM_LIST_ALL, key = "#root.methodName")
    public List<ItemDetail> getAllItem() {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.ITEM_STATUS.eq(ItemStatus.UNDO))
                .list()
                .stream()
                .map(it -> new ItemDetail(it, this.getItemImage(it.getId())))
                .toList();
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = CacheKey.ITEM_DETAIL_ID, key = "#item.id"),
                    @CacheEvict(value = CacheKey.ITEM_LIST_UID, key = "#uid"),
                    @CacheEvict(value = CacheKey.ITEM_LIST_ALL, allEntries = true)
            }
    )
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
    @Caching(
            evict = {
                    @CacheEvict(value = CacheKey.ITEM_DETAIL_ID, key = "#id"),
                    @CacheEvict(value = CacheKey.ITEM_LIST_UID, key = "#uid"),
                    @CacheEvict(value = CacheKey.ITEM_LIST_ALL, allEntries = true)
            }
    )
    public void deleteItem(Long id, Long uid) {
        var dbItem = itemMapper.selectOneById(id);

        if (!dbItem.getUid().equals(uid)) {
            throw new RuntimeException("无权删除");
        }

        itemMapper.deleteById(id);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = CacheKey.ITEM_DETAIL_ID, key = "#id"),
                    @CacheEvict(value = CacheKey.ITEM_LIST_UID, key = "#uid"),
                    @CacheEvict(value = CacheKey.ITEM_LIST_ALL, allEntries = true)
            }
    )
    public void updateItemStatus(Long id, long uid, int status) {
        var dbItem = itemMapper.selectOneById(id);
        dbItem.setItemStatus(status);
        itemMapper.update(dbItem);
    }

    @Override
    @Cacheable(value = CacheKey.ITEM_TYPE_LIST, key = "#type")
    public List<Item> getItemByType(String type) {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.ITEM_TYPE.eq(type))
                .where(ItemTableDef.ITEM.ITEM_STATUS.eq(ItemStatus.UNDO))
                .list();
    }

    @Override
    @Cacheable(value = CacheKey.ITEM_IMAGE_LIST_ID, key = "#id")
    public List<String> getItemImage(Long id) {
        return QueryChain.of(itemImageMapper)
                .select(ItemImageTableDef.ITEM_IMAGE.IMAGE_URL)
                .where(ItemImageTableDef.ITEM_IMAGE.ITEM_ID.eq(id))
                .list()
                .stream().map(ItemImage::getImageUrl).toList();
    }


    @Override
//    @Cacheable(value = CacheKey.COLLECTION_LIST_UID, key = "#uid")
    public List<ItemDetail> getCollectionItems(Long uid) {
        List<Collection> collections = QueryChain.of(collectionMapper)
                .where(CollectionTableDef.COLLECTION.UID.eq(uid))
                .list();

        return collections.stream()
                .map(collection -> getItemById(collection.getItemId()))
                .collect(Collectors.toList());
    }

    @Override
//    @CacheEvict(value = CacheKey.COLLECTION_LIST_UID, key = "#uid")
    public void addCollectionItem(Long uid, Long item_id) {
        Collection collection = new Collection(null, uid, item_id);
        collectionMapper.insert(collection);
    }

    @Override
//    @Cacheable(value = CacheKey.USER_COLLECTION_ITEM_IS, key = "#uid + '-' + #item_id")
    public Boolean isCollected(Long uid, Long item_id) {
        return QueryChain.of(collectionMapper).where(CollectionTableDef.COLLECTION.UID.eq(uid).and(CollectionTableDef.COLLECTION.ITEM_ID.eq(item_id))).one() != null;
    }

    @Override
//    @Caching(
//            evict = {
//                    @CacheEvict(value = CacheKey.COLLECTION_LIST_UID, key = "#uid"),
//                    @CacheEvict(value = CacheKey.USER_COLLECTION_ITEM_IS, key = "#uid + '-' + #item_id")
//            }
//    )
    public void deleteItemFromCollections(Long uid, Long item_id) {
        Collection collection = QueryChain.of(collectionMapper).where(CollectionTableDef.COLLECTION.UID.eq(uid).and(CollectionTableDef.COLLECTION.ITEM_ID.eq(item_id))).one();
        collectionMapper.deleteById(collection.getId());
    }

    @Override
    public List<ItemDetail> searchItemByCondition(String Condition) {
        return QueryChain.of(itemMapper)
                .where(ItemTableDef.ITEM.ITEM_TYPE.like(Condition).or(ItemTableDef.ITEM.NAME.like(Condition)))
                .list()
                .stream()
                .map(it -> new ItemDetail(it, this.getItemImage(it.getId())))
                .toList();
    }
}
