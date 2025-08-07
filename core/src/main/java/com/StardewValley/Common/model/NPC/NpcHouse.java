package com.StardewValley.Common.model.NPC;

import com.StardewValley.Common.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class NpcHouse {
    private CollisionRect collisionRect;
    private Sprite sprite;

    public NpcHouse(CollisionRect collisionRect, Sprite sprite) {
        this.collisionRect = collisionRect;
        this.sprite = sprite;
    }

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
