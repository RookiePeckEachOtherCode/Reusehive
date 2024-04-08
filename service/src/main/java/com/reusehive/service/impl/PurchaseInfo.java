package com.reusehive.service.impl;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table("purchase_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseInfo {
    private Long id;

    private Long uid;

    @Column("item_id")
    private Long itemId;

    private Double prices;

    private Boolean lock;

    @Column("create_time")
    private LocalDateTime createTime;

    @Column("lock_time")
    private LocalDateTime lockTime;
}
