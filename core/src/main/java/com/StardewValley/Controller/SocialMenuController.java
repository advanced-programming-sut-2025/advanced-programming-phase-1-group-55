package com.StardewValley.Controller;

import com.StardewValley.View.PauseMenuView;
import com.StardewValley.View.SocialMenuView;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Friendship.Gift;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.User;

import static com.StardewValley.Common.model.App.currentGameModel;

public class SocialMenuController {
    private SocialMenuView view;
    private User user;

    public SocialMenuController() {
        user= App.getCurrentGameModel().getCurrentUser();
    }
    public void handleButton(){
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(new PauseMenuView(new PauseMenuController(), user));
            } else if (view.getSendGiftButton().isChecked()) {
                view.getSendGiftButton().setChecked(false);
                handleGifting();
            }
        }
    }

    private void handleGifting() {
        User friend=view.getSelectedFriend();
        if (friend==null){
            view.setErrorMessage("No friend selected");
            return;
        }
        Item item=view.getSelectedItem();
        if (item==null){
            view.setErrorMessage("No item selected");
            return;
        }
        int quantity;
        try {
            quantity=Integer.parseInt(view.getQuantityField().getText().trim());
        }catch (NumberFormatException e){
            view.setErrorMessage("Invalid quantity");
            return;
        }

        if (item.getNumber()<quantity){
            view.setErrorMessage("You dont have enough items to gift!");
            return;
        }
        user.getBackPack().removeAmountFromInventory(item.getItemType(),quantity);
        friend.getBackPack().addItemToInventory(item,quantity);
        Item newItem=new Item(item.getItemType(),quantity);
        Gift gift=new Gift(user,friend,newItem,currentGameModel.getNumberOfAllGifts()+1);
        currentGameModel.increaseNumberOfGifts();
        friend.getReceivedGifts().put(gift.getId(),gift);
        friend.getFriendsPlayer().get(currentGameModel.currentUser).getGifts().add(gift);
        friend.setHasGiftToday(true);
        friend.getFriendsPlayer().get(currentGameModel.currentUser).increaseXp(50);
        view.setSuccessMessage("You successfully gifted "+quantity+" "+item.getItemType().getDisplayName()+
            " to "+friend.getUsername());
        view.show();
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
