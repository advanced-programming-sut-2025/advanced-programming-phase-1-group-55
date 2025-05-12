package model.FarmingProdocts;
import model.Map.Location;

import model.Item.Item;

import java.util.List;

public class Crop {
    private AllCrops cropType;
    private Location location;

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
                '}';
    }
}



