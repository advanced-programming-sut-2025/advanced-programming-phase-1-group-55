package model.FarmingProdocts;
import java.util.List;
public class Tree {
    private final String name;
    private final Seed seedSource;  // تغییر نوع به Seed
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final String fruits;
    private final int fruitHarvestCycle;
    private final int fruitBaseSellPrice;
    private final boolean isFruitEdible;
    private final int fruitEnergy;

    public Tree(String name, Seed seedSource, List<Integer> stages, int totalHarvestTime, String fruits, int fruitHarvestCycle, int fruitBaseSellPrice, boolean isFruitEdible, int fruitEnergy) {
        this.name = name;
        this.seedSource = seedSource;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruits = fruits;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.fruitBaseSellPrice = fruitBaseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.fruitEnergy = fruitEnergy;
    }

    // متدهای getter
    public String getName() {
        return name;
    }

    public Seed getSeedSource() {
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
        return seedSource.getSeason();  // استفاده از getSeason از Seed
    }



    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", seedSource='" + seedSource.getName() + '\'' +
                ", stages=" + stages +
                ", totalHarvestTime=" + totalHarvestTime +
                ", fruits='" + fruits + '\'' +
                ", fruitHarvestCycle=" + fruitHarvestCycle +
                ", fruitBaseSellPrice=" + fruitBaseSellPrice +
                ", isFruitEdible=" + isFruitEdible +
                ", fruitEnergy=" + fruitEnergy +
                ", season='" + seedSource.getSeason() + '\'' +
                '}';
    }
}

