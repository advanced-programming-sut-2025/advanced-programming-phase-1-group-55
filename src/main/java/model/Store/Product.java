package model.Store;

import enums.RecipeType;
import enums.Seasons;
import model.GameTime;
import model.Item.Item;

public class Product {
    private Item item;
    private int dailyLimit;
    private int goldCost;
    private int woodCost;
    private int stoneCost;
    private int todaySell=0;
    private Seasons season=Seasons.special;

    public Product(Item item, int dailyLimit, int goldCost, int woodCost, int stoneCost,Seasons season) {
        this.item = item;
        this.dailyLimit = dailyLimit;
        this.goldCost = goldCost;
        this.woodCost = woodCost;
        this.stoneCost = stoneCost;
        this.season=season;
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
        if(!(GameTime.getSeason().equals(season)||season.equals(Seasons.special))){
            return  (int)(goldCost*1.5);
        }
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

    public Seasons getSeason() {
        return season;
    }

    public void setSeason(Seasons season) {
        this.season = season;
    }
}