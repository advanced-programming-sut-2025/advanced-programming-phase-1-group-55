package com.StardewValley.model.Map;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.Serializable;

public class GreenHouse extends Place implements Serializable {
    private Boolean isRepaired = false;
    private final int woodForGreenHouse = 500;
    private final int goldForGreenHouse = 1000;
    private int waterSupply;
    private transient Sprite sprite;
    private transient Sprite sprite_kharab = new Sprite(AssetManager.GreenHouse1.getTexture());
    private transient Sprite sprite_salem = new Sprite(AssetManager.GreenHouse.getTexture());

    public GreenHouse(CollisionRect collisionRect) {
        super(collisionRect);
        sprite = sprite_kharab;
    }

    public void setRepaired(Boolean repaired) {
        isRepaired = repaired;
    }

    public int getWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(int waterSupply) {
        this.waterSupply = waterSupply;
    }

    public Boolean getRepaired() {
        return isRepaired;
    }

    public int getWoodForGreenHouse() {
        return woodForGreenHouse;
    }

    public int getGoldForGreenHouse() {
        return goldForGreenHouse;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite_kharab() {
        return sprite_kharab;
    }

    public Sprite getSprite_salem() {
        return sprite_salem;
    }
}
