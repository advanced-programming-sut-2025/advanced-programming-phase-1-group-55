package com.StardewValley.Common.model.Animal.Fishing;

import com.StardewValley.Common.model.App;

public class FloaterMovement implements FishMovementPattern {
    private int stayCounter = 0;
    @Override
    public int getNextDeltaY() {
        if (App.getRand().nextBoolean()) {
            stayCounter++;
            return 0;
        } else {
            int power = (stayCounter > 1) ? 10 : 5;
            stayCounter = 0;
            return power;
        }
    }
}
