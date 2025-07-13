package model.FarmingProdocts;

import model.Item.Item;
import model.Item.ItemType;
import model.Map.Location;

public class Crop extends Item implements Fertilizable {

    private AllCrops cropType;
    private Location location;
    private boolean isWatered = false;
    private boolean isFertilized = false;

    public Crop(AllCrops cropType, Location location) {
//        super(cropType);
        this.cropType = cropType;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AllCrops getCropType() {
        return cropType;
    }

    public void setCropType(AllCrops cropType) {
        this.cropType = cropType;
    }

    @Override
    public boolean isWatered() {
        return isWatered;
    }

    @Override
    public void setWatered(boolean watered) {
        this.isWatered = watered;
    }

    @Override
    public boolean isFertilized() {
        return isFertilized;
    }

    @Override
    public void setFertilized(boolean fertilized) {
        this.isFertilized = fertilized;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + cropType.getName() + '\'' +
                ", seedSource='" + cropType.getSeed().getName() + '\'' +
                ", stages=" + cropType.getStages() +
                ", totalHarvestTime=" + cropType.getTotalHarvestTime() +
                ", regrowthTime=" + cropType.getRegrowthTime() +
                ", baseSellPrice=" + cropType.getBaseSellPrice() +
                ", isEdible=" + cropType.isEdible() +
                ", baseEnergy=" + cropType.getBaseEnergy() +
                ", season='" + cropType.getSeed().getSeason() + '\'' +
                ", canBecomeGiant=" + cropType.isCanBecomeGiant() +
                ", isWatered=" + isWatered +
                ", isFertilized=" + isFertilized +
                '}';
    }
}
