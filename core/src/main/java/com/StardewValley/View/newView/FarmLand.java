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
    private Sprite sprite;
    private Location location;

    public FarmLand(CollisionRect rect, Texture texture) {
        this.collisionRect = rect;
        this.isPlowed = false;
        this.sprite = new Sprite(texture);
        this.location = new Location((int) rect.getX(), (int) rect.getY());
    }

    public CollisionRect getCollisionRect() { return collisionRect; }
    public boolean isPlowed() { return isPlowed; }
    public void setPlowed(boolean plowed) { this.isPlowed = plowed; }
    public Sprite getSprite() { return sprite; }
    public Location getLocation() { return location; }
    public void setColor(Color color) { sprite.setColor(color); }

    public void draw() {
        sprite.setPosition(collisionRect.getX(), collisionRect.getY());
        sprite.draw(App.gameApp.getBatch());
    }
}
