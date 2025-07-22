package com.StardewValley.model.Tool;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Store.MarineRanchStore;
import com.StardewValley.model.Store.Store;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static java.lang.Math.max;
import static com.StardewValley.model.App.*;
import static com.StardewValley.model.weather.getEnergyLoser;

public class Shears extends  Tools{
    public int getPriceToLevelUp(){
        if(level==1){
            return 2000;
        } else if (level==2) {
            return 5000;
        }else if (level==3){
            return 10000;
        } else if (level==4) {
            return 25000;
        }
        return 0;
    }
    public Store getStore(){
        return new MarineRanchStore();
    }

    @Override
    public Sprite getSprite() {
        return AssetManager.SHEARS.getSprite();
    }

    public String getName(){
        return "shears";
    }

    @Override
    public int energyCost() {
        return (int) ((4) * getEnergyLoser());
    }
    @Override
    public void useTool() {
        currentGameModel.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }
    public int getPrice(){
        if(level==2){
            return 2000;
        } else if (level==3) {
            return 5000;
        }else if (level==4){
            return 10000;
        } else if (level==5) {
            return 25000;
        }
        return 1000;
    }

}
