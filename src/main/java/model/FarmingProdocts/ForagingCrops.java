package model.FarmingProdocts;

import model.Map.Location;

public class ForagingCrops {
    private AllForagingCrops foragingCropsType;
    private Location location;

    public ForagingCrops(Location location, AllForagingCrops foragingCropsType) {
        this.location = location;
        this.foragingCropsType = foragingCropsType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AllForagingCrops getForagingCropsType() {
        return foragingCropsType;
    }

    public void setForagingCropsType(AllForagingCrops foragingCropsType) {
        this.foragingCropsType = foragingCropsType;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + foragingCropsType.getName() + '\'' +
                ", season='" + foragingCropsType.getSeason() + '\'' +
                ", base sell price=" + foragingCropsType.getBaseSellPrice() +
                ", energy=" + foragingCropsType.getEnergy() +
                '}';
    }
}
