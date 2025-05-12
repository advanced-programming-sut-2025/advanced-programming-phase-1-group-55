package model.Map;

import model.FarmingProdocts.Crop;
import model.FarmingProdocts.ForagingCrops;
import model.FarmingProdocts.ForagingSeed;
import model.FarmingProdocts.Tree;
import model.Rock;

import java.util.HashMap;
import java.util.Map;

public class Farm {
    private Location location;
    private House house;
    private Lake lake;
    private GreenHouse greenHouse;
    private int height = 20;
    private int width = 20;

 
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Quarry quarry;
    private Map<Location, Rock> rocks = new HashMap<>();
    private Map<Location, Tree> trees = new HashMap<>();
    private Map<Location, ForagingCrops> crobs = new HashMap<>();
    private Map<Location, ForagingSeed> seeds=new HashMap<>();

    public Farm(House house, Lake lake, GreenHouse greenHouse, Quarry quarry, Location location) {
        this.house = house;
        this.lake = lake;
        this.greenHouse = greenHouse;
        this.quarry = quarry;
        this.location = location;
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

    public Map<Location, ForagingCrops> getCrobs() {
        return crobs;
    }

    public void setCrobs(Map<Location, ForagingCrops> crobs) {
        this.crobs = crobs;
    }

    public Map<Location, ForagingSeed> getSeeds() {
        return seeds;
    }

    public void setSeeds(Map<Location, ForagingSeed> seeds) {
        this.seeds = seeds;
    }
}
