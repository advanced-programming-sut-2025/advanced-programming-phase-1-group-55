package com.StardewValley.Controller;

import com.StardewValley.View.GiftItemMenuView;
import com.StardewValley.View.NpcMenuView;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.Quest;
import com.StardewValley.model.NPC.QuestStatus;
import com.StardewValley.model.User;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

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
                    return;
                }
            }
            for (int i=0;i<3;i++){
                Button button=view.getFinishQuestButtons()[i];
                if (button.isChecked()){
                    button.setChecked(false);
                    Quest quest=npc.getType().getQuests().get(i+npc.getType().getFirstQuestIndex());

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
