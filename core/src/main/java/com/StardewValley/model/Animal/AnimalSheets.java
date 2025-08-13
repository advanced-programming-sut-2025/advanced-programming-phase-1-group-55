package com.StardewValley.model.Animal;

import com.StardewValley.enums.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public final class AnimalSheets {
    private AnimalSheets() {}

    public static final class SheetSpec {
        public final Texture texture;
        public final int cols, rows;
        public final float frameDuration;
        public SheetSpec(Texture t, int c, int r, float d) {
            this.texture = t; this.cols = c; this.rows = r; this.frameDuration = d;
        }
    }
    public static SheetSpec forType(FarmAnimalType t) {
        switch (t) {
            case SHEEP:    return new SheetSpec(AssetManager.SHEEP_SHEET.getTexture(),     4, 5, 0.12f);
            case COW:      return new SheetSpec(AssetManager.COW_SHEET.getTexture(),       4, 5, 0.12f);
            case GOAT:     return new SheetSpec(AssetManager.GOAT_SHEET.getTexture(),      4, 5, 0.12f);
            case PIG:      return new SheetSpec(AssetManager.PIG_SHEET.getTexture(),       4, 5, 0.12f);
            case CHICKEN:  return new SheetSpec(AssetManager.CHICKEN_SHEET.getTexture(),   4, 5, 0.10f);
            case DUCK:     return new SheetSpec(AssetManager.DUCK_SHEET.getTexture(),      4, 5, 0.10f);
            case RABBIT:   return new SheetSpec(AssetManager.RABBIT_SHEET.getTexture(),    4, 5, 0.10f);
            case DINOSAUR: return new SheetSpec(AssetManager.DINOSAUR_SHEET.getTexture(),  4, 5, 0.10f);
            default:       return null;
        }
    }
}

