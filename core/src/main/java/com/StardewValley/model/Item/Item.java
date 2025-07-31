package com.StardewValley.model.Item;

import com.StardewValley.model.App;
import com.StardewValley.model.Map.Location;

public class Item {
    protected ItemType itemType;
    protected int number = 0;
    protected int price;
    protected int stage = 1;
    protected boolean isWatered = false;
    protected int daysWithOutWater = 0;
    protected Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getDaysWithOutWater() {
        return daysWithOutWater;
    }

    public void setDaysWithOutWater(int daysWithOutWater) {
        this.daysWithOutWater = daysWithOutWater;
    }

    public void increaseStage(int stage) {
        this.stage += stage;
    }

    public void increaseDayWithoutWater(int day) {
        this.daysWithOutWater += day;
    }

    public boolean isWatered() {
        return isWatered;
    }

    public void setWatered(boolean watered) {
        isWatered = watered;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Item() {
    }

    public int getPrice() {
        if (price==0){
            int x= App.rand.nextInt(100);
            price=x*25;
        }
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

    public Enum<?> getType() {
        return null;
    }

    public void addNumber(int number) {
        this.number += number;
    }

    @Override
    public String toString() {
        return itemType.getDisplayName();
    }
}
