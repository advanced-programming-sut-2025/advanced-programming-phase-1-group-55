package model.Tool;

import model.Map.Location;
import model.Map.MainLocation;
import model.Store.BlackSmithStore;
import model.Store.Store;

import static model.weather.*;

import static java.lang.Math.max;
import static model.App.*;

public class Hoe extends Tools {
    private final String names = "Hoe";

    public int getPriceToLevelUp() {
        if (level == 1) {
            return 2000;
        } else if (level == 2) {
            return 5000;
        } else if (level == 3) {
            return 10000;
        } else if (level == 4) {
            return 25000;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        if (level == 2) {
            return 2000;
        } else if (level == 3) {
            return 5000;
        } else if (level == 4) {
            return 10000;
        } else if (level == 5) {
            return 25000;
        }
        return 1000;
    }

    public String getName() {
        return "Hoe";
    }

    @Override
    public int energyCost() {
        return (int) ((6 - level) * getEnergyLoser());
    }

    public Store getStore() {
        return new BlackSmithStore();
    }

    @Override
    public void useTool() {

        currentGame.currentUser.decreaseEnergy(energyCost());
    }
}
