package com.StardewValley.Controller;

import com.StardewValley.View.InventoryMenuView;
import com.StardewValley.View.PauseMenuView;
import com.StardewValley.View.SkillsMenuView;
import com.StardewValley.View.ToolsMenuView;
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
            } else if (view.getToolsMenuButton().isChecked()) {
                view.getToolsMenuButton().setChecked(false);
                App.gameApp.setScreen(new ToolsMenuView(new ToolsMenuController(),view.getUser()));
            } else if (view.getInventoryMenuButton().isChecked()) {
                view.getInventoryMenuButton().setChecked(false);
                App.gameApp.setScreen(new InventoryMenuView(view.getUser()));
            } else if (view.getSkillsButton().isChecked()) {
                view.getSkillsButton().setChecked(false);
                App.gameApp.setScreen(new SkillsMenuView(view.getUser()));
            }


        }
    }
}
