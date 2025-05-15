package model.Store;

import enums.Seasons;
import model.App;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;
import model.Result;
import model.Tool.BackPack;
import model.Tool.MilkPair;
import model.Tool.Shears;

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
    public Result purchase(int amount , Product product){
        BackPack backPack= App.currentGame.currentUser.getBackPack();
       if(product.getItem().getItemType().equals(ItemType.SHEARS)){
           if(backPack.getAvailableTools().containsKey("Shears")){
               return  new Result(false,"you have already owned this item");
           }
           backPack.getAvailableTools().put("Shears",new Shears());
       } else if (product.getItem().getItemType().equals(ItemType.MILK_PAIR)) {
           if(backPack.getAvailableTools().containsKey("MilkPair")){
               return  new Result(false,"you have already owned this item");
           }
           backPack.getAvailableTools().put("MilkPair",new MilkPair());
       }else if (product.getItem().getItemType().equals("g")){
           //todo  animals
       }else{
           Result x=backPack.addItemToInventory(product.getItem(),amount);
           if (x.IsSuccess()){
               product.increaseDailySold(amount);
           }
           return x;
        }
        product.increaseDailySold(1);
        App.currentGame.currentUser.increaseGold(-amount* product.getGoldCost());
        return new Result(true,"you successfully purchased :"+product.getItem().getItemType().getDisplayName());
    }
}
