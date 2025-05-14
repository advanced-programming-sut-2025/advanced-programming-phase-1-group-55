package model.Store;

import model.Item.Item;

public class Product {
    private Item item;
    private int dailyLimit;
    private int goldCost;
    private int woodCost;
    private int stoneCost;
    private int todaySell=0;

    public Product(Item item, int dailyLimit, int goldCost, int woodCost, int stoneCost) {
        this.item = item;
        this.dailyLimit = dailyLimit;
        this.goldCost = goldCost;
        this.woodCost = woodCost;
        this.stoneCost = stoneCost;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(int dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }

    public int getWoodCost() {
        return woodCost;
    }

    public void setWoodCost(int woodCost) {
        this.woodCost = woodCost;
    }

    public int getStoneCost() {
        return stoneCost;
    }

    public void setStoneCost(int stoneCost) {
        this.stoneCost = stoneCost;
    }

    public int getTodaySell() {
        return todaySell;
    }

    public void setTodaySell(int todaySell) {
        this.todaySell = todaySell;
    }
}