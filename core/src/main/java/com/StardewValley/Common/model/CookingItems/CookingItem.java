package com.StardewValley.Common.model.CookingItems;

import com.StardewValley.Common.enums.CookingItemType;
import com.StardewValley.Common.model.Item.Item;

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
