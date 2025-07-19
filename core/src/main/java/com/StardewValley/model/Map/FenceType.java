package com.StardewValley.model.Map;

import com.StardewValley.model.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public enum FenceType {
    door(AssetManager.GATE.getTexture())
    ,wood(AssetManager.WOOD_FENCE.getTexture())
    ,stone(AssetManager.STONE_FENCE.getTexture()),
    iron(AssetManager.IRON_FENCE.getTexture());
    private final Texture texture;
    FenceType(Texture texture) {
        this.texture = texture;
    }
    public Texture getTexture() {
        return texture;
    }
}
