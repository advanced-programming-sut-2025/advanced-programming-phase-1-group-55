package com.StardewValley.model.Map;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.Serializable;

public class Lake extends Place implements Serializable {
    private transient Sprite sprite;
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
