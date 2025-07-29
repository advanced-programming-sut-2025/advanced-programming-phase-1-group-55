package com.StardewValley.Controller;

import com.StardewValley.View.ArtisanMachineMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Artisan.ArtisanMachine;
import com.StardewValley.model.Artisan.ArtisanStatus;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.User;

public class ArtisanMachineMenuController {
    private ArtisanMachineMenuView view;
    private User player;
    private GameMap map;
    private ArtisanMachine artisanMachine;

    public ArtisanMachineMenuController(User player, GameMap map, ArtisanMachine artisanMachine) {
        this.player = player;
        this.map = map;
        this.artisanMachine = artisanMachine;
    }
    public void handleButton(){
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            } else if (view.getStartProgressButton().isChecked()) {
                view.getStartProgressButton().setChecked(false);
                if(!view.getSelectBox().getSelected().getItemType().equals(artisanMachine.getArtisanType().getEntryItem())){
                    view.setErrorMessage("This item is not suitable for the machine. Please insert the appropriate item into the machine.");
                    return;
                }
                artisanMachine.setStatus(ArtisanStatus.working);
                player.getBackPack().removeAmountFromInventory(artisanMachine.getArtisanType().getEntryItem(),1);
                view.show();

            } else if (view.getCancelButton().isChecked()) {
                view.getCancelButton().setChecked(false);
                artisanMachine.setStatus(ArtisanStatus.off);
                player.getBackPack().addItemToInventory(new Item(artisanMachine.getArtisanType().getEntryItem()),1);
                artisanMachine.setDaysWithOutWater(0);
                view.show();
            } else if (view.getEndProgressButton().isChecked()) {
                view.getEndProgressButton().setChecked(false);
                artisanMachine.setStatus(ArtisanStatus.ready);
                artisanMachine.setDaysWithOutWater(artisanMachine.getArtisanType().getProcessTime());
                view.show();
            } else if (view.getCollectButton().isChecked()) {
                view.getCollectButton().setChecked(false);
                artisanMachine.setStatus(ArtisanStatus.off);
                Item item = new Item(artisanMachine.getArtisanType().getProduct());
                item.setPrice(artisanMachine.getArtisanType().getSellPrice());
                player.getBackPack().addItemToInventory(item,1);
                artisanMachine.setDaysWithOutWater(0);
                view.show();
            }
        }
    }
    public void setView(ArtisanMachineMenuView view) {
        this.view = view;
    }

    public ArtisanMachineMenuView getView() {
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

    public ArtisanMachine getArtisanMachine() {
        return artisanMachine;
    }

    public void setArtisanMachine(ArtisanMachine artisanMachine) {
        this.artisanMachine = artisanMachine;
    }
}
