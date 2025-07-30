package com.StardewValley.Controller;

import com.StardewValley.model.App;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.Tool.Tools;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

import javax.tools.Tool;


public class ToolController {
     private User player;
     private Tools tool;
     private float angle=0;
    public ToolController(User player) {
        this.player = player;
        tool=player.getBackPack().getCurrentTool();
    }
    public void update(double delta) {
        tool = player.getBackPack().getCurrentTool();

        Sprite sprite = tool.getSprite();
        sprite.setScale(0.7f);


        sprite.setOrigin(sprite.getWidth() / 2f, 0);


        sprite.setPosition(
            player.getCollisionRect().getX() - 4*sprite.getOriginX()/5,
            player.getCollisionRect().getY() -  player.getCollisionRect().getHeight() / 3
        );


        sprite.setRotation((float) (3.14-angle * MathUtils.radiansToDegrees));

        sprite.draw(App.gameApp.getBatch());
    }

    public void handleToolRotation(int x, int y) {
        float toolCenterX = (float) Gdx.graphics.getWidth() / 2;
        float toolCenterY = (float) Gdx.graphics.getHeight() / 2;

        angle = (float) Math.atan2(y - toolCenterY, x - toolCenterX);
    }
    public Location getUsedLocation(float x, float y) {
        float centerX = Gdx.graphics.getWidth() / 2f;
        float centerY = Gdx.graphics.getHeight() / 2f;

        float dx = x - centerX;
        float dy = y - centerY;

        float length = (float) Math.sqrt(dx * dx + dy * dy);


        float unitX = dx / length;
        float unitY = dy / length;

        float resultX = centerX + unitX * 20;
        float resultY = centerY + unitY * 20;
        return new Location((int) resultY, (int) resultX);
    }
    public void UseTool(float x, float y) {
      player.decreaseEnergy(20);
      Location location=getUsedLocation(x, y);
      int PointX=location.getX();
      int PointY=location.getY();
      //sina in pointx va pointy oon noghte ee hastesh ke tool gharare roosh estefaade beshe
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }
}
