package model.Tool;

import model.Store.BlackSmithStore;
import model.Store.MarineRanchStore;
import model.Store.Store;

import static java.lang.Math.max;
import static model.App.*;
import static model.weather.getEnergyLoser;

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
    public String getName(){
        return "shears";
    }

    @Override
    public int energyCost() {
        return 4;
    }
    @Override
    public void useTool() {
        currentGame.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
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
