package com.reusehive.entity.database;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("purchase_info")
public class PurchaseInfo implements Serializable {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private Long id;

    private Long uid;

    @Column("item_id")
    private Long itemId;

    @Column("item_uid")
    private Long itemUid;

    private LocalDateTime createTime;

    private double prices;

    private boolean lock;

    @Column("lock_time")
    private LocalDateTime lockTime;
}
