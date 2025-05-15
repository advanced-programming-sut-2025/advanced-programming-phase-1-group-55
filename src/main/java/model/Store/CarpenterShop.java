package model.Store;

import enums.Seasons;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;


import java.time.LocalTime;
import java.util.HashMap;


public class CarpenterShop extends Store{
    public CarpenterShop() {
        super(LocalTime.of(9, 0),
                LocalTime.of(20, 0),
                new HashMap<>() {{
                    put("wood",new Product(new Item(ItemType.WOOD),100000,10,0,0, Seasons.special));
                    put("stone",new Product(new Item(ItemType.STONE),100000,20,0,0, Seasons.special));
                    put("barn",new Product(new Item(ItemType.BARN),1,6000,350,150, Seasons.special));
                    put("deluxe barn",new Product(new Item(ItemType.DELUXE_BARN),1,25000,550,300, Seasons.special));
                    put("coop",new Product(new Item(ItemType.COOP),1,4000,300,100, Seasons.special));
                    put("big coop",new Product(new Item(ItemType.BIG_COOP),1,10000,400,150, Seasons.special));
                    put("deluxe coop",new Product(new Item(ItemType.DELUXE_COOP),1,20000,500,200, Seasons.special));
                    put("big barn",new Product(new Item(ItemType.BIG_BARN),1,12000,450,200, Seasons.special));
                    put("well",new Product(new Item(ItemType.WELL),1,1000,0,75, Seasons.special));
                    put("shipping bin",new Product(new Item(ItemType.SHIPPING_BIN),100000,250,150,0, Seasons.special));
                }},
                new Npc("Robin"),
                "CarpenterShop");

    }
}



