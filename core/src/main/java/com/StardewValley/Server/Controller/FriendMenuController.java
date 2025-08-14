package com.StardewValley.Server.Controller;

import com.StardewValley.Common.model.Chat.Message;
import com.StardewValley.Common.model.Friendship.*;
import com.StardewValley.Client.View.FriendMenuView;
import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.Item.ItemType;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static com.StardewValley.Common.model.App.currentGameModel;
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
            } else if (view.getSendFlowerButton().isChecked()) {
                view.getSendFlowerButton().setChecked(false);
                handleSendingFlower();
            } else if (view.getSendMarriageRequestButton().isChecked()) {
                view.getSendMarriageRequestButton().setChecked(false);
                PlayerFriendship friendship=you.getFriendsPlayer().get(friend);
                if (friendship.getMarriageRequest()!=null){
                    if (friendship.getMarriageRequest().getMen().equals(you)&&friendship.getMarriageRequest().getAnswer().equals(Answer.unanswered)){
                        view.setErrorMessage("you have already sent a marriage request. wait for your friend answer!");
                        return;
                    } else if (friendship.getMarriageRequest().getMen().equals(you)&&friendship.getMarriageRequest().getAnswer().equals(Answer.accept)) {
                        view.setErrorMessage("you have already married to your friend!");
                        return;
                    }
                }
                handleMarriageRequest(friendship);
            } else if (view.getAcceptButton().isChecked()) {
                view.getAcceptButton().setChecked(false);
                playAnimation(AssetManager.Love.getTexture());
                PlayerFriendship friendship=you.getFriendsPlayer().get(friend);
                friendship.getMarriageRequest().setAnswer(Answer.accept);
                friendship.setAreMarried(true);
                friendship.increaseXp(100);
                view.setSuccessMessage("congratulation you have successfully married to your friend!");
                you.getBackPack().addItemToInventory(new Item(friendship.getMarriageRequest().getRing().getItemType()),1);
                friend.getBackPack().removeAmountFromInventory(friendship.getMarriageRequest().getRing().getItemType(), 1);
            } else if (view.getRejectButton().isChecked()) {
                view.getRejectButton().setChecked(false);
                playAnimation(AssetManager.BrokenHeart.getTexture());
                PlayerFriendship friendship=you.getFriendsPlayer().get(friend);
                friendship.getMarriageRequest().setAnswer(Answer.reject);
                friendship.setXp(0);
                friendship.setLevel(0);
                friendship.setMarriageRequest(null);
                view.setErrorMessage("You broke your friends heart  :(");
            } else if (view.getSendMessageButton().isChecked()) {
                view.getSendMessageButton().setChecked(false);
                if (!you.getCollisionRect().isNear(friend.getCollisionRect())){
                    view.setErrorMessage("You should be near your friend to send message.");
                    return;
                }
                if (view.getMessageField().getText().isEmpty()){
                    return;
                }
                PlayerFriendship friendship=you.getFriendsPlayer().get(friend);
                friendship.getConversation().add(new Message(view.getMessageField().getText(),you.getUsername()));
                view.getMessageField().setText("");
                view.refreshChat();
                friend.setHasMessageToday(true);
                view.setSuccessMessage("Message sent.");
            }
        }
    }
    public void handleMarriageRequest(PlayerFriendship friendship){

        if (!you.getCollisionRect().isNear(friend.getCollisionRect())){
            view.setErrorMessage("You should be near your friend to send marriage request.");
            return;
        }
        else if (friendship.getLevel()<3){
            view.setErrorMessage("your friendship level must be more than 3 to send marriage request!");
            return;
        } else if (!(you.getGender().equals("male")&&friend.getGender().equals("female"))) {
            view.setErrorMessage("A man must make a marriage proposal to a woman!");
            return;

        } else if (!you.getBackPack().getInventory().containsKey(ItemType.WEDDING_RING.getDisplayName())) {
            view.setErrorMessage("you dont have a wedding ring to send marriage request!");
            return;
        }
        MarriageRequest marriageRequest=new MarriageRequest
            (currentGameModel.currentUser,friend,
                currentGameModel.currentUser.getBackPack().getInventory().get(ItemType.WEDDING_RING.getDisplayName()));
        friend.getFriendsPlayer().get(currentGameModel.currentUser).setMarriageRequest(marriageRequest);
        view.setSuccessMessage("You have successfully sent your marriage request.");
    }
    public void handleSendingFlower(){
        if (!you.getCollisionRect().isNear(friend.getCollisionRect())){
            view.setErrorMessage("You should be near your friend to send flower.");
            return;
        }if (!you.getBackPack().getInventory().containsKey(ItemType.BOUQUET.getDisplayName())){
            view.setErrorMessage("You don't have flower in your inventory");
            return;
        }
        PlayerFriendship friendship=you.getFriendsPlayer().get(friend);
        you.getBackPack().removeAmountFromInventory(ItemType.BOUQUET,1);
        friend.getBackPack().addItemToInventory(new Item(ItemType.BOUQUET),1);
        friendship.increaseXp(75);
        playAnimation(AssetManager.Rose.getTexture());
        friendship.setHasReceivedFlower(true);
        view.setSuccessMessage("you have successfully sent flower to your friend.");
    }
    public void handleHugging(){
        if (!you.getCollisionRect().isNear(friend.getCollisionRect())){
            view.setErrorMessage("You should be near your friend to hug.");
            return;
        }
        PlayerFriendship friendship=you.getFriendsPlayer().get(friend);
        friendship.increaseXp(45);
        playAnimation(AssetManager.hugging.getTexture());
        view.setSuccessMessage("You have successfully hugged your friend.");

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
