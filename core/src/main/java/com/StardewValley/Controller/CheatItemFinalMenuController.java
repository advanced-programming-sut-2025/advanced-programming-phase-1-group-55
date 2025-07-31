package com.StardewValley.Controller;

import com.StardewValley.View.newView.CheatItemFinalView;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.User;

import java.util.Vector;

public class CheatItemFinalMenuController {
    private CheatItemFinalView view;
    private User user;
    private Item item;

    public CheatItemFinalMenuController(User user, Item item) {
        this.user = user;
        this.item = item;
    }
    public void handleButton(){
       if (view!=null) {
           if (view.getBackButton().isChecked()){
               view.getBackButton().setChecked(false);
               App.gameApp.setScreen(view.getCheatItemView());
           } else if (view.getConfirmButton().isChecked()) {
               view.getConfirmButton().setChecked(false);
               user.getBackPack().addItemToInventory(new Item(item.getItemType()),view.getQuantity());
               view.setSuccessMessage("you successfully added "+view.getQuantity()+" "+item.getItemType().getDisplayName()+" to the inventory");
           }
       }
    }
    public CheatItemFinalView getView() {
        return view;
    }

    public void setView(CheatItemFinalView view) {
        this.view = view;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
