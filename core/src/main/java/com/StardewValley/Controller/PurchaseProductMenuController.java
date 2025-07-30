package com.StardewValley.Controller;

import com.StardewValley.View.PurchaseProductMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.Store.Store;
import com.StardewValley.model.Tool.*;
import com.StardewValley.model.User;

public class PurchaseProductMenuController {
    private PurchaseProductMenuView view;
    private User player;
    private GameMap map;
    private Product product;
    private Store store;
    public PurchaseProductMenuController(  User user, GameMap map, Product product, Store store) {
        this.player = user;
        this.map = map;
        this.product = product;
        this.store = store;
    }
    public void purchaseProduct(int price,int amount) {
        player.setGold(player.getGold()-price);
        product.setTodaySell(product.getTodaySell()+amount);
        BackPack backPack=player.getBackPack();
        if (product.getItem().getItemType().equals(ItemType.FIBERGLASS_ROD)) {
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
        }else if (product.getItem().getItemType().equals(ItemType.STEEL_TOOL)) {
            backPack.getCurrentTool().setLevel(2);
        }else if (product.getItem().getItemType().equals(ItemType.GOLD_TOOL)) {
            backPack.getCurrentTool().setLevel(3);
        }else if (product.getItem().getItemType().equals(ItemType.IRIDIUM_TOOL)) {
            backPack.getCurrentTool().setLevel(4);
        } else if(product.getItem().getItemType().equals(ItemType.SHEARS)){
            backPack.getAvailableTools().remove("Shears");
            backPack.getAvailableTools().put("Shears",new Shears());
        } else if (product.getItem().getItemType().equals(ItemType.MILK_PAIR)) {
            backPack.getAvailableTools().remove("MilkPail");
            backPack.getAvailableTools().put("MilkPail",new MilkPail());
        }else {
            player.getBackPack().addItemToInventory(product.getItem(), amount);
        }
    }
    public void handleInput(){
         if (view!=null){
             if (view.getBackButton().isChecked()){
                 view.getBackButton().setChecked(false);
                 App.gameApp.setScreen(view.getStoreMenuView());
             } else if (view.getPurchaseButton().isChecked()) {
                 view.getPurchaseButton().setChecked(false);
                 int price= view.getTotalPrice();
                 int amount =view.getSelectedQuantity();
                 if(player.getGold()>=price){
                     view.setSuccessMessage("You purchased the product successfully!");
                    purchaseProduct(price,amount);
                 }else {
                     view.setErrorMessage("You don't have enough money!");
                 }
             }
         }
    }
    public void  setView(PurchaseProductMenuView view) {
        this.view = view;
    }

    public PurchaseProductMenuView getView() {
        return view;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
