package com.StardewValley.Controller;

import com.StardewValley.View.GiftItemMenuView;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.NPC.Npc;
import com.StardewValley.Common.model.User;

public class GiftItemMenuController {
    private GiftItemMenuView view;
    private User player;
    private GameMap map;
    private Item item;
    private Npc npc;
    public GiftItemMenuController(User user, GameMap map, Item item, Npc npc) {
        this.player = user;
        this.map = map;
        this.item = item;
        this.npc = npc;
    }

    public void setView(GiftItemMenuView view) {
        this.view = view;
    }
    public void handleButton(){
       if (view!=null){
           if (view.getBackButton().isChecked()){
               view.getBackButton().setChecked(false);
               App.gameApp.setScreen(view.getNpcMenuView());
           } else if (view.getGiftButton().isChecked()) {
               view.getGiftButton().setChecked(false);
               handleGift(view.getQuantity());
           }
       }
    }
    public void handleGift(int quantity){
        if (item==null){
            view.setErrorMessage("You need to select a gift item first!");
            return;
        }
        if (quantity>item.getNumber()){
            view.setErrorMessage("You dont have enough items to gift!\n"+"you just have "+item.getNumber()+" items to gift.");
        }else {
            player.getBackPack().removeAmountFromInventory(item.getItemType(),quantity);
            view.setSuccessMessage("you gifted "+quantity+" "+item.getItemType().getDisplayName()+" successfully!");
            player.getFriendsNpc().get(npc.getType().getDisplayName()).increaseXp(npc.getType().isFavorite(item.getItemType())?200:50);
        }
    }
    public GiftItemMenuView getView() {
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }
}
