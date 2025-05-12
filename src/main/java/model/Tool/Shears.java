package model.Tool;

import enums.Store;
import model.App;

import static java.lang.Math.max;
import static model.App.*;

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
        return Store.marnieRanch;
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
        currentGame.currentUser.setEnergy(max(currentGame.currentUser.getEnergy()-energyCost(),0));
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
