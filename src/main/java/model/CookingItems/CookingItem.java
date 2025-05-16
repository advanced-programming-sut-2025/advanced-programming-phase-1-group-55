package model.CookingItems;

import enums.CookingItemType;
import model.Item.Item;
import model.Item.ItemType;

import java.util.ArrayList;

public class CookingItem extends Item {
    private final CookingItemType cookItem;
//    public CookingItem(CookingItemType cookItem, int number) {
//        super(cookItem.getProductName(), number);
//        this.cookItem = cookItem;
//    }
    public CookingItem(CookingItemType cookItem) {
        super(cookItem.getProductName());
        this.cookItem = cookItem;
    }

    public CookingItemType getCraftType() {
        return cookItem;
    }


}
