package model.Tool;

import model.Store.BlackSmithStore;
import model.Store.Store;

import static java.lang.Math.max;
import static model.App.*;
import static model.weather.getEnergyLoser;

public class WateringCan extends Tools {
    private int capacityUsed=0;
    public int getCapacity(){
        if (level==1){
            return 40;
        }else if(level==2){
            return 55;
        }else if(level==3){
            return 70;
        }else if(level==4){
            return 85;
        }else if(level==5){
            return 100;
        }
        return 0;
    }
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

    public String getName() {
        return "WateringCan";
    }

    @Override
    public void useTool() {
        currentGame.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }

    public int getPrimaryEnergyCost() {
        return 5;
    }

    public int getCapacityUsed() {
        return capacityUsed;
    }

    public void setCapacityUsed(int capacityUsed) {
        this.capacityUsed = capacityUsed;
    }
    @Override
    public int energyCost() {
        int energy=6-level;
        //TO DO  AGAR FARMING MAX BOOD ENERGY --;
        return max(energy,0);
    }
    public int getAreaToSplashWater(){
        if(level==1){
            return 40;
        } else if (level==2) {
            return 55;
        } else if (level==3) {
            return 70;
        } else if (level==4) {
            return 85;
        } else if (level==5) {
            return 100;
        }
        return 0;
    }
    public Store getStore(){
        return new BlackSmithStore();
    }
}
