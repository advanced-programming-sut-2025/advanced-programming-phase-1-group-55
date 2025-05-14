package model.CraftingItems;

import enums.CraftingItemType;
import model.Item.ItemType;

public class Bomb extends CraftingItem {
    public Bomb(){
        super(CraftingItemType.BOMB, ItemType.BOMB);
    }

    @Override
    public void whatItDoes() {

    }
}
