package com.StardewValley.Common.model.Tool;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.Store.FishingStore;
import com.StardewValley.Common.model.Store.Store;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static java.lang.Math.max;
import static com.StardewValley.Common.model.App.currentGameModel;
import static com.StardewValley.Common.model.weather.getEnergyLoser;


public class FishingPole extends Tools {
    private final FishingPoleType type;


    public Store getStore() {
        return new FishingStore();
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
    public Sprite getSprite() {
        return switch (type) {
            case TRAINING_ROD -> AssetManager.SIMPLE_FISHING_POLE.getSprite();
            case BAMBOO_ROD -> AssetManager.BAMBOO_FISHING_POLE.getSprite();
            case FIBERGLASS_ROD -> AssetManager.FIBER_FISHING_POLE.getSprite();
            default -> AssetManager.IRIDIUM_FISHING_POLE.getSprite();
        };
    }

    @Override
    public String getName() {
        return "FishingPole";
    }

    @Override
    public int energyCost() {
        int energy = type.getEnergyPerUse();
       return  (int) ((energy) * getEnergyLoser());
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
        currentGameModel.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }


}
