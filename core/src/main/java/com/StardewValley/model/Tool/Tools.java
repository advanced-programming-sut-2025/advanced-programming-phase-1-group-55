package com.StardewValley.model.Tool;


import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.Serializable;
import java.nio.channels.spi.SelectorProvider;

public abstract class Tools implements Serializable {
    protected int level = 0;

    protected String name;

    public abstract Sprite getSprite();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void increaseLevel(int amount) {
        level += amount;
    }

    public String getName() {
        return null;
    }

    public void useTool() {


    }


    public void setName(String name) {
        this.name = name;
    }

    public int energyCost() {
        return 0;
    }

    public int getPriceToLevelUp() {
        return 400;
    }

    public int getPrice() {
        return 0;
    }
}
