package com.StardewValley.model.Tool;

import com.StardewValley.model.Store.BlackSmithStore;
import com.StardewValley.model.Store.MarineRanchStore;
import com.StardewValley.model.Store.Store;

import static java.lang.Math.max;
import static com.StardewValley.model.App.*;
import static com.StardewValley.model.weather.getEnergyLoser;

public class MilkPair extends  Tools{
    private final String names="MilkPair";
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
    public String getName(){
        return "MilkPair";
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
    @Override
    public int energyCost() {
        return (int) ((4) * getEnergyLoser());
    }
    public Store getStore(){
        return new MarineRanchStore();
    }
    @Override
    public void useTool() {
        currentGame.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }
}
