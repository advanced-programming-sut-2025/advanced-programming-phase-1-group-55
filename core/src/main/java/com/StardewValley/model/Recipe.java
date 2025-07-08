package com.StardewValley.model;

import com.StardewValley.enums.CraftingItemType;


public class Recipe {
    private CraftingItemType craftingItemType;

    public Recipe(CraftingItemType craftingItemType) {
        this.craftingItemType = craftingItemType;
    }

    public CraftingItemType getCraftingItemType() {
        return craftingItemType;
    }

    public void setCraftingItemType(CraftingItemType craftingItemType) {
        this.craftingItemType = craftingItemType;
    }
}
