package com.StardewValley.Controller;

import com.StardewValley.View.StoreMenuView;
import com.StardewValley.enums.Seasons;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.*;
import com.StardewValley.model.User;

public class StoreMenuController {
    private Store store;
    private User player;
    private StoreMenuView view;
    private GameMap map;
    public Boolean productIsAvailable(Product product) {
        return store.getDisplayName().equals("OjaMart") ||
            product.getSeason().equals(GameTime.getSeason())
            || product.getSeason().equals(Seasons.special);
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
