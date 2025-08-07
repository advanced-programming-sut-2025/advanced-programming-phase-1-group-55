package com.StardewValley.Common.model.Store;


import com.StardewValley.Common.model.Item.CollisionRect;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public abstract class Store {
    private final int openingTime;
    private final int closingTime;
    private Map<String, Product> productsOfStore=new HashMap<>();
    private final String DisplayName;
    private final Texture texture;
    private final CollisionRect collisionRect;


    public Store(int openingTime, int closingTime, Map<String,
            Product> productsOfStore, String displayName, Texture texture, CollisionRect collisionRect) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.productsOfStore = productsOfStore;
        DisplayName = displayName;
        this.texture = texture;
        this.collisionRect = collisionRect;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public Map<String, Product> getProductsOfStore() {
        return productsOfStore;
    }

    public void setProductsOfStore(Map<String, Product> productsOfStore) {
        this.productsOfStore = productsOfStore;
    }


    public String getDisplayName() {
        return DisplayName;
    }

    public Texture getTexture() {
        return texture;
    }

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }


}
