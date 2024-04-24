package com.reusehive.service.impl;


import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.util.UpdateEntity;
import com.reusehive.consts.ItemStatus;
import com.reusehive.entity.database.Item;
import com.reusehive.entity.database.PurchaseInfo;
import com.reusehive.entity.database.table.PurchaseInfoTableDef;
import com.reusehive.mapper.PurchaseMapper;
import com.reusehive.service.ItemService;
import com.reusehive.service.PurchaseService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j

public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private PurchaseMapper purchaseMapper;
    @Resource
    private ItemService itemService;

    @Override
    public Long CreatePurchase(Long uid, Long itemId, Long itemUid, Double price) {
        var purchaseInfo = new PurchaseInfo(null, uid, itemId, itemUid, LocalDateTime.now(), price, false, LocalDateTime.now());

        Item itemInfo = itemService.getSingleItemById(itemId);

        if (itemInfo == null) {
            throw new RuntimeException("商品不存在");
        }
        if (itemInfo.getItemStatus() != ItemStatus.UNDO) {
            throw new RuntimeException("商品已被购买");
        }

        if (itemInfo.getUid().equals(uid)) {
            throw new RuntimeException("不能购买自己的商品");
        }

        itemService.setItemStatus(itemId, ItemStatus.TRADING);

        purchaseMapper.insert(purchaseInfo);
        return purchaseInfo.getId();
    }

    @Override
    public void PurchaseComplete(Long purchase_id) {
        var uid = StpUtil.getLoginIdAsLong();
        PurchaseInfo purchaseInfo = GetPurchaseInfoById(purchase_id);

        if (!(purchaseInfo.getUid().equals(uid) || purchaseInfo.getItemUid().equals(uid))) {
            throw new RuntimeException("无权确认交易");
        }


        var itemId = itemService.getSingleItemById(purchaseInfo.getItemId()).getId();
        itemService.setItemStatus(itemId, ItemStatus.DONE);

        PurchaseInfo NewInfo = UpdateEntity.of(PurchaseInfo.class, purchase_id);
        NewInfo.setLockTime(LocalDateTime.now());
        NewInfo.setLock(true);
        purchaseMapper.update(NewInfo);

    }

    @Override
    public List<PurchaseInfo> GetUserPurchaseList(Long user_id) {
        return QueryChain.of(purchaseMapper)
                .where(PurchaseInfoTableDef.PURCHASE_INFO.UID.eq(user_id))
                .or(PurchaseInfoTableDef.PURCHASE_INFO.ITEM_UID.eq(user_id))
                .list();
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
        var currentUid = StpUtil.getLoginIdAsLong();
        PurchaseInfo purchaseInfo = GetPurchaseInfoById(purchase_id);

        if (!(purchaseInfo.getUid().equals(currentUid) || purchaseInfo.getItemUid().equals(currentUid))) {
            throw new RuntimeException("无权取消交易");
        }

        var itemId = purchaseInfo.getItemId();
        itemService.setItemStatus(itemId, ItemStatus.UNDO);
        purchaseMapper.deleteById(purchase_id);
    }
}
