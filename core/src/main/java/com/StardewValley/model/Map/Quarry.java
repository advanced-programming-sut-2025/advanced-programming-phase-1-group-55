package com.StardewValley.model.Map;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Item.CollisionRect;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.Serializable;

public class Quarry extends Place implements Serializable {
    private transient Sprite sprite;

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
