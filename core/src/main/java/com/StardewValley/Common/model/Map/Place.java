package com.StardewValley.Common.model.Map;

import com.StardewValley.Common.model.Item.CollisionRect;

public class Place {
   private CollisionRect collisionRect;

    public Place(CollisionRect collisionRect) {
      this.collisionRect = collisionRect;
    }

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }

}
