package model.FarmingProdocts;
import java.util.List;

public class Crop {
    private final String name;
    private final Seed seed;
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final boolean isOneTime;
    private final int regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
    private final int baseEnergy;
    private final boolean canBecomeGiant;


    public Crop(String name, Seed seed, List<Integer> stages, int totalHarvestTime, boolean isOneTime,
                int regrowthTime, int baseSellPrice, boolean isEdible, int baseEnergy,
                boolean canBecomeGiant) {
        this.name = name;
        this.seed = seed;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.isOneTime = isOneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.baseEnergy = baseEnergy;
        this.canBecomeGiant = canBecomeGiant;
    }

    // متدهای getter
    public String getName() {
        return name;
    }

    public Seed getSeed() {
        return seed;
    }

    public List<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public boolean isOneTime() {
        return isOneTime;
    }

    public int getRegrowthTime() {
        return regrowthTime;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public int getBaseEnergy() {
        return baseEnergy;
    }

    public String getSeason() {
        return seed.getSeason();
    }

    public boolean canBecomeGiant() {
        return canBecomeGiant;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + name + '\'' +
                ", seedSource='" + seed.getName() + '\'' +
                ", stages=" + stages +
                ", totalHarvestTime=" + totalHarvestTime +
                ", regrowthTime=" + regrowthTime +
                ", baseSellPrice=" + baseSellPrice +
                ", isEdible=" + isEdible +
                ", baseEnergy=" + baseEnergy +
                ", season='" + seed.getSeason() + '\'' +
                ", canBecomeGiant=" + canBecomeGiant +
                '}';
    }
}



