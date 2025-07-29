package com.StardewValley.Controller;

import com.StardewValley.View.ArtisanMachineMenuView;
import com.StardewValley.model.Artisan.ArtisanMachine;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.User;

public class ArtisanMachineMenuController {
    private ArtisanMachineMenuView view;
    private User player;
    private GameMap map;
    private ArtisanMachine artisanMachine;

    public ArtisanMachineMenuController(User player, GameMap map, ArtisanMachine artisanMachine) {
        this.player = player;
        this.map = map;
        this.artisanMachine = artisanMachine;
    }
    public void handleButton(){

    }
    public void setView(ArtisanMachineMenuView view) {
        this.view = view;
    }

    public ArtisanMachineMenuView getView() {
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

    public ArtisanMachine getArtisanMachine() {
        return artisanMachine;
    }

    public void setArtisanMachine(ArtisanMachine artisanMachine) {
        this.artisanMachine = artisanMachine;
    }
}
