package com.StardewValley.model.CookingItems;

import com.StardewValley.enums.CookingItemType;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;

import java.util.ArrayList;

public class CookingItem extends Item {
    private final CookingItemType cookItem;
    public CookingItem(CookingItemType cookItem) {
        super(cookItem.getProductName());
        this.cookItem = cookItem;
    }

    public CookingItemType getCraftType() {
        return cookItem;
    }


}
