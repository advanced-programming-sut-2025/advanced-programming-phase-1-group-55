package com.StardewValley.Controller;

import com.StardewValley.View.NpcMenuView;
import com.StardewValley.View.StoreMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.Store.Store;
import com.StardewValley.model.User;

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
                App.gameApp.setScreen(new StoreMenuView(new StoreMenuController(),player,map,"All",store));
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
