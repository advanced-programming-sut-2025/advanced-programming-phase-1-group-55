package model.FarmingProdocts;




import java.util.List;

public class Crop {
    private final String name;                  // نام محصول
    private final String seedSource;            // منبع بذر
    private final List<Integer> stages;         // مراحل رشد
    private final int totalHarvestTime;         // زمان کل برداشت
    private final boolean isOneTime;            // آیا محصول یک‌بار برداشت می‌شود؟
    private final int regrowthTime;             // زمان رشد مجدد
    private final int baseSellPrice;            // قیمت فروش پایه
    private final boolean isEdible;             // آیا قابل خوردن است؟
    private final int baseEnergy;               // انرژی پایه
    private final String season;                // فصل کشت
    private final boolean canBecomeGiant;       // آیا محصول می‌تواند غول‌آسا شود؟

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


