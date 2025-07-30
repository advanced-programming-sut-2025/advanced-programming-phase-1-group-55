package com.StardewValley.model.Map;

import com.StardewValley.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

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
