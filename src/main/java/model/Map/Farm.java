package model.Map;

import model.FarmingProdocts.ForagingCrops;
import model.FarmingProdocts.Tree;
import model.Rock;

import java.util.HashMap;
import java.util.Map;

public class Farm {
    private House house;
    private Lake lake;
    private GreenHouse greenHouse;
    private Quarry quarry;
    private Map<Location, Rock> rocks = new HashMap<>();
    private Map<Location, Tree> trees = new HashMap<>();
    private Map<Location, ForagingCrops> crobs = new HashMap<>();

    public Farm(House house, Lake lake, GreenHouse greenHouse, Quarry quarry) {
        this.house = house;
        this.lake = lake;
        this.greenHouse = greenHouse;
        this.quarry = quarry;
    }
    //todo random gozashtan sang mang
    //todo map az foraging seeds

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
}
