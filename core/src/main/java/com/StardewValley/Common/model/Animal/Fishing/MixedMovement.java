package com.StardewValley.Common.model.Animal.Fishing;

import com.StardewValley.Common.model.App;

public class MixedMovement implements FishMovementPattern {
    @Override
    public int getNextDeltaY() {
        int[] moves = {-5, 0, 5};
        return moves[App.getRand().nextInt(3)];
    }
}
