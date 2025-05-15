package model.CookingItems;

import enums.CookingItemType;
import model.Item.Item;
import model.Item.ItemType;

import java.util.ArrayList;

public class CookingItem extends Item {
    private final CookingItemType cookItem;
    public CookingItem(CookingItemType cookItem, int number) {
        super(cookItem.getProductName());
        super.setNumber(number);
        this.cookItem = cookItem;
    }

    public CookingItemType getCraftType() {
        return cookItem;
    }
    private ArrayList<CookingItem> refrigerator = new ArrayList<>();

    public ArrayList<CookingItem> getRefrigerator() {
        return refrigerator;
    }

    public CookingItem getFromRefrigerator(ItemType itemType) {
        for (CookingItem refrigeratorItem : refrigerator) {
            if (refrigeratorItem.getItemType().equals(itemType)) {
                return refrigeratorItem;
            }
        }
        return null;
    }
    public int howManyInRefrigerator(ItemType itemType) {
        for (CookingItem refrigeratorItem : refrigerator) {
            if (refrigeratorItem.getItemType().equals(itemType)) {
                return refrigeratorItem.getNumber();
            }
        }
        return 0;
    }
    public void removeFromRefrigerator(ItemType itemType, int number) {
        for (CookingItem refrigeratorItem : refrigerator) {
            if (refrigeratorItem.getItemType().equals(itemType)) {
                refrigeratorItem.addNumber(-1 * number);
                if (refrigeratorItem.getNumber() <= 0) {
                    refrigerator.remove(refrigeratorItem);
                }
                break;
            }
        }
    }
}
