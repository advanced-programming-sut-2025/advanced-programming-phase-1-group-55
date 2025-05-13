package model.Tool;

import model.Store.BlackSmithStore;
import model.Store.Store;

import static java.lang.Math.max;
import static model.App.*;

public class Scythe extends  Tools{
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
        return "Scythe";
    }

    @Override
    public int energyCost() {
        return 2;
    }
    public Store getStore(){
        return new BlackSmithStore();
    }
    @Override
    public void useTool() {
        currentGame.currentUser.setEnergy(max(currentGame.currentUser.getEnergy()-energyCost(),0));
    }
}
