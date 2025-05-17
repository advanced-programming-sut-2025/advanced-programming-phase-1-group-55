package model.Store;

import enums.CraftingItemType;
import enums.Seasons;
import model.App;
import model.Item.Item;
import model.Item.ItemType;
import model.NPC.Npc;
import model.Result;
import model.Tool.BackPack;
import model.Tool.FishingPole;
import model.Tool.FishingPoleType;

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
        }}, "FishShop");
    }
    public Result purchase(int amount , Product product){
        BackPack backPack=App.currentGame.currentUser.getBackPack();
        if(product.getItem().getItemType().equals(ItemType.FISH_SMOKER_RECIPE)){
            //TODO ADD RECIPE
            //App.currentGame.currentUser.getBackPack().getLearnedCraftingRecipes().add(CraftingItemType.);
        } else if (product.getItem().getItemType().equals(ItemType.FIBERGLASS_ROD)) {
            backPack.getAvailableTools().remove("FishingPole");
            backPack.getAvailableTools().put("FishingPole",new FishingPole(FishingPoleType.FIBERGLASS_ROD));
        }else if (product.getItem().getItemType().equals(ItemType.BAMBOO_POLE)) {
            backPack.getAvailableTools().remove("FishingPole");
            backPack.getAvailableTools().put("FishingPole",new FishingPole(FishingPoleType.BAMBOO_ROD));
        }else if (product.getItem().getItemType().equals(ItemType.IRIDIUM_ROD)) {
            backPack.getAvailableTools().remove("FishingPole");
            backPack.getAvailableTools().put("FishingPole",new FishingPole(FishingPoleType.IRIDIUM_ROD));
        }else if (product.getItem().getItemType().equals(ItemType.TRAINING_ROD)) {
            backPack.getAvailableTools().remove("FishingPole");
            backPack.getAvailableTools().put("FishingPole",new FishingPole(FishingPoleType.TRAINING_ROD));
        }
        product.increaseDailySold(amount);
        App.currentGame.currentUser.increaseGold(-amount* product.getGoldCost());
        return new Result(true,"you upgraded your fishing pole successfully");
    }
}
