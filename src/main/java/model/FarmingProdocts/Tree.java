package model.FarmingProdocts;
import model.Map.Location;

import java.util.List;
public class Tree {
    private AllTrees treeType;
    private Location location;

    public Tree( Location location,AllTrees treeType) {
        this.treeType = treeType;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AllTrees getTreeType() {
        return treeType;
    }

    public void setTreeType(AllTrees treeType) {
        this.treeType = treeType;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + treeType.getName() + '\'' +
                ", seedSource='" + treeType.getSeedSource().getName() + '\'' +
                ", stages=" + treeType.getStages() +
                ", totalHarvestTime=" + treeType.getTotalHarvestTime() +
                ", fruits='" + treeType.getFruits() + '\'' +
                ", fruitHarvestCycle=" + treeType.getFruitHarvestCycle() +
                ", fruitBaseSellPrice=" + treeType.getFruitBaseSellPrice() +
                ", isFruitEdible=" + treeType.isFruitEdible() +
                ", fruitEnergy=" + treeType.getFruitEnergy() +
                ", season='" + treeType.getSeedSource().getSeason() + '\'' +
                '}';
    }
}

