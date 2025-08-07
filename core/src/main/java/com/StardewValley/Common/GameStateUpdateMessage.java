package com.StardewValley.Common;

import com.StardewValley.Common.model.GameModel;

public class GameStateUpdateMessage implements Message {
    private GameModel state;

    public GameStateUpdateMessage(GameModel state) {
        this.state = state;
    }

    public GameModel getState() {
        return state;
    }
}
