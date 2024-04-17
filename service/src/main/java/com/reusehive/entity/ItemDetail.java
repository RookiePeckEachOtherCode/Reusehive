package com.reusehive.entity;

import com.reusehive.entity.database.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetail {
   private Item item;
   private List<String> images;
}
