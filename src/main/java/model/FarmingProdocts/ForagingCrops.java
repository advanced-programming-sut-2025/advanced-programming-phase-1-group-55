package model.FarmingProdocts;

public class ForagingCrops {
    private AllForagingCrops foragingCropsType;

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
