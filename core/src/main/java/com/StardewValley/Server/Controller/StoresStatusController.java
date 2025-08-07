package com.StardewValley.Server.Controller;

import com.StardewValley.Client.View.ShippingBinMenuView;
import com.StardewValley.Client.View.StoreMenuView;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.Store.ShippingBin;
import com.StardewValley.Common.model.Store.Store;
import com.StardewValley.Common.model.User;

public class StoresStatusController {
    private User player;
    private GameMap map;
    public StoresStatusController(User player, GameMap map) {
        this.player=player;
        this.map=map;
    }
    public void checkIfClickedOnStores(float x, float y){
        for (Store store:map.getVillage().getStores().values()){
            if (store.getCollisionRect().isInside(x, y)){
                App.gameApp.setScreen(new StoreMenuView(new StoreMenuController(store,player,map),player,map,"All",store));
            }
        }
    }
    public void checkIfClickedOnBins(float x, float y){
        for(ShippingBin bin:map.getVillage().getShippingBins()){
            if (bin.getCollisionRect().isInside(x, y)){
                App.gameApp.setScreen(new ShippingBinMenuView(new ShippingBinMenuController(player,map),player,map,"store"));
            }
        }
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
