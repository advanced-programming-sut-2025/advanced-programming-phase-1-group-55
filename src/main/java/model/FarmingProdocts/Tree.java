package model.FarmingProdocts;
import java.util.List;
public class Tree {
    private final String name;
    private final String seedSource;
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final String fruits;
    private final int fruitHarvestCycle;
    private final int fruitBaseSellPrice;
    private final boolean isFruitEdible;
    private final int fruitEnergy;
    private final String season;

    public Tree(String name, String seedSource, List<Integer> stages, int totalHarvestTime, String fruits, int fruitHarvestCycle, int fruitBaseSellPrice, boolean isFruitEdible, int fruitEnergy, String season) {
        this.name = name;
        this.seedSource = seedSource;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruits = fruits;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.fruitBaseSellPrice = fruitBaseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.fruitEnergy = fruitEnergy;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public String getSeedSource() {
        return seedSource;
    }

    public List<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public String getFruits() {
        return fruits;
    }

    public int getFruitHarvestCycle() {
        return fruitHarvestCycle;
    }

    public int getFruitBaseSellPrice() {
        return fruitBaseSellPrice;
    }

    public boolean isFruitEdible() {
        return isFruitEdible;
    }

    public int getFruitEnergy() {
        return fruitEnergy;
    }

    public String getSeason() {
        return season;
    }


    @Override
    public String toString() {
        return "Crop{" +
                "name='" + name + '\'' +
                ", seedSource='" + seedSource + '\'' +
                ", stages=" + stages +
                ", totalHarvestTime=" + totalHarvestTime +
                ", fruits=" + fruits +
                ", fruitHarvestCycle=" + fruitHarvestCycle +
                ", fruitBaseSellPrice=" + fruitBaseSellPrice +
                ", isFruitEdible=" + isFruitEdible +
                ", fruitEnergy='" + fruitEnergy + '\'' +
                ", season=" + season +
                '}';
    }
}
