package com.StardewValley.model.Animal.Fishing;

import com.StardewValley.model.App;

public class SinkerMovement implements FishMovementPattern {
    private int stayCounter = 0;
    @Override
    public int getNextDeltaY() {
        if (App.getRand().nextBoolean()) {
            stayCounter++;
            return 0;
        } else {
            int power = (stayCounter > 1) ? 10 : 5;
            stayCounter = 0;
            return power * -1;
        }
    }
}

