package com.StardewValley.model.Map;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class House extends Place {
    private Sprite sprite;

    public House(CollisionRect collisionRect) {
        super(collisionRect);
        sprite= AssetManager.GreenHouse.getSprite();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
