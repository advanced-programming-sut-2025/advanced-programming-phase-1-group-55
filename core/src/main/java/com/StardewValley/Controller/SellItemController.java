package com.StardewValley.Controller;

import com.StardewValley.View.SellItemView;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.User;

public class SellItemController {
    private SellItemView view;
    private User player;
    private GameMap map;
    private Item item;
    public SellItemController( User user, GameMap map, Item item) {
        this.player = user;
        this.map = map;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setView(SellItemView view) {
        this.view = view;
    }
    public void handleButton(){
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(view.getShippingBinMenuView());
            } else if (view.getSellButton().isChecked()) {
                view.getSellButton().setChecked(false);
                int quantity=view.getQuantity();
                int totalPrice=view.getTotalPrice();
                handleSellingItem(quantity,totalPrice);
            }
        }
    }
    public void handleSellingItem(int quantity,int totalPrice){
        if (quantity>item.getNumber()){
            view.setErrorMessage("You dont have enough items to sell!\n"+"you just have "+item.getNumber()+" items to sell.");
        }else {
            player.increaseGold(totalPrice);
            player.getBackPack().removeAmountFromInventory(item.getItemType(),quantity);
            view.setSuccessMessage("you sold "+quantity+" "+item.getItemType().getDisplayName()+" successfully!");
        }
    }
    public SellItemView getView() {
        return view;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
