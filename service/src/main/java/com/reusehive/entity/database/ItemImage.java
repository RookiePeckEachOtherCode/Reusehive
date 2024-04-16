package com.reusehive.entity.database;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("item_image")
public class ItemImage {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    Long id;
    @Column("item_id")
    Long itemId;
    @Column("image_url")
    String imageUrl;
}
