package model.Tool;

import static java.lang.Math.max;
import static model.App.*;
import static model.weather.getEnergyLoser;

public class Trashcan extends Tools{

    public String getName() {
        return "Trashcan";
    }

    @Override
    public void useTool() {
        currentGame.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }

    @Override
    public int energyCost() {
        return 0;
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
       return (double) ((level + 1) * 15) /100;
    }

    public void setRatio(double ratio) {
    }
}
