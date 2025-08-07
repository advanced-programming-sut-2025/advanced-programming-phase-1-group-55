package com.StardewValley.Server.Controller;

import com.StardewValley.Client.View.PauseMenuView;
import com.StardewValley.Client.View.ToolsMenuView;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Tool.Tools;

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
