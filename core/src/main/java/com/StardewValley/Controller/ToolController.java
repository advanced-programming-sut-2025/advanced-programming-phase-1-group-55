package com.StardewValley.Controller;

import com.StardewValley.model.App;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.Tool.Tools;
import com.StardewValley.model.User;
import com.StardewValley.View.newView.FarmLand;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Color;

public class ToolController {
    private User player;
    private Tools tool;
    private float angle = 0;

    public ToolController(User player) {
        this.player = player;
        tool = player.getBackPack().getCurrentTool();
    }

    public void update(double delta) {
        tool = player.getBackPack().getCurrentTool();
        var sprite = tool.getSprite();
        sprite.setScale(0.7f);
        sprite.setOrigin(sprite.getWidth() / 2f, 0);
        sprite.setPosition(
            player.getCollisionRect().getX() - 4 * sprite.getOriginX() / 5,
            player.getCollisionRect().getY() - player.getCollisionRect().getHeight() / 3
        );
        sprite.setRotation((float) (3.14 - angle * MathUtils.radiansToDegrees));
        sprite.draw(App.gameApp.getBatch());
    }

    public void handleToolRotation(int x, int y) {
        float toolCenterX = (float) Gdx.graphics.getWidth() / 2;
        float toolCenterY = (float) Gdx.graphics.getHeight() / 2;
        angle = (float) Math.atan2(y - toolCenterY, x - toolCenterX);
    }

    public void UseTool(float x, float y) {
        tool = player.getBackPack().getCurrentTool();
        ItemType selectedItem = player.getBackPack().getSelectedItem();

        for (FarmLand land : player.getFarm().getFarmLands()) {
            if (land.getCollisionRect().isInside(x, y)) {
                if (player.getCollisionRect().isNear(land.getCollisionRect())) {

                    if (tool.getName().equals("Hoe") && !land.isPlowed()) {
                        land.setPlowed(true);
                        land.setColor(Color.BROWN);
                        player.decreaseEnergy(tool.energyCost());
                    }

                    else if (selectedItem != null
                        && selectedItem.getDisplayName().toLowerCase().endsWith("seeds")
                        && land.isPlowed()
                        && !land.getSprite().getColor().equals(Color.GREEN)) {

                        land.setColor(Color.GREEN);
                        player.decreaseEnergy(tool.energyCost());
                    }
                }
            }
        }
    }



    public void setPlayer(User player) {
        this.player = player;
    }

    public void setTool(Tools tool) {
        this.tool = tool;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
