package com.StardewValley.Controller;

import com.StardewValley.View.newView.PauseMenuView;
import com.StardewValley.View.newView.ToolsMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Tool.Tools;

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
