package model;

public class Plant {
    private String name;
    private String source;
    private int[] growthStage;
    private int totalGrowthTime;
    private int growthRemaining;
    private boolean harvestable;
    private int reGrowthTime;
    private int baseSellPrice;
    private boolean eatable;
    private int baseEnergy;
    private String season;
    private boolean isBecomeGiant;
    private boolean isTree;
    private boolean isBurnt;
    private boolean hasFruits;
    private boolean watered;
    private boolean fertilized;
    private boolean fullyGrown;



    public Plant(String name, String source, int[] growthStage, int totalGrowthTime, int growthRemaining, boolean harvestable, int reGrowthTime, int baseSellPrice, boolean eatable, int baseEnergy, String season, boolean isBecomeGiant, boolean isTree, boolean isBurnt, boolean hasFruits, boolean watered, boolean fertilized, boolean fullyGrown) {
        this.name = name;
        this.source = source;
        this.growthStage = growthStage;
        this.totalGrowthTime = totalGrowthTime;
        this.growthRemaining = growthRemaining;
        this.harvestable = harvestable;
        this.reGrowthTime = reGrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.eatable = eatable;
        this.baseEnergy = baseEnergy;
        this.season = season;
        this.isBecomeGiant = isBecomeGiant;
        this.isTree = isTree;
        this.isBurnt = false;
        this.hasFruits = false;
        this.watered = watered;
        this.fertilized = fertilized;
        this.fullyGrown = fullyGrown;
    }


    public int getGrowthRemaining() {
        return growthRemaining;
    }

    public void setWatered(boolean watered) {
        this.watered = watered;
    }
    public boolean isWatered() {

    }

    public void setFertilized(boolean fertilized) {
        this.fertilized = fertilized;
    }
    public boolean isFertilized() {

    }
    public boolean isFullyGrown() {

    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public int[] getGrowthStage() {
        return growthStage;
    }

    public int getTotalGrowthTime() {
        return totalGrowthTime;
    }

    public boolean isHarvestable() {
        return harvestable;
    }

    public int getReGrowthTime() {
        return reGrowthTime;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public boolean isEatable() {
        return eatable;
    }

    public int getBaseEnergy() {
        return baseEnergy;
    }

    public String getSeason() {
        return season;
    }

    public boolean isBecomeGiant() {
        return isBecomeGiant;
    }

    public boolean isTree() {
        return isTree;
    }

    public boolean isBurnt() {
        return isBurnt;
    }

    public boolean isHasFruits() {
        return hasFruits;
    }

    public boolean isAttackedByCrown() {

    }
    public  boolean canBecomeGiant() {

    }
    public static Plant mixedTreeSeed(String season) {

    }
    public void growFruits() {

    }
    public void lightningStrike() {

    }
    public void cutDownTree() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setGrowthStage(int[] growthStage) {
        this.growthStage = growthStage;
    }

    public void setTotalGrowthTime(int totalGrowthTime) {
        this.totalGrowthTime = totalGrowthTime;
    }

    public void setGrowthRemaining(int growthRemaining) {
        this.growthRemaining = growthRemaining;
    }

    public void setHarvestable(boolean harvestable) {
        this.harvestable = harvestable;
    }

    public void setReGrowthTime(int reGrowthTime) {
        this.reGrowthTime = reGrowthTime;
    }

    public void setBaseSellPrice(int baseSellPrice) {
        this.baseSellPrice = baseSellPrice;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public void setBaseEnergy(int baseEnergy) {
        this.baseEnergy = baseEnergy;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setBecomeGiant(boolean becomeGiant) {
        isBecomeGiant = becomeGiant;
    }

    public void setTree(boolean tree) {
        isTree = tree;
    }

    public void setBurnt(boolean burnt) {
        isBurnt = burnt;
    }

    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    public void setFullyGrown(boolean fullyGrown) {
        this.fullyGrown = fullyGrown;
    }
}
