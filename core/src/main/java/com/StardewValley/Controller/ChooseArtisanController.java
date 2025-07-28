package com.StardewValley.Controller;

import com.StardewValley.View.ChooseArtisanMenuView;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.User;

import java.awt.*;

public class ChooseArtisanController {
    private ChooseArtisanMenuView view;
    private User player;
    private GameMap map;


    public ChooseArtisanController(User player, GameMap map) {
        this.player = player;
        this.map = map;
    }

    public void setView(ChooseArtisanMenuView view) {
        this.view = view;
    }
    public  void handleButton(){

    }
}
