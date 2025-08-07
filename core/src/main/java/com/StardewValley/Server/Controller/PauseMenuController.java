package com.StardewValley.Server.Controller;

import com.StardewValley.Client.View.*;
import com.StardewValley.Common.model.App;

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
            } else if (view.getRecycleBinButton().isChecked()) {
                view.getRecycleBinButton().setChecked(false);
                App.gameApp.setScreen(new ShippingBinMenuView(new ShippingBinMenuController
                    (view.getUser(),App.currentGameGraphicView.getMap()),
                    view.getUser(),App.currentGameGraphicView.getMap(),"menu"));
            } else if (view.getQuestsButton().isChecked()) {
                view.getQuestsButton().setChecked(false);
                App.gameApp.setScreen(new QuestMenuView());
            }else if (view.getSkillsButton().isChecked()) {
                view.getSkillsButton().setChecked(false);
                App.gameApp.setScreen(new SkillsMenuView(view.getUser()));
            } else if (view.getSocialMenuButton().isChecked()) {
                view.getSocialMenuButton().setChecked(false);
                App.gameApp.setScreen(new SocialMenuView(view.getUser()));
            }
        }
    }
}
