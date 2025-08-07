package com.StardewValley.model.Animal.Fishing;

import com.StardewValley.model.App;

public class DartMovement implements FishMovementPattern {
    @Override
    public int getNextDeltaY() {
        int[] moves = {-9, 0, 9};
        return moves[App.getRand().nextInt(3)];
    }
}
