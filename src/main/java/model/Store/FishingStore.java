package model.Store;

import enums.Seasons;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;

import java.time.LocalTime;
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
        }}, new Npc("Willy"), "FishShop");
    }
}
