package com.reusehive.entity.database;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import com.reusehive.entity.PurchaseType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@Table("purchase_info")
public class PurchaseInfo {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private Long id;

    private Long uid;

    @Column("item_id")
    private Long itemId;

    private LocalDateTime createTime;

    private double prices;

    private PurchaseType type;
}
