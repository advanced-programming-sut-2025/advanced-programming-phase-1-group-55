package model.Tool;

import model.App;
import model.Store.BlackSmithStore;
import model.Store.FishingStore;
import model.Store.Store;

import static java.lang.Math.max;
import static model.App.currentGame;
import static model.weather.getEnergyLoser;


public class FishingPole extends Tools {
    private final FishingPoleType type;

    public Store getStore() {
        return  new FishingStore();
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
        int energy = type.getEnergyPerUse();
        // TODO  AGAR FISHING MAX BOOD ENERGY--;
        return energy;
    }

    @Override
    public int getPriceToLevelUp() {
        if (type.equals(FishingPoleType.TRAINING_ROD)) {
            return FishingPoleType.BAMBOO_ROD.getPrice();
        } else if (type.equals(FishingPoleType.BAMBOO_ROD)) {
            return FishingPoleType.FIBERGLASS_ROD.getPrice();
        } else {
            return FishingPoleType.IRIDIUM_ROD.getPrice();
        }
    }

    @Override
    public int getPrice() {
        return type.getPrice();
    }

    public boolean canCatchAllFish() {
        return type.canCatchAllFish();
    }

    @Override
    public void useTool() {
        currentGame.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }
    //todo current user bezar

}
