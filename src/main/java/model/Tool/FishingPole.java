package model.Tool;

import enums.Store;

import static java.lang.Math.max;
import static model.Game.mainUser;

public class FishingPole extends Tools {
    private final FishingPoleType type;
    private  final Store store=Store.fishShop;
    public Store getStore() {
        return store;
    }

    public FishingPoleType getType() {
        return type;
    }


    public FishingPole(FishingPoleType type) {
        this.type = type;
    }

    public boolean canUse(int fishingLevel) {
        return fishingLevel >= type.getRequiredLevel();
    }

    @Override
    public String getName() {
        return "FishingPole";
    }

    @Override
    public int energyCost() {
        int energy=type.getEnergyPerUse();
        // TO DO  AGAR FISHING MAX BOOD ENERGY--;
        return energy;
    }

    @Override
    public int getPriceToLevelUp() {
        if(type.equals(FishingPoleType.TRAINING_ROD)){
            return FishingPoleType.BAMBOO_ROD.getPrice();
        } else if (type.equals(FishingPoleType.BAMBOO_ROD)) {
            return FishingPoleType.FIBERGLASS_ROD.getPrice();
        } else {
            return FishingPoleType.IRIDIUM_ROD.getPrice();
        }
    }

    @Override
    public int getPrice() {
        return  type.getPrice();
    }

    public boolean canCatchAllFish() {
        return type.canCatchAllFish();
    }
    @Override
    public void useTool() {
        mainUser.setEnergy(max(mainUser.getEnergy()-energyCost(),0));
    }

}
