package com.StardewValley.Controller;

import com.StardewValley.View.newView.FriendMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.User;

public class FriendMenuController {
    private FriendMenuView view;
    private User you;
    private User friend;

    public FriendMenuController(User you, User friend) {
        this.you = you;
        this.friend = friend;
    }
    public void handleButton(){
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        }
    }

    public FriendMenuView getView() {
        return view;
    }

    public void setView(FriendMenuView view) {
        this.view = view;
    }

    public User getYou() {
        return you;
    }

    public void setYou(User you) {
        this.you = you;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
