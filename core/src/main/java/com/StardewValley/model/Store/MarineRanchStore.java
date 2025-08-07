package com.StardewValley.model.Store;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.enums.Seasons;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Result;
import com.StardewValley.model.Tool.BackPack;
import com.StardewValley.model.Tool.MilkPail;
import com.StardewValley.model.Tool.Shears;

import java.util.HashMap;

public class MarineRanchStore extends Store{
    public MarineRanchStore() {
        super(9, 16, new HashMap<>(){{
            put("hay", new Product(new Item(ItemType.HAY),
                    10000, 50, 0, 0, Seasons.special));

            put("milk pail", new Product(new Item(ItemType.MILK_PAIR),
                    1, 1000, 0, 0, Seasons.special));

            put("shears", new Product(new Item(ItemType.SHEARS),
                    1, 1000, 0, 0, Seasons.special));
            put("chicken", new Product(new Item(ItemType.CHICKEN),
                    1, 800, 0, 0, Seasons.special));

            put("cow", new Product(new Item(ItemType.COW),
                    1, 1500, 0, 0, Seasons.special));

            put("goat", new Product(new Item(ItemType.GOAT),
                    1, 4000, 0, 0, Seasons.special));

            put("duck", new Product(new Item(ItemType.DUCK),
                    1, 1200, 0, 0, Seasons.special));

            put("sheep", new Product(new Item(ItemType.SHEEP),
                    1, 8000, 0, 0, Seasons.special));

            put("rabbit", new Product(new Item(ItemType.RABBIT),
                    1, 8000, 0, 0, Seasons.special));

            put("dinosaur", new Product(new Item(ItemType.DINOSAUR),
                    1, 14000, 0, 0, Seasons.special));

            put("pig", new Product(new Item(ItemType.PIG),
                    1, 16000, 0, 0, Seasons.special));


        }}, "marnieRanch", AssetManager.MARINE_RANCH_STORE.getTexture(), new CollisionRect(-394, -254,
            AssetManager.GENERAL_STORE.getTexture().getWidth(), AssetManager.GENERAL_STORE.getTexture().getHeight()));
    }

}
