package com.StardewValley.Controller;

import com.StardewValley.View.PurchaseProductMenuView;
import com.StardewValley.View.StoreMenuView;
import com.StardewValley.enums.Seasons;
import com.StardewValley.model.App;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.*;
import com.StardewValley.model.User;

public class StoreMenuController {
    private Store store;
    private User player;
    private StoreMenuView view;
    private GameMap map;
    public StoreMenuController(Store store, User player, GameMap map) {
        this.store = store;
        this.player = player;
        this.map = map;
    }
    public Boolean productIsAvailable(Product product) {
        return (store.getDisplayName().equals("JojaMart") ||
            product.getSeason().equals(GameTime.getSeason())
            || product.getSeason().equals(Seasons.special))&&(product.getDailyLimit()>product.getTodaySell());
    }
    public void handleButton() {
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            }else if(view.getSortConfirmButton().isChecked()){
                view.getSortConfirmButton().setChecked(false);
                App.gameApp.setScreen(new StoreMenuView(new StoreMenuController(store,player,map),player,map, view.getSortSelectBox().getSelected(),store ));
            } else if (view.getPurchaseButton().isChecked()) {
                view.getPurchaseButton().setChecked(false);
                Product product=view.getSelectedProduct();
                if (product==null){
                    return;
                }
                App.gameApp.setScreen(new PurchaseProductMenuView(new PurchaseProductMenuController(player,map,product,store),player,map,product,view));
            }
        }
    }
    public void  setView(StoreMenuView view) {
        this.view = view;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public StoreMenuView getView() {
        return view;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
