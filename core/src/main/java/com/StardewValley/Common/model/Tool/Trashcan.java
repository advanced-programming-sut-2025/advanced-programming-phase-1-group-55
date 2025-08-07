package com.StardewValley.Common.model.Tool;

import com.StardewValley.Common.enums.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static java.lang.Math.max;
import static com.StardewValley.Common.model.App.*;
import static com.StardewValley.Common.model.weather.getEnergyLoser;

public class Trashcan extends Tools{

    @Override
    public Sprite getSprite() {
        return switch (level) {
            case 2 -> AssetManager.STEEL_TRASHCAN.getSprite();
            case 3 -> AssetManager.GOLD_TRASHCAN.getSprite();
            case 4 -> AssetManager.IRIDIUM_TRASHCAN.getSprite();
            default -> AssetManager.COPPER_TRASHCAN.getSprite();
        };
    }

    public String getName() {
        return "Trashcan";
    }

    @Override
    public void useTool() {
        currentGameModel.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }

    @Override
    public int energyCost() {
        return (int) ((6 - level) * getEnergyLoser());
    }

    public int getPriceToLevelUp(){
        if(level==1){
            return 1000;
        } else if (level==2) {
            return 2500;
        } else if (level==3) {
            return 5000;
        } else if (level==4) {
            return 12500;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        if(level==2){
            return 1000;
        } else if (level==3) {
            return 2500;
        } else if (level==4) {
            return 5000;
        } else if (level==5) {
            return 12500;
        }
        return 500;
    }

    public double getRatio() {
       return (double) ((level + 1) * 15) ;
    }

    public void setRatio(double ratio) {
    }
}
