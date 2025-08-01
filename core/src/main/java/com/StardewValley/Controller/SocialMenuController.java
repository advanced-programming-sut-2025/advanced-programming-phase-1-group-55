package com.StardewValley.Controller;

import com.StardewValley.View.newView.SocialMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.User;

import javax.swing.text.View;

public class SocialMenuController {
    private SocialMenuView view;
    private User user;

    public SocialMenuController() {
        user= App.getCurrentGameModel().getCurrentUser();
    }

    public SocialMenuView getView() {
        return view;
    }

    public void setView(SocialMenuView view) {
        this.view = view;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
