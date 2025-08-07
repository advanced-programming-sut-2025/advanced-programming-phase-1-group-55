package com.StardewValley.Common.Messages;


import com.StardewValley.Common.enums.Direction;

import java.io.Serializable;

public class PlayerMoveRequest implements Serializable {
    private int userId;
    private Direction direction;

    public PlayerMoveRequest(int userId, Direction direction) {
        this.userId = userId;
        this.direction = direction;
    }

    public int getUserId() {
        return userId;
    }

    public Direction getDirection() {
        return direction;
    }
}
