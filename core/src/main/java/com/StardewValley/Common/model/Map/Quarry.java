package com.StardewValley.Common.model.Map;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Quarry extends Place {
    private Sprite sprite;
    public Quarry(CollisionRect collisionRect) {
        super(collisionRect);
        sprite = AssetManager.Quarry.getSprite();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
