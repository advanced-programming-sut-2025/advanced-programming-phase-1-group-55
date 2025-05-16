package model.Store;

import enums.Seasons;
import model.App;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;
import model.Result;
import model.Tool.BackPack;

import java.time.LocalTime;
import java.util.HashMap;

public class GeneralStore extends Store {

    public GeneralStore() {
        super(9, 17, new HashMap<>(){{
            put("large pack", new Product(new Item(ItemType.LARGE_PACK),
                    1, 2000, 0, 1, Seasons.special));
            put("deluxe pack", new Product(new Item(ItemType.DELUXE_PACK),
                    1, 10000, 0, 1, Seasons.special));

            // Spring
            put("parsnip seeds", new Product(new Item(ItemType.PARSNIP_SEEDS),
                    5, 20, 0, 5, Seasons.spring));
            put("bean starter", new Product(new Item(ItemType.BEAN_STARTER),
                    5, 60, 0, 5, Seasons.spring));
            put("cauliflower seeds", new Product(new Item(ItemType.CAULIFLOWER_SEEDS),
                    5, 80, 0, 5, Seasons.spring));
            put("potato seeds", new Product(new Item(ItemType.POTATO_SEEDS),
                    5, 50, 0, 5, Seasons.spring));
            put("tulip bulb", new Product(new Item(ItemType.TULIP_BULB),
                    5, 20, 0, 5, Seasons.spring));
            put("kale seeds", new Product(new Item(ItemType.KALE_SEEDS),
                    5, 70, 0, 5, Seasons.spring));
            put("jazz seeds", new Product(new Item(ItemType.JAZZ_SEEDS),
                    5, 30, 0, 5, Seasons.spring));
            put("garlic seeds", new Product(new Item(ItemType.GARLIC_SEEDS),
                    5, 40, 0, 5, Seasons.spring));
            put("rice shoot", new Product(new Item(ItemType.RICE_SHOOT),
                    5, 40, 0, 5, Seasons.spring));

            // Summer
            put("melon seeds", new Product(new Item(ItemType.MELON_SEEDS),
                    5, 80, 0, 5, Seasons.summer));
            put("tomato seeds", new Product(new Item(ItemType.TOMATO_SEEDS),
                    5, 50, 0, 5, Seasons.summer));
            put("blueberry seeds", new Product(new Item(ItemType.BLUEBERRY_SEEDS),
                    5, 80, 0, 5, Seasons.summer));
            put("pepper seeds", new Product(new Item(ItemType.PEPPER_SEEDS),
                    5, 40, 0, 5, Seasons.summer));
            put("wheat seeds", new Product(new Item(ItemType.WHEAT_SEEDS),
                    5, 10, 0, 5, Seasons.summer));
            put("radish seeds", new Product(new Item(ItemType.RADISH_SEEDS),
                    5, 40, 0, 5, Seasons.summer));
            put("poppy seeds", new Product(new Item(ItemType.POPPY_SEEDS),
                    5, 100, 0, 5, Seasons.summer));
            put("spangle seeds", new Product(new Item(ItemType.SPANGLE_SEEDS),
                    5, 50, 0, 5, Seasons.summer));
            put("hops starter", new Product(new Item(ItemType.HOPS_STARTER),
                    5, 60, 0, 5, Seasons.summer));
            put("corn seeds", new Product(new Item(ItemType.CORN_SEEDS),
                    5, 150, 0, 5, Seasons.summer));
            put("sunflower seeds", new Product(new Item(ItemType.SUNFLOWER_SEEDS),
                    5, 200, 0, 5, Seasons.summer));
            put("red cabbage seeds", new Product(new Item(ItemType.RED_CABBAGE_SEEDS),
                    5, 100, 0, 5, Seasons.summer));

            // Fall
            put("eggplant seeds", new Product(new Item(ItemType.EGGPLANT_SEEDS),
                    5, 20, 0, 5, Seasons.fall));

            put("pumpkin seeds", new Product(new Item(ItemType.PUMPKIN_SEEDS),
                    5, 100, 0, 5, Seasons.fall));
            put("bok choy seeds", new Product(new Item(ItemType.BOK_CHOY_SEEDS),
                    5, 50, 0, 5, Seasons.fall));
            put("yam seeds", new Product(new Item(ItemType.YAM_SEEDS),
                    5, 60, 0, 5, Seasons.fall));
            put("cranberry seeds", new Product(new Item(ItemType.CRANBERRY_SEEDS),
                    5, 240, 0, 5, Seasons.fall));
            put("fairy seeds", new Product(new Item(ItemType.FAIRY_SEEDS),
                    5, 200, 0, 5, Seasons.fall));
            put("amaranth seeds", new Product(new Item(ItemType.AMARANTH_SEEDS),
                    5, 70, 0, 5, Seasons.fall));
            put("grape starter", new Product(new Item(ItemType.GRAPE_STARTER),
                    5, 60, 0, 5, Seasons.fall));
            put("artichoke seeds", new Product(new Item(ItemType.ARTICHOKE_SEEDS),
                    5, 30, 0, 5, Seasons.fall));

            put("rice", new Product(new Item(ItemType.RICE),
                    Integer.MAX_VALUE, 200, 0, 0, Seasons.special));
            put("wheat flour", new Product(new Item(ItemType.WHEAT_FLOUR),
                    Integer.MAX_VALUE, 100, 0, 0, Seasons.special));
            put("bouquet", new Product(new Item(ItemType.BOUQUET),
                    2, 1000, 0, 0, Seasons.special));
            put("wedding ring", new Product(new Item(ItemType.WEDDING_RING),
                    2, 10000, 0, 0, Seasons.special));
            put("dehydrator (recipe)", new Product(new Item(ItemType.DEHYDRATOR_RECIPE),
                    1, 10000, 0, 1, Seasons.special));
            put("grass starter (recipe)", new Product(new Item(ItemType.GRASS_STARTER_RECIPE),
                    1, 1000, 0, 1, Seasons.special));
            put("sugar", new Product(new Item(ItemType.SUGAR),
                    Integer.MAX_VALUE, 100, 0, 0, Seasons.special));
            put("oil", new Product(new Item(ItemType.OIL),
                    Integer.MAX_VALUE, 200, 0, 0, Seasons.special));
            put("vinegar", new Product(new Item(ItemType.VINEGAR),
                    Integer.MAX_VALUE, 200, 0, 0, Seasons.special));
            put("deluxe retaining soil", new Product(new Item(ItemType.DELUXE_RETAINING_SOIL),
                    Integer.MAX_VALUE, 150, 0, 0, Seasons.special));
            put("grass starter", new Product(new Item(ItemType.GRASS_STARTER),
                    Integer.MAX_VALUE, 100, 0, 0, Seasons.special));
            put("speed-gro", new Product(new Item(ItemType.SPEED_GRO),
                    Integer.MAX_VALUE, 100, 0, 0, Seasons.special));
            put("apple sapling", new Product(new Item(ItemType.APPLE_SAPLING),
                    Integer.MAX_VALUE, 4000, 0, 0, Seasons.special));
            put("apricot sapling", new Product(new Item(ItemType.APRICOT_SAPLING),
                    Integer.MAX_VALUE, 2000, 0, 0, Seasons.special));
            put("cherry sapling", new Product(new Item(ItemType.CHERRY_SAPLING),
                    Integer.MAX_VALUE, 3400, 0, 0, Seasons.special));
            put("orange sapling", new Product(new Item(ItemType.ORANGE_SAPLING),
                    Integer.MAX_VALUE, 4000, 0, 0, Seasons.special));
            put("peach sapling", new Product(new Item(ItemType.PEACH_SAPLING),
                    Integer.MAX_VALUE, 6000, 0, 0, Seasons.special));
            put("pomegranate sapling", new Product(new Item(ItemType.POMEGRANATE_SAPLING),
                    Integer.MAX_VALUE, 6000, 0, 0, Seasons.special));
            put("basic retaining soil", new Product(new Item(ItemType.BASIC_RETAINING_SOIL),
                    Integer.MAX_VALUE, 100, 0, 0, Seasons.special));
            put("quality retaining soil", new Product(new Item(ItemType.QUALITY_RETAINING_SOIL),
                    Integer.MAX_VALUE, 150, 0, 0, Seasons.special));
        }}, new Npc("Pierre"), "Generalstore");
    }
    public Result purchase(int amount , Product product){
       BackPack backPack= App.currentGame.currentUser.getBackPack();
         if(product.getItem().getItemType().equals(ItemType.LARGE_PACK)){
             if(backPack.getLevel()==2){
                 return new Result(false,"you already owned this item");
             }
             backPack.setLevel(2);
             product.increaseDailySold(1);
             App.currentGame.currentUser.increaseGold(-amount* product.getGoldCost());
         } else if (product.getItem().getItemType().equals(ItemType.DELUXE_PACK)) {
             if(backPack.getLevel()==3){
                 return new Result(false,"you already owned this item");
             }
             backPack.setLevel(3);
             product.increaseDailySold(1);
             App.currentGame.currentUser.increaseGold(-amount* product.getGoldCost());
         }else {
             Result x=backPack.addItemToInventory(product.getItem(),amount);
             if (x.IsSuccess()){
                 product.increaseDailySold(1);
             }
             return x;
         }
         return new Result(true,"you upgraded your backPack successfully");
    }
}

