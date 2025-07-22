package com.StardewValley.model.Tool;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Store.BlackSmithStore;
import com.StardewValley.model.Store.Store;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static java.lang.Math.max;
import static com.StardewValley.model.App.*;
import static com.StardewValley.model.weather.getEnergyLoser;

public class Axe extends Tools {
    boolean usedSuccessfully = false;

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
            case 1 -> AssetManager.COPPER_AXE.getSprite();
            case 2 -> AssetManager.STEEL_AXE.getSprite();
            case 3 -> AssetManager.GOLD_AXE.getSprite();
            case 4 -> AssetManager.IRIDIUM_AXE.getSprite();
            default -> AssetManager.AXE.getSprite();
        };
    }

    public String getName() {
        return "Axe";
    }

    @Override
    public int energyCost() {
       return  (int) ((6 - level) * getEnergyLoser());
    }

    public Store getStore() {
        return new BlackSmithStore();
    }

    @Override
    public void useTool() {
        currentGameModel.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }
}
