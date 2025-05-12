package model.Tool;

import enums.Store;

import static java.lang.Math.max;
import static model.App.mainUser;

public class Hoe extends  Tools{
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

    @Override
    public int getPrice() {
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

    public String getName(){
        return "Hoe";
    }

    @Override
    public int energyCost() {
        return 6-level;
    }
    public Store getStore(){
        return Store.Blacksmith;
    }
    @Override
    public void useTool() {
        mainUser.setEnergy(max(mainUser.getEnergy()-energyCost(),0));
    }
}
