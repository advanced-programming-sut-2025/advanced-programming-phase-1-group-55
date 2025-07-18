package com.StardewValley.model.Map;

import com.StardewValley.model.Item.CollisionRect;

public class Fence {
    FenceType fenceType;
    CollisionRect collisionRect;

    public Fence(FenceType fenceType, CollisionRect collisionRect) {
        this.fenceType = fenceType;
        this.collisionRect = collisionRect;
    }

    public FenceType getFenceType() {
        return fenceType;
    }

    public void setFenceType(FenceType fenceType) {
        this.fenceType = fenceType;
    }

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }
}
