package com.StardewValley.Common.model.CraftingItems;

import com.StardewValley.Common.enums.CraftingItemType;
import com.StardewValley.Common.model.Item.Item;

public abstract class CraftingItem extends Item {
    protected final CraftingItemType craftType;

    public CraftingItem(CraftingItemType craftType) {
        super(craftType.getProductName());
        this.craftType = craftType;
//        this.itemType = craftType.getProductName();
    }
    public abstract void whatItDoes();

}
