package com.StardewValley.Controller;

import com.StardewValley.View.newView.FriendMenuView;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Friendship.Gift;
import com.StardewValley.model.Friendship.PlayerFriendship;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;

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
            } else if (view.getHugButton().isChecked()) {
                view.getHugButton().setChecked(false);
                handleHugging();
            }
        }
    }
    public void handleHugging(){
        if (!you.getCollisionRect().isNear(friend.getCollisionRect())){
            view.setErrorMessage("You should be near your friend to hug.");
            return;
        }
        playAnimation(AssetManager.hugging.getTexture());

    }
    public void playAnimation(Texture texture){
        Image animImage = view.getAnimationImage();

        animImage.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
        animImage.setVisible(true);
        animImage.setColor(1, 1, 1, 0);

        animImage.setScale(1f);
        animImage.setPosition(
            (view.getStage().getWidth() - animImage.getWidth()) / 2f,
            0
        );

        animImage.addAction(
            sequence(
                moveBy(0, 100, 0.8f),
                parallel(
                    fadeIn(0.8f),
                    scaleTo(1.15f, 1.15f, 0.8f)
                ),
                delay(1.5f),
                fadeOut(1.2f),
                run(() -> {
                    animImage.setVisible(false);
                    animImage.setScale(1f);
                    animImage.setPosition(0, 0);
                })
            )
        );

        view.setSuccessMessage("You have successfully hugged your friend.");
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
