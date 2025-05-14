package model.CookingItems;

import enums.CraftingItemType;
import model.Item.Item;

public class CookingItem extends Item {
    private final CraftingItemType craftType;
    public CookingItem(CraftingItemType craftType, int number) {
        super(craftType.getProductName());
        super.setNumber(number);
        this.craftType = craftType;
    }

    public CraftingItemType getCraftType() {
        return craftType;
    }
}
