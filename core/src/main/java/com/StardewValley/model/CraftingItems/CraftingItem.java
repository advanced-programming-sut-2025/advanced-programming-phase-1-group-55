package com.StardewValley.model.CraftingItems;

import com.StardewValley.enums.CraftingItemType;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;

public abstract class CraftingItem extends Item {
    protected final CraftingItemType craftType;

    public CraftingItem(CraftingItemType craftType) {
        super(craftType.getProductName());
        this.craftType = craftType;
//        this.itemType = craftType.getProductName();
    }
    public abstract void whatItDoes();

}
