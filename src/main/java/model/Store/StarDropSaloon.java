package model.Store;

import enums.Seasons;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class StarDropSaloon extends Store{
    public StarDropSaloon() {
        super(12, 24, new HashMap<>(){{
            put("beer", new Product(new Item(ItemType.BEER),
                    Integer.MAX_VALUE, 400, 0, 0, Seasons.special));
            put("salad", new Product(new Item(ItemType.SALAD),
                    Integer.MAX_VALUE, 220, 0, 0, Seasons.special));
            put("bread", new Product(new Item(ItemType.BREAD),
                    Integer.MAX_VALUE, 120, 0, 0, Seasons.special));
            put("spaghetti", new Product(new Item(ItemType.SPAGHETTI),
                    Integer.MAX_VALUE, 240, 0, 0, Seasons.special));
            put("pizza", new Product(new Item(ItemType.PIZZA),
                    Integer.MAX_VALUE, 600, 0, 0, Seasons.special));
            put("coffee", new Product(new Item(ItemType.COFFEE),
                    Integer.MAX_VALUE, 300, 0, 0, Seasons.special));
            put("hash browns recipe", new Product(new Item(ItemType.HASH_BROWNS_RECIPE),
                    1, 50, 0, 1, Seasons.special));
            put("omelet recipe", new Product(new Item(ItemType.OMELET_RECIPE),
                    1, 100, 0, 1, Seasons.special));
            put("pancakes recipe", new Product(new Item(ItemType.PANCAKES_RECIPE),
                    1, 100, 0, 1, Seasons.special));
            put("bread recipe", new Product(new Item(ItemType.BREAD_RECIPE),
                    1, 100, 0, 1, Seasons.special));
            put("tortilla recipe", new Product(new Item(ItemType.TORTILLA_RECIPE),
                    1, 100, 0, 1, Seasons.special));
            put("pizza recipe", new Product(new Item(ItemType.PIZZA_RECIPE),
                    1, 150, 0, 1, Seasons.special));
            put("maki roll recipe", new Product(new Item(ItemType.MAKI_ROLL_RECIPE),
                    1, 300, 0, 1, Seasons.special));
            put("triple shot espresso recipe", new Product(new Item(ItemType.TRIPLE_SHOT_ESPRESSO_RECIPE),
                    1, 5000, 0, 1, Seasons.special));
            put("cookie recipe", new Product(new Item(ItemType.COOKIE_RECIPE),
                    1, 300, 0, 1, Seasons.special));
        }}, new Npc("Gus"), "starDropSaloon");
    }
}