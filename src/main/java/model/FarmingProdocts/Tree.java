package model.FarmingProdocts;
import java.util.List;
public class Tree {
    private AllTrees treeType;


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

