package com.StardewValley.Common.model.Animal.Fishing;

import com.StardewValley.Common.model.App;

public class SmoothMovement implements FishMovementPattern {
    private int lastMove = 0;
    @Override
    public int getNextDeltaY() {
        int chance = App.getRand().nextInt(100);
        if (chance < 60) return lastMove;
        int[] moves = {-5, 0, 5};
        lastMove = moves[App.getRand().nextInt(3)];
        return lastMove;
    }
}

