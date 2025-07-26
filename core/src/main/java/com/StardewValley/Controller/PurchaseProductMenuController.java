package com.StardewValley.Controller;

import com.StardewValley.View.PurchaseProductMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.Store.Store;
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
        player.getBackPack().addItemToInventory(product.getItem(), amount);
        product.setTodaySell(product.getTodaySell()+amount);

    }
    public void handleInput(){
         if (view!=null){
             if (view.getBackButton().isChecked()){
                 view.getBackButton().setChecked(false);
                 App.gameApp.setScreen(view.getStoreMenuView());
             } else if (view.getPurchaseButton().isChecked()) {
                 int price= view.getTotalPrice();
                 int amount =view.getSelectedQuantity();
                 if(player.getGold()>=price){
                    purchaseProduct(price,amount);
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
