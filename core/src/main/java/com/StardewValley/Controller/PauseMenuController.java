package com.StardewValley.Controller;

import com.StardewValley.View.PauseMenuView;
import com.StardewValley.model.App;

public class PauseMenuController {
    private PauseMenuView view;
    public void setView(PauseMenuView view) {
        this.view = view;
    }

    public PauseMenuView getView() {
        return view;
    }
    public void handleButtonPressed() {
        if (view!=null){
            if (view.getResumeButton().isChecked()){
                view.getResumeButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        }
    }
}
