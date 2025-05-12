package model.Tool;

import enums.Store;

import static java.lang.Math.max;
import static model.App.*;

public class MilkPair extends  Tools{
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
        return 4;
    }
    public Store getStore(){
        return Store.marnieRanch;
    }
    @Override
    public void useTool() {
        currentGame.currentUser.setEnergy(max(currentGame.currentUser.getEnergy()-energyCost(),0));
    }
}
