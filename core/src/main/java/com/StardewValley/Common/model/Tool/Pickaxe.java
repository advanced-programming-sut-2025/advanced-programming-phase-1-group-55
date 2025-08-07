package com.StardewValley.Common.model.Tool;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.Store.BlackSmithStore;
import com.StardewValley.Common.model.Store.Store;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static java.lang.Math.max;
import static com.StardewValley.Common.model.App.currentGameModel;
import static com.StardewValley.Common.model.weather.getEnergyLoser;

public class Pickaxe extends Tools {


    public int getPriceToLevelUp() {
        if (level == 1) {
            return 2000;
        } else if (level == 2) {
            return 5000;
        } else if (level == 3) {
            return 10000;
        } else if (level == 4) {
            return 25000;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        if (level == 2) {
            return 2000;
        } else if (level == 3) {
            return 5000;
        } else if (level == 4) {
            return 10000;
        } else if (level == 5) {
            return 25000;
        }
        return 1000;
    }

    @Override
    public Sprite getSprite() {
        return switch (level) {
            case 1 -> AssetManager.COPPER_PICKAXE.getSprite();
            case 2 -> AssetManager.STEEL_PICKAXE.getSprite();
            case 3 -> AssetManager.GOLD_PICKAXE.getSprite();
            case 4 -> AssetManager.IRIDIUM_PICKAXE.getSprite();
            default -> AssetManager.PICKAXE.getSprite();
        };
    }

    public String getName() {
        return "Pickaxe";
    }

    @Override
    public int energyCost() {

        return (int) ((6 - level) * getEnergyLoser());
    }

    public Store getStore() {
        return new BlackSmithStore();
    }

    @Override
    public void useTool() {
        currentGameModel.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }

}
