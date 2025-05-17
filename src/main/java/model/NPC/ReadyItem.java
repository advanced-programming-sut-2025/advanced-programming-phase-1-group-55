package model.NPC;

import model.Item.Item;
import model.Item.ItemType;

public class ReadyItem {
    ItemType item;
    int amount;

    public ReadyItem(ItemType item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return
                " item=" + item.getDisplayName() +
                ", amount=" + amount;
    }
}
