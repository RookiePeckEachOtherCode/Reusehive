package com.reusehive.service;

import com.reusehive.entity.database.PurchaseInfo;

import java.util.List;

public interface PurchaseService {
    void CreatePurchase(Long user_id,Long item_id,Double price);

    void PurchaseComplete(Long purchase_id);

    List<PurchaseInfo> GetUserPurchaseList(Long user_id);

    PurchaseInfo GetPurchaseInfoById(Long purchase_id);

    void RemoveItem(Long item_id);

    void CanclePurchase(Long purchase_id);

}
