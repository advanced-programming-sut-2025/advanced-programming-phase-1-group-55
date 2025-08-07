package com.StardewValley.model.Map;

import com.StardewValley.View.FarmLand;
import com.StardewValley.model.App;
import com.StardewValley.model.FarmingProdocts.ForagingCrops;
import com.StardewValley.model.FarmingProdocts.ForagingSeed;
import com.StardewValley.model.FarmingProdocts.Tree;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Rock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Farm {

    private House house;
    private Lake lake;
    private GreenHouse greenHouse;
    private CollisionRect collisionRect;
    private int numberOfRocksInTheQuery=0;
    private ArrayList<Fence> doors = new ArrayList<>();

    private ArrayList<FarmLand> farmLands = new ArrayList<>();
    public ArrayList<FarmLand> getFarmLands() { return farmLands; }



    private Quarry quarry;
    private Map<Location, Rock> rocks = new HashMap<>();
    private Map<Location, Tree> trees = new HashMap<>();
    private Map<Location, ForagingCrops> crobs = new HashMap<>();
    private Map<Location, ForagingSeed> seeds=new HashMap<>();

    public Farm(House house, Lake lake, GreenHouse greenHouse, Quarry quarry, CollisionRect collisionRect) {
        this.house = house;
        this.lake = lake;
        this.greenHouse = greenHouse;
        this.quarry = quarry;
        this.collisionRect = collisionRect;

    }
   public void increaseRocks(){
        numberOfRocksInTheQuery++;
   }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Lake getLake() {
        return lake;
    }

    public void setLake(Lake lake) {
        this.lake = lake;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }

    public void setGreenHouse(GreenHouse greenHouse) {
        this.greenHouse = greenHouse;
    }

    public Quarry getQuarry() {
        return quarry;
    }

    public void setQuarry(Quarry quarry) {
        this.quarry = quarry;
    }

    public Map<Location, Rock> getRocks() {
        return rocks;
    }

    public void setRocks(Map<Location, Rock> rocks) {
        this.rocks = rocks;
    }

    public Map<Location, Tree> getTrees() {
        return trees;
    }

    public void setTrees(Map<Location, Tree> trees) {
        this.trees = trees;
    }


    public Map<Location, ForagingSeed> getSeeds() {
        return seeds;
    }

    public void setSeeds(Map<Location, ForagingSeed> seeds) {
        this.seeds = seeds;
    }

    public void draw(){
        lake.getSprite().setPosition(lake.getCollisionRect().getX(), lake.getCollisionRect().getY());
        quarry.getSprite().setPosition(quarry.getCollisionRect().getX(), quarry.getCollisionRect().getY());
        house.getSprite().setPosition(house.getCollisionRect().getX(), house.getCollisionRect().getY());
        greenHouse.getSprite().setPosition(greenHouse.getCollisionRect().getX(), greenHouse.getCollisionRect().getY());
        lake.getSprite().draw(App.gameApp.getBatch());
        quarry.getSprite().draw(App.gameApp.getBatch());
        house.getSprite().draw(App.gameApp.getBatch());
        greenHouse.getSprite().draw(App.gameApp.getBatch());
    }

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }
    public FarmLand findFarmLandAt(float x, float y) {
        for (FarmLand land : farmLands) {
            if (land.getCollisionRect().isInside(x, y)) {
                return land;
            }
        }
        return null;
    }



    public ArrayList<Fence> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Fence> doors) {
        this.doors = doors;
    }
}
