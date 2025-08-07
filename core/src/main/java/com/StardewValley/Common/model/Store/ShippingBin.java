package com.StardewValley.Common.model.Store;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ShippingBin {
    private CollisionRect collisionRect;
    private Sprite sprite;
    public ShippingBin(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
        sprite= AssetManager.ShippingBin.getSprite();
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
