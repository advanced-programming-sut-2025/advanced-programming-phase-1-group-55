//package Controller;
//
//import enums.CraftingItemType;
//import model.App;
//import model.Artisan.ArtisanGood;
//import model.Artisan.ArtisanGoodsType;
//import model.Item.ItemType;
//import model.Result;
//import model.User;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ArtisanGoodController {
//    public Result artisanUse(String artisanName, List<String> itemNames) {
//        User user = App.currentGame.currentUser;
//
//
//        ArtisanGoodsType artisanType = null;
//        for (ArtisanGoodsType agt : ArtisanGoodsType.values()) {
//            if (agt.name().equalsIgnoreCase(artisanName)) {
//                artisanType = agt;
//                break;
//            }
//        }
//        if (artisanType == null) {
//            return new Result(false, "Artisan device not found");
//        }
//
//        // 2. بررسی اینکه مواد اولیه کافی وارد شده (مقایسه با ingredients)
//        HashMap<ItemType, Integer> requiredIngredients = artisanType.getIngredients();
//        if (requiredIngredients == null || requiredIngredients.isEmpty()) {
//            if (!itemNames.isEmpty()) {
//                return new Result(false, " does not require any ingredients");
//            }
//        } else {
//            HashMap<ItemType, Integer> providedIngredients = new HashMap<>();
//            for (String itemName : itemNames) {
//                ItemType type = ItemType.getItemTypeFromName(itemName);
//                if (type == null) {
//                    return new Result(false, "Ingredient '" + itemName + "' not found");
//                }
//                providedIngredients.put(type, providedIngredients.getOrDefault(type, 0) + 1);
//            }
//
//
//            if (!providedIngredients.equals(requiredIngredients)) {
//                return new Result(false, "Provided ingredients do not match required ingredients for this artisan device");
//            }
//
//
//            for (Map.Entry<ItemType, Integer> entry : requiredIngredients.entrySet()) {
//                if (!user.getBackPack().hasEnoughInInventory(entry.getKey(), entry.getValue())) {
//                    return new Result(false, "You don't have enough ingredient in this artisan device");
//                }
//            }
//        }
//
//
//        if (!user.getBackPack().inventoryHasCapacity()) {
//            return new Result(false, "You don't have enough inventory space");
//        }
//
//
//        if (requiredIngredients != null) {
//            for (Map.Entry<ItemType, Integer> entry : requiredIngredients.entrySet()) {
//                user.getBackPack().removeAmountFromInventory(entry.getKey(), entry.getValue());
//            }
//        }
//
//
//
//
//
//        return new Result(true, "no error");
//    }
//
//
//}
