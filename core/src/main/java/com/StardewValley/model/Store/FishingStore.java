package com.StardewValley.model.Store;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.enums.Seasons;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Result;
import com.StardewValley.model.Tool.BackPack;
import com.StardewValley.model.Tool.FishingPole;
import com.StardewValley.model.Tool.FishingPoleType;

import java.util.HashMap;

public class FishingStore extends Store{
    public FishingStore() {
        super(9, 17, new HashMap<>(){{
            put("fish smoker recipe", new Product(new Item(ItemType.FISH_SMOKER_RECIPE),
                    1, 10000, 0, 0, Seasons.special));
            put("trout soup", new Product(new Item(ItemType.TROUT_SOUP),
                    1, 250, 0, 0, Seasons.special));
            put("bamboo pole", new Product(new Item(ItemType.BAMBOO_POLE),
                    1, 500, 0, 0, Seasons.special));
            put("training rod", new Product(new Item(ItemType.TRAINING_ROD),
                    1, 25, 0, 0, Seasons.special));
            put("fiberglass rod", new Product(new Item(ItemType.FIBERGLASS_ROD),
                    1, 1800, 0, 0, Seasons.special));
            put("iridium rod", new Product(new Item(ItemType.IRIDIUM_ROD),
                    1, 7500, 0, 0, Seasons.special));
        }}, "FishShop", AssetManager.FISHING_STORE.getTexture(), new CollisionRect(-394, -756
            ,AssetManager.FISHING_STORE.getTexture().getWidth(), AssetManager.FISHING_STORE.getTexture().getHeight()));
    }
    @Override
    public void Purchase(Product product, int amount) {

    }
}
