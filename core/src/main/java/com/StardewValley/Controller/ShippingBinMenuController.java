package com.StardewValley.Controller;

import com.StardewValley.View.ShippingBinMenuView;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.User;

public class ShippingBinMenuController {
    private ShippingBinMenuView view;
    private User player;
    private GameMap map;

    public ShippingBinMenuController(User player, GameMap map) {
        this.player = player;
        this.map = map;
    }

    public void handleButton() {

    }
    public void setView(ShippingBinMenuView view) {
        this.view = view;
    }

    public ShippingBinMenuView getView() {
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
}
