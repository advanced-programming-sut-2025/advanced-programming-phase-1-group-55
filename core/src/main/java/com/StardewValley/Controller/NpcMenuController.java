package com.StardewValley.Controller;

import com.StardewValley.View.newView.GiftItemMenuView;
import com.StardewValley.View.newView.NpcMenuView;
import com.StardewValley.View.newView.ReceiveQuestRewardView;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.Quest;
import com.StardewValley.model.NPC.QuestStatus;
import com.StardewValley.model.Tool.BackPack;
import com.StardewValley.model.User;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class NpcMenuController {
    private NpcMenuView view;
    private User player;
    private GameMap map;
    private Npc npc;
    public NpcMenuController( User user, GameMap map, Npc npc) {
        this.player = user;
        this.map = map;
        this.npc = npc;
    }
    public void handleButtonClicked() {
        if (view!=null){
            if (view.getBackButton().isChecked()){
                view.getBackButton().setChecked(false);
                App.gameApp.setScreen(App.currentGameGraphicView);
            } else if (view.getGiftButton().isChecked()) {
                if (view.getSelectedItem()==null){
                    return;
                }
                view.getGiftButton().setChecked(false);
                App.gameApp.setScreen(new GiftItemMenuView(new GiftItemMenuController(player,map,view.getSelectedItem(),npc),player,map,view.getSelectedItem(),view));
            }
            for (int i=0;i<3;i++){
                Button button=view.getReceiveQuestButtons()[i];
                if (button.isChecked()){
                    button.setChecked(false);
                    player.getFriendsNpc().get(npc.getType().getDisplayName()).getQuestStatus()[i]= QuestStatus.InProgress;
                    player.getQuest().put(npc.getType().getFirstQuestIndex()+i,npc.getType().getQuests().get(npc.getType().getFirstQuestIndex()+i));
                    view.show();
                    return;
                }
            }
            for (int i=0;i<3;i++){
                Button button=view.getFinishQuestButtons()[i];
                if (button.isChecked()){
                    button.setChecked(false);
                    Quest quest=npc.getType().getQuests().get(i+npc.getType().getFirstQuestIndex());
                    BackPack backPack=player.getBackPack();
                    ItemType itemType=quest.getWant().getItem();
                    if(!backPack.getInventory().containsKey(itemType.getDisplayName())||
                        backPack.getInventory().get(itemType.getDisplayName()).getNumber()<quest.getWant().getAmount()){
                        view.setErrorMessage("You don't have enough items to finish the quest");
                        return;
                    }
                    int zarib=1;
                    if(player.getFriendsNpc().get(quest.getNpc().getType().getDisplayName()).getLevel()>=2){
                        zarib=2;
                    }
                    if(quest.getReward().getItem().equals(ItemType.LevelUpFriendship)){
                        player.getFriendsNpc().get(quest.getNpc().getType().getDisplayName()).increaseXp(201);
                    } else if (quest.getReward().getItem().equals(ItemType.GOLD)) {
                        player.increaseGold(quest.getReward().getAmount()*zarib);
                    }else{
                        backPack.addItemToInventory(new Item(quest.getReward().getItem()),quest.getReward().getAmount()*zarib);
                    }
                    backPack.removeAmountFromInventory(quest.getWant().getItem(),quest.getWant().getAmount());
                    //todo remove comment after arshia finished menus
                    player.getFriendsNpc().get(npc.getType().getDisplayName()).getQuestStatus()[i]= QuestStatus.Completed;
                    player.getQuest().remove(npc.getType().getFirstQuestIndex()+i);
//                    for(User user:App.currentGame.playersInGame){
//                        user.getQuest().remove(quest.getId());
//                    }
                    quest.setHasAlreadyFinished(true);
                    App.gameApp.setScreen(new ReceiveQuestRewardView(player,quest,view,map));
                }
            }
        }
    }

    public NpcMenuView getView() {
        return view;
    }

    public void setView(NpcMenuView view) {
        this.view = view;
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

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }
}
