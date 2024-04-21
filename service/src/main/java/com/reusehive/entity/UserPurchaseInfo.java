package com.reusehive.entity;

import com.reusehive.entity.database.PurchaseInfo;
import com.reusehive.entity.database.User;

import java.io.Serializable;
import java.util.List;

public class UserPurchaseInfo implements Serializable {
    private User user;
    private List<PurchaseInfo> items;
}
