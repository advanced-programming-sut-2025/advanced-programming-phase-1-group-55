package model.Item;

public class Item   {
    protected ItemType itemType;
    protected int number = 0;
    protected int price;

    public Item() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item(ItemType itemtype) {
        itemType = itemtype;
//        this.number = number;
    }
    public Item(ItemType itemtype, int number) {
        itemType = itemtype;
        this.number = number;
    }


    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public Enum<?> getType()
    {
        return null;
    }
    public void addNumber(int number) {
        this.number += number;
    }
}
