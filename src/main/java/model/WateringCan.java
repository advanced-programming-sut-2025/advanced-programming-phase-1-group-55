package model;

import enums.Store;

public class WateringCan extends Tools {
    private final Store store=Store.Blacksmith;
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
    public Store getStore() {
        return store;
    }
    public String getName() {
        return "WateringCan";
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
}
