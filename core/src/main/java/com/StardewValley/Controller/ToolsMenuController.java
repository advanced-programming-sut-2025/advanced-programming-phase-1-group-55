package com.StardewValley.Controller;

import com.StardewValley.View.PauseMenuView;
import com.StardewValley.View.ToolsMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Tool.Tools;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class ToolsMenuController {
   private ToolsMenuView view;

    public void setView(ToolsMenuView view) {
        this.view = view;
    }
    public void handleButton(Tools tool) {
        if (view!=null){
            if (view.getBackBtn().isChecked()){
                view.getBackBtn().setChecked(false);
                App.gameApp.setScreen(new PauseMenuView(new PauseMenuController(),view.getUser()));
            } else if (view.getConfirmBtn().isChecked()) {
                view.getConfirmBtn().setChecked(false);
                view.getUser().getBackPack().setCurrentTool(tool);
            }
        }
    }

    public ToolsMenuView getView() {
        return view;
    }
}
