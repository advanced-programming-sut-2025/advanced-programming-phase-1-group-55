package com.StardewValley.Controller;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.Map.Lake;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.Tool.Tools;
import com.StardewValley.model.Tool.WateringCan;
import com.StardewValley.model.User;
import com.StardewValley.View.newView.FarmLand;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

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

        if (tool instanceof WateringCan wateringCan) {
            if (player.getFarm().getLake().getCollisionRect().isInside(x, y)
                && player.getCollisionRect().isNear(player.getFarm().getLake().getCollisionRect())) {
                wateringCan.refill();
//                System.out.println("WateringCan refilled!");
                App.currentGameGraphicView.showTemporaryAction("Refilling...", AssetManager.WATERING_CAN.getTexture());

                return;
            }
        }

        for (FarmLand land : player.getFarm().getFarmLands()) {
            if (land.getCollisionRect().isInside(x, y)) {
                if (player.getCollisionRect().isNear(land.getCollisionRect())) {

                    if (tool.getName().equals("Hoe") && !land.isPlowed()) {
                        land.setPlowed(true);
                        land.setColor(Color.BROWN);
                        player.decreaseEnergy(tool.energyCost());
                        App.currentGameGraphicView.showTemporaryAction("Plowing...", AssetManager.HOE.getTexture());

                    }

                    else if (tool.getName().equals("Axe")
                        && selectedItem != null
                        && selectedItem.getDisplayName().toLowerCase().endsWith("seeds")
                        && land.isPlowed()
                        && !land.getSprite().getColor().equals(Color.GREEN)
                        && !land.getSprite().getColor().equals(Color.RED)
                        && !land.getSprite().getColor().equals(Color.BLUE)) {

                        land.setColor(Color.GREEN);
//                        land.setTexture(selectedItem.getTexture());
                        land.setPlanted(true);
                        player.decreaseEnergy(tool.energyCost());
                        player.getBackPack().removeAmountFromInventory(selectedItem, 1);
                        land.setCrop(selectedItem);
                        App.currentGameGraphicView.showTemporaryAction("Planting...", selectedItem.getTexture());
                    }

                    else if (tool.getName().equals("Axe")
                        && selectedItem != null
                        && selectedItem.getDisplayName().toLowerCase().contains("fertilizer")
                        && land.isPlowed()
                        && land.getSprite().getColor().equals(Color.GREEN)) {

                        land.setColor(Color.RED);
                        land.setFertilized(true);
                        player.getBackPack().removeAmountFromInventory(selectedItem, 1);
                        App.currentGameGraphicView.showTemporaryAction("Fertilizing...", selectedItem.getTexture());
                    }

                    else if (tool instanceof WateringCan wateringCanTool
                        && land.isPlowed()
                        && (land.getSprite().getColor().equals(Color.GREEN)
                        || land.getSprite().getColor().equals(Color.RED))) {

                        if (wateringCanTool.hasWater()) {
                            land.setColor(Color.BLUE);
                            land.setWatered(true);
                            wateringCanTool.useWater();
                            player.decreaseEnergy(tool.energyCost());
//                            System.out.println("Watered! Water left: " + wateringCanTool.getWaterContains());
                            App.currentGameGraphicView.showTemporaryAction("Watering...", AssetManager.WATERING_CAN.getTexture());
                        } else {
//                            System.out.println("WateringCan is empty!");
                        }
                    }

                    else if (tool.getName().equals("Scythe")
                        && land.isPlowed()
                        && land.isPlanted()
                        && land.isFertilized()
                        && land.isWatered()
                        && land.getCrop() != null) {

                        ItemType harvestedItem = getProductFromSeed(land.getCrop());

                        if (harvestedItem != null) {
                            player.getBackPack().addItemToInventory(new Item(harvestedItem, 1), 1);
//                            System.out.println("Harvested: " + harvestedItem.getDisplayName());
                            App.currentGameGraphicView.showTemporaryAction("Harvesting...", AssetManager.SCYTHE.getTexture());
                        }

                        land.setPlanted(false);
                        land.setFertilized(false);
                        land.setWatered(false);
                        land.setCrop(null);
                        land.setColor(Color.CLEAR);
                        land.setTexture(AssetManager.NIGHT_BACKGROUND.getTexture());

                    }


                }
            }
        }
    }


    public ItemType getProductFromSeed(ItemType seed) {
        String seedName = seed.name();
        if (seedName.endsWith("_SEEDS")) {
            String cropName = seedName.replace("_SEEDS", "");
            try {
                return ItemType.valueOf(cropName);
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown crop item: " + cropName);
            }
        }
        return null;
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
