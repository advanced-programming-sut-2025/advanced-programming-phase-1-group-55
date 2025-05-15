package model.Store;

import enums.Seasons;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;

import java.time.LocalTime;
import java.util.HashMap;

public class BlackSmithStore extends Store {

    public BlackSmithStore() {
        super(9, 16,
                new HashMap<>(){{
                    put("cooper ore",new Product(new Item(ItemType.COPPER_ORE),
                            100000,75,0,0, Seasons.special));
                    put("iron ore",new Product(new Item(ItemType.IRON_ORE),
                            100000,150,0,0, Seasons.special));
                    put("gold ore",new Product(new Item(ItemType.GOLD_ORE),
                            100000,400,0,0, Seasons.special));
                    put("coal",new Product(new Item(ItemType.COAL),
                            100000,150,0,0, Seasons.special));
                    put("cooper tool",new Product(new Item(ItemType.COPPER_TOOL),
                            100000,2000,0,0, Seasons.special));
                    put("steel tool",new Product(new Item(ItemType.STEEL_TOOL),
                            100000,5000,0,0, Seasons.special));
                    put("gold tool",new Product(new Item(ItemType.GOLD_TOOL),
                            100000,10000,0,0, Seasons.special));
                    put("iridium tool",new Product(new Item(ItemType.IRIDIUM_TOOL),
                            100000,25000,0,0, Seasons.special));
                    put("cooper trashcan",new Product(new Item(ItemType.COOPER_TRASHCAN),
                            100000,1000,0,0, Seasons.special));
                    put("iron trashcan",new Product(new Item(ItemType.STEEL_TRASHCAN),
                            100000,2500,0,0, Seasons.special));
                    put("gold trashcan",new Product(new Item(ItemType.GOLD_TRASHCAN),
                            100000,5000,0,0, Seasons.special));
                    put("iridium trashcan",new Product(new Item(ItemType.IRIDIUM_TRASHCAN),
                            100000,12500,0,0, Seasons.special));
                }}, new Npc("Clint"), "Blacksmith");
    }
}
