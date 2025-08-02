package com.StardewValley.Controller;

import com.StardewValley.View.newView.FriendMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Friendship.Gift;
import com.StardewValley.model.Friendship.PlayerFriendship;
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
            }else if (view.getRateButton().isChecked()) {
                view.getRateButton().setChecked(false);
                if (view.getSelectedGift() == null){
                    view.setErrorMessage("Please select a gift to rate");
                    return;
                }
                int rate;
                try {
                    rate=Integer.parseInt(view.getRateField().getText());
                }catch (NumberFormatException e){
                    view.setErrorMessage("Please enter a valid number between 1-5");
                    return;
                }
                if (rate>5||rate<1){
                    view.setErrorMessage("Please enter a valid number between 1-5");
                    return;
                }
                Gift gift=view.getSelectedGift();
                gift.setRate(rate);
                view.setSuccessMessage("you have successfully rated the gift.");
                PlayerFriendship friendship=you.getFriendsPlayer().get(friend);
                friendship.increaseXp((rate-3)*30+15);
                view.show();
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
