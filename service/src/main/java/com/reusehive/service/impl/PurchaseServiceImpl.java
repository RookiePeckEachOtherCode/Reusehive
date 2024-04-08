package com.reusehive.service.impl;


import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.util.UpdateEntity;
import com.reusehive.entity.database.Item;
import com.reusehive.entity.database.PurchaseInfo;
import com.reusehive.entity.database.table.ItemTableDef;
import com.reusehive.entity.database.table.PurchaseInfoTableDef;
import com.reusehive.mapper.ItemMapper;
import com.reusehive.mapper.PurchaseMapper;
import com.reusehive.service.PurchaseService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j

public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private PurchaseMapper purchaseMapper;
    @Resource
    private ItemMapper itemMapper;

    @Override
    public void CreatePurchase(Long user_id, Long item_id,Double price) {
        PurchaseInfo purchaseInfo =new PurchaseInfo();
        purchaseInfo.setId(null);purchaseInfo.setCreateTime(LocalDateTime.now());
        purchaseInfo.setPrices(price);purchaseInfo.setUid(user_id);
        purchaseInfo.setLock(false);purchaseInfo.setItemId(item_id);
        purchaseInfo.setLockTime(LocalDateTime.now());
        purchaseMapper.insert(purchaseInfo);

        Item iteminfo = QueryChain.of(itemMapper).where(ItemTableDef.ITEM.ID.eq(item_id)).one();
        if(Objects.equals(iteminfo.getUid(), user_id))throw new RuntimeException("无法和自己建立交易");


        Item item=UpdateEntity.of(Item.class,item_id);
        item.setType(1);
        itemMapper.update(item);

    }

    @Override
    public void PurchaseComplete(Long purchase_id) {
        PurchaseInfo purchaseInfo = GetPurchaseInfoById(purchase_id);

        Item item = UpdateEntity.of(Item.class, purchaseInfo.getItemId());
        item.setType(2);
        itemMapper.update(item);

        PurchaseInfo NewInfo = UpdateEntity.of(PurchaseInfo.class, purchase_id);
        NewInfo.setLockTime(LocalDateTime.now());
        NewInfo.setLock(true);
        purchaseMapper.update(NewInfo);

    }

    @Override
    public List<PurchaseInfo> GetUserPurchaseList(Long user_id) {
        return QueryChain.of(purchaseMapper).where(PurchaseInfoTableDef.PURCHASE_INFO.UID.eq(user_id)).list();
    }

    @Override
    public PurchaseInfo GetPurchaseInfoById(Long purchase_id) {
        return QueryChain.of(purchaseMapper).where(PurchaseInfoTableDef.PURCHASE_INFO.ID.eq(purchase_id)).one();
    }

    @Override
    public void RemoveItem(Long item_id) {
        purchaseMapper.deleteByCondition(PurchaseInfoTableDef.PURCHASE_INFO.ITEM_ID.eq(item_id));
    }

    @Override
    public void CanclePurchase(Long purchase_id) {
        PurchaseInfo purchaseInfo = GetPurchaseInfoById(purchase_id);
        List<PurchaseInfo> infos = QueryChain.of(purchaseMapper).where(PurchaseInfoTableDef.PURCHASE_INFO.ITEM_ID.eq(purchaseInfo.getItemId())).list();
        if (infos.size()==1){
            Item item = UpdateEntity.of(Item.class, purchaseInfo.getItemId());
            item.setType(0);
        }
        purchaseMapper.deleteById(purchase_id);
    }
}
