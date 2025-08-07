package com.StardewValley.Common.model.Map;

import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Lake extends Place {
    private Sprite sprite;
    public Lake(CollisionRect collisionRect) {
        super(collisionRect);
        sprite = AssetManager.Lake.getSprite();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
