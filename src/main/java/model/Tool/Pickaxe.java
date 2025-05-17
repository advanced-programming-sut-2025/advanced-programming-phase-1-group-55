package model.Tool;

import model.Store.BlackSmithStore;
import model.Store.Store;

import static java.lang.Math.max;
import static model.App.currentGame;
import static model.weather.getEnergyLoser;

public class Pickaxe extends Tools {
    boolean usedSuccessfully = false;

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
        return "Pickaxe";
    }

    @Override
    public int energyCost() {
        int energy = 6 - level;
        if (!usedSuccessfully) {
            energy--;
        }
        //TO DO  AGAR MINING MAX BOOD ENERGY --;
        return max(energy, 0);
    }

    public Store getStore() {
        return new BlackSmithStore();
    }

    @Override
    public void useTool() {
        currentGame.currentUser.decreaseEnergy((int) (energyCost() * getEnergyLoser()));
    }

}
