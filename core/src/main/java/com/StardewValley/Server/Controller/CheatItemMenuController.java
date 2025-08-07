package com.StardewValley.Server.Controller;

import com.StardewValley.Client.View.CheatItemMenuView;
import com.StardewValley.Client.View.CheatItemFinalView;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.User;

public class CheatItemMenuController {
    private CheatItemMenuView view;
    private User user;

    public CheatItemMenuController(User user) {
        this.user = user;
    }
    public void handleButton() {
        if (view!=null) {
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            } else if (view.getSellButton().isChecked()) {
                view.getSellButton().setChecked(false);
                Item item=view.getSelectedItem();
                App.gameApp.setScreen(new CheatItemFinalView(item,view,new CheatItemFinalMenuController(user,item)));

            }
        }
    }

    public void setView(CheatItemMenuView view) {
        this.view = view;
    }

    public CheatItemMenuView getView() {
        return view;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
