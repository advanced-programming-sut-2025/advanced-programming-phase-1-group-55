package model.FarmingProdocts;




import java.util.List;

public class Crop {
    private final String name;
    private final String seedSource;
    private final List<Integer> stages;
    private final int totalHarvestTime;
    private final boolean isOneTime;
    private final int regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
    private final int baseEnergy;
    private final String season;
    private final boolean canBecomeGiant;

    // سازنده کلاس


    public Crop(String name, String seedSource, List<Integer> stages, int totalHarvestTime, boolean isOneTime, int regrowthTime, int baseSellPrice, boolean isEdible, int baseEnergy, String season, boolean canBecomeGiant) {
        this.name = name;
        this.seedSource = seedSource;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.isOneTime = isOneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.baseEnergy = baseEnergy;
        this.season = season;
        this.canBecomeGiant = canBecomeGiant;
    }

    // متدهای گتر (Getters)
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
        return season;
    }

    public boolean canBecomeGiant() {
        return canBecomeGiant;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + name + '\'' +
                ", seedSource='" + seedSource + '\'' +
                ", stages=" + stages +
                ", totalHarvestTime=" + totalHarvestTime +
                ", regrowthTime=" + regrowthTime +
                ", baseSellPrice=" + baseSellPrice +
                ", isEdible=" + isEdible +
                ", baseEnergy=" + baseEnergy +
                ", season='" + season + '\'' +
                ", canBecomeGiant=" + canBecomeGiant +
                '}';
    }
}


