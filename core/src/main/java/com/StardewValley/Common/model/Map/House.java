package com.StardewValley.Common.model.Map;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class House extends Place {
    private Sprite sprite;

    public House(CollisionRect collisionRect) {
        super(collisionRect);
        sprite= AssetManager.House.getSprite();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
