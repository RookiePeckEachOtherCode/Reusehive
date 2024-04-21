package com.reusehive.entity;

import com.reusehive.entity.database.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetail implements Serializable {
    private Item item;
    private List<String> images;
}
