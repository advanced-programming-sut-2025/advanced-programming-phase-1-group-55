package model.Store;

import enums.Seasons;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;

import java.time.LocalTime;
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


        }}, new Npc("Marnie"), "marnieRanch");
    }
}
