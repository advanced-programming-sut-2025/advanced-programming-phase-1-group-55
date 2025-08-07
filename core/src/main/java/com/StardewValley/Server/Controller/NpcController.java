package com.StardewValley.Server.Controller;

import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.MainTime;
import com.StardewValley.Common.model.NPC.Dialog;
import com.StardewValley.Common.model.NPC.DialogBox;
import com.StardewValley.Common.model.NPC.DialogStatus;
import com.StardewValley.Common.model.NPC.Npc;
import com.StardewValley.Common.model.User;
import com.StardewValley.Client.View.NpcMenuView;
import com.StardewValley.Common.enums.WeatherType;
import com.StardewValley.Common.model.Map.GameMap;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;

public class NpcController {
    private User player;
    private GameMap map;
    private final BitmapFont font = new BitmapFont();
    public NpcController (User player, GameMap map) {
        this.player=player;
        this.map=map;
        font.getData().setScale(0.8f);
    }
    public void update(){
        drawNpc(map);
    }
    public void checkIfClickedOnNpc(float x, float y){
        for (Npc npc:map.getVillage().getNpss().values()){
            if (npc.getCollisionRect().isInside(x, y)){
                App.gameApp.setScreen(new NpcMenuView(new NpcMenuController(player,map,npc),npc,player,map));
            }
        }
    }
    public void updateDialog(Npc npc){
        if (!player.getCollisionRect().isNear(npc.getCollisionRect())) {
            npc.getDialogBox().setStatus(DialogStatus.InActive);
        }
        else  {
            if (npc.getDialogBox().getStatus() == DialogStatus.InActive) {
                npc.getDialogBox().setStatus(DialogStatus.Ready);
            }
            if( Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                if (npc.getDialogBox().getStatus() == DialogStatus.Ready) {
                    npc.getDialogBox().setStatus(DialogStatus.InProgress);
                    player.getFriendsNpc().get(npc.getType().getDisplayName()).increaseXp(30);
                    return;
                }
            }
            if (npc.getDialogBox().getStatus().equals(DialogStatus.InProgress)&&npc.getDialogBox().update(Gdx.graphics.getDeltaTime())) {
                npc.getDialogBox().setStatus(DialogStatus.InProgress);
            }
        }
        drawDialog(npc);
    }
    public void drawDialog(Npc npc) {
        DialogBox dialog = npc.getDialogBox();
        if (dialog.getStatus().equals(DialogStatus.Ready)) {
            dialog.getSprite().draw(App.gameApp.getBatch());
        } else if (dialog.getStatus().equals(DialogStatus.InProgress)) {
            Sprite sprite = dialog.getSprite();
            sprite.draw(App.gameApp.getBatch());

            GlyphLayout layout = new GlyphLayout();
            float textBoxWidth = sprite.getWidth() - 20f;

            layout.setText(font, dialog.getMessage(), Color.BLACK, textBoxWidth, Align.center, true);

            float textX = sprite.getX() + (sprite.getWidth() - textBoxWidth) / 2f;
            float textY = sprite.getY() + sprite.getHeight() - 20f;

            font.draw(App.gameApp.getBatch(), layout, textX, textY);
        }
    }


    public void drawNpc(GameMap map) {
        for (Npc npc : map.getVillage().getNpss().values()) {
            npc.update(Gdx.graphics.getDeltaTime());
            TextureRegion frame = npc.getType().getAnimation().getKeyFrame(npc.getStateTime(), true);

            float x = npc.getCollisionRect().getX();
            float y = npc.getCollisionRect().getY();
            float width = frame.getRegionWidth() * 2f;
            float height = frame.getRegionHeight() * 2f;

            App.gameApp.getBatch().draw(frame, x, y, width, height);
            updateDialog(npc);
        }

    }
    public static String getDialogMessage(/*int friendshipLevel,*/ WeatherType weather, MainTime time) {
        //todo add friendship effect on dialog after arshia done game setup
        for (Dialog dialog : Dialog.values()) {
            if (//dialog.getFriendshipLevel() == friendshipLevel &&
                    dialog.getWeatherType().equals( weather) &&
                    dialog.getMainTime().equals(time)) {
                return dialog.getMessage();
            }
        }
        return "No dialog found for these conditions.";
    }
    public static Boolean npcIsValid(String name){
        return name.equals("Sebastian")||name.equals("Leah")||
                name.equals("Abigail")||name.equals("Harvey")||name.equals("Robin");
    }


    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }
}
