package com.StardewValley.Server.Controller;

import com.StardewValley.Client.View.ChooseArtisanMenuView;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.graphics.g2d.Sprite;

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
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
                App.currentGameGraphicView.setChoosingPlace(false);
            } else if (view.getConfirmButton().isChecked()) {
                view.getConfirmButton().setChecked(false);
                App.currentGameGraphicView.setChoosingPlace(true);
                App.currentGameGraphicView.setChosenArtisanType(view.getSelected());
                App.currentGameGraphicView.setChosenArtisanSprite(new Sprite(view.getSelected().getTexture()));
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        }
    }

    public ChooseArtisanMenuView getView() {
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
