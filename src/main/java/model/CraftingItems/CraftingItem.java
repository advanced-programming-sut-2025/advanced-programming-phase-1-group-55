package model.CraftingItems;

import enums.CraftingItemType;
import model.Item.Item;
import model.Item.ItemType;

public abstract class CraftingItem extends Item {
    protected final CraftingItemType craftType;

    public CraftingItem(CraftingItemType craftType) {
        super(craftType.getProductName());
        this.craftType = craftType;
//        this.itemType = craftType.getProductName();
    }
    public abstract void whatItDoes();

}
