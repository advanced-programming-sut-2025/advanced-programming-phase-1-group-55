package com.StardewValley.Controller;

import com.StardewValley.View.PurchaseProductMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.User;

public class PurchaseProductMenuController {
    private PurchaseProductMenuView view;
    private User player;
    private GameMap map;
    private Product product;
    public PurchaseProductMenuController(  User user, GameMap map, Product product) {
        this.player = user;
        this.map = map;
        this.product = product;
    }
    public void handleInput(){
         if (view!=null){
             if (view.getBackButton().isChecked()){
                 view.getBackButton().setChecked(false);
                 App.gameApp.setScreen(view.getStoreMenuView());
             } else if (view.getPurchaseButton().isChecked()) {
                 //todo purchase check
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
