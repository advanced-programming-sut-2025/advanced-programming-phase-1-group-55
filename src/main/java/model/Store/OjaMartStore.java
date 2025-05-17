package model.Store;

import enums.Seasons;
import model.App;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;
import model.Result;

import java.time.LocalTime;
import java.util.HashMap;

public class OjaMartStore extends Store{

    public OjaMartStore() {
        super(9, 23, new HashMap<>(){{
           put("joja cola",new Product(new Item(ItemType.JOJA_COLA),
                   10000,75,0,0, Seasons.special));
            put("ancient seed",new Product(new Item(ItemType.ANCIENT_SEED),
                    1,500,0,0, Seasons.special));
            put("Grass Starter",new Product(new Item(ItemType.GRASS_STARTER),
                    10000,125,0,0, Seasons.special));
            put("sugar",new Product(new Item(ItemType.SUGAR),
                    10000,125,0,0, Seasons.special));
            put("wheat flour",new Product(new Item(ItemType.WHEAT_FLOUR),
                    10000,125,0,0, Seasons.special));
            put("rice",new Product(new Item(ItemType.RICE),
                    10000,250,0,0, Seasons.special));
            put("parsnip seeds", new Product(new Item(ItemType.PARSNIP_SEEDS),
                    5, 25, 0, 0, Seasons.spring));

            put("bean starter", new Product(new Item(ItemType.BEAN_STARTER),
                    5, 75, 0, 0, Seasons.spring));

            put("cauliflower seeds", new Product(new Item(ItemType.CAULIFLOWER_SEEDS),
                    5, 100, 0, 0, Seasons.spring));

            put("potato seeds", new Product(new Item(ItemType.POTATO_SEEDS),
                    5, 62, 0, 0, Seasons.spring));

            put("strawberry seeds", new Product(new Item(ItemType.STRAWBERRY_SEEDS),
                    5, 100, 0, 0, Seasons.spring));

            put("tulip bulb", new Product(new Item(ItemType.TULIP_BULB),
                    5, 25, 0, 0, Seasons.spring));

            put("kale seeds", new Product(new Item(ItemType.KALE_SEEDS),
                    5, 87, 0, 0, Seasons.spring));

            put("coffee beans", new Product(new Item(ItemType.COFFEE_BEANS),
                    1, 200, 0, 0, Seasons.spring));

            put("carrot seeds", new Product(new Item(ItemType.CARROT_SEEDS),
                    10, 5, 0, 0, Seasons.spring));

            put("rhubarb seeds", new Product(new Item(ItemType.RHUBARB_SEEDS),
                    5, 100, 0, 0, Seasons.spring));

            put("jazz seeds", new Product(new Item(ItemType.JAZZ_SEEDS),
                    5, 37, 0, 0, Seasons.spring));
            put("tomato seeds", new Product(new Item(ItemType.TOMATO_SEEDS),
                    5, 62, 0, 0, Seasons.summer));

            put("pepper seeds", new Product(new Item(ItemType.PEPPER_SEEDS),
                    5, 50, 0, 0, Seasons.summer));

            put("wheat seeds", new Product(new Item(ItemType.WHEAT_SEEDS),
                    10, 12, 0, 0, Seasons.summer));

            put("summer squash seeds", new Product(new Item(ItemType.SUMMER_SQUASH_SEEDS),
                    10, 10, 0, 0, Seasons.summer));

            put("radish seeds", new Product(new Item(ItemType.RADISH_SEEDS),
                    5, 50, 0, 0, Seasons.summer));

            put("melon seeds", new Product(new Item(ItemType.MELON_SEEDS),
                    5, 100, 0, 0, Seasons.summer));

            put("hops starter", new Product(new Item(ItemType.HOPS_STARTER),
                    5, 75, 0, 0, Seasons.summer));

            put("poppy seeds", new Product(new Item(ItemType.POPPY_SEEDS),
                    5, 125, 0, 0, Seasons.summer));

            put("spangle seeds", new Product(new Item(ItemType.SPANGLE_SEEDS),
                    5, 62, 0, 0, Seasons.summer));

            put("starfruit seeds", new Product(new Item(ItemType.STARFRUIT_SEEDS),
                    5, 400, 0, 0, Seasons.summer));

            put("sunflower seeds", new Product(new Item(ItemType.SUNFLOWER_SEEDS),
                    5, 125, 0, 0, Seasons.summer));
            put("corn seeds", new Product(new Item(ItemType.CORN_SEEDS),
                    5, 187, 0, 0, Seasons.fall));

            put("eggplant seeds", new Product(new Item(ItemType.EGGPLANT_SEEDS),
                    5, 25, 0, 0, Seasons.fall));

            put("pumpkin seeds", new Product(new Item(ItemType.PUMPKIN_SEEDS),
                    5, 125, 0, 0, Seasons.fall));

            put("broccoli seeds", new Product(new Item(ItemType.BROCCOLI_SEEDS),
                    5, 15, 0, 0, Seasons.fall));

            put("amaranth seeds", new Product(new Item(ItemType.AMARANTH_SEEDS),
                    5, 87, 0, 0, Seasons.fall));

            put("grape starter", new Product(new Item(ItemType.GRAPE_STARTER),
                    5, 75, 0, 0, Seasons.fall));

            put("beet seeds", new Product(new Item(ItemType.BEET_SEEDS),
                    5, 20, 0, 0, Seasons.fall));

            put("yam seeds", new Product(new Item(ItemType.YAM_SEEDS),
                    5, 75, 0, 0, Seasons.fall));

            put("bok choy seeds", new Product(new Item(ItemType.BOK_CHOY_SEEDS),
                    5, 62, 0, 0, Seasons.fall));

            put("cranberry seeds", new Product(new Item(ItemType.CRANBERRY_SEEDS),
                    5, 300, 0, 0, Seasons.fall));

            put("fairy seeds", new Product(new Item(ItemType.FAIRY_SEEDS),
                    5, 250, 0, 0, Seasons.fall));

            put("rare seed", new Product(new Item(ItemType.RARE_SEED),
                    1, 1000, 0, 0, Seasons.fall));
            put("powdermelon seeds", new Product(new Item(ItemType.POWDERMELON_SEEDS),
                    10, 20, 0, 0, Seasons.winter));


        }}, "OjaMart");
    }
    public Result purchase(int amount , Product product){
      Result x=App.currentGame.currentUser.getBackPack().addItemToInventory(product.getItem(),amount);
      if (x.IsSuccess()){
         product.increaseDailySold(amount);
      }
      return x;
    }
}

