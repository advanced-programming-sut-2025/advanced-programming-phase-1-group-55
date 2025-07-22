package com.StardewValley.Controller;

import com.StardewValley.model.App;
import com.StardewValley.model.Tool.Tools;
import com.StardewValley.model.User;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class ToolController {
     private User player;
    public ToolController(User player) {
        this.player = player;
    }
    public void update(double delta) {
       Tools tool=player.getBackPack().getCurrentTool();
        Sprite sprite=tool.getSprite();
        sprite.setScale(0.7f);
        sprite.setPosition(player.getCollisionRect().getX()-player.getCollisionRect().getWidth()/2,
            player.getCollisionRect().getY()-2*player.getCollisionRect().getHeight()/3);
       sprite.draw(App.gameApp.getBatch());
    }
    public void UseTool(){

    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }
}
