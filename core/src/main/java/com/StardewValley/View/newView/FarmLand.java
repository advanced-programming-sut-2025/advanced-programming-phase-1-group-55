package com.StardewValley.View.newView;

import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Map.Location;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.StardewValley.model.App;

public class FarmLand {
    private CollisionRect collisionRect;
    private boolean isPlowed;
    private boolean isFertilized;
    private boolean isWatered;
    private boolean isPlanted;
    private Sprite sprite;
    private Location location;

    public FarmLand(CollisionRect rect, Texture texture) {
        this.collisionRect = rect;
        this.isPlowed = false;
        this.isFertilized = false;
        this.isWatered = false;
        this.isPlanted = false;
        this.sprite = new Sprite(texture);
        this.location = new Location((int) rect.getX(), (int) rect.getY());
    }

    public CollisionRect getCollisionRect() { return collisionRect; }
    public boolean isPlowed() { return isPlowed; }
    public void setPlowed(boolean plowed) { this.isPlowed = plowed; }
    public Sprite getSprite() { return sprite; }
    public Location getLocation() { return location; }
    public void setColor(Color color) { sprite.setColor(color); }

    public boolean isWatered() {
        return isWatered;
    }

    public void setWatered(boolean watered) {
        isWatered = watered;
    }

    public boolean isFertilized() {
        return isFertilized;
    }

    public void setFertilized(boolean fertilized) {
        isFertilized = fertilized;
    }

    public boolean isPlanted() {
        return isPlanted;
    }

    public void setPlanted(boolean planted) {
        isPlanted = planted;
    }

    public void draw() {
        sprite.setPosition(collisionRect.getX(), collisionRect.getY());
        sprite.draw(App.gameApp.getBatch());
    }
}
