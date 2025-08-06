package com.StardewValley.model.Item;


import com.badlogic.gdx.math.Rectangle;

import java.io.Serializable;

public class CollisionRect implements Serializable {
    float x, y;
    float width, height;
    public CollisionRect(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(float x, float y){
        this.x = x;
        this.y = y;
    }
    public void moveY(float y){
        this.y += y;
    }
    public void moveX(float x){
        this.x += x;
    }
    public Rectangle toRectangle() {
        return new Rectangle(x, y, width, height);
    }
    public boolean collidesWith(CollisionRect rect){
        return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height > rect.y;
    }
    public void updateCollisionRect(float x, float y){
        this.x = x;
        this.y = y;
    }
    public boolean isNear(CollisionRect rect1) {
        float dx = Math.max(0, Math.max(rect1.x - (this.x + this.width), this.x - (rect1.x + rect1.width)));
        float dy = Math.max(0, Math.max(rect1.y - (this.y + this.height), this.y - (rect1.y + rect1.height)));
        float distance = (float)Math.sqrt(dx * dx + dy * dy);
        return distance <= 70;
    }
    public boolean isInside(float x, float y){
        return x>this.getX()&&x<this.getX()+this.width&&y>this.getY()&&y<this.getY()+this.height;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

