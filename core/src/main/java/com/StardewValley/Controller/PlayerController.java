package com.StardewValley.Controller;

import com.StardewValley.GameApp;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerController {
    private User player;
    public PlayerController(User player) {
        this.player = player;
    }
    public void centerPlayerOnCamera(OrthographicCamera camera) {
        camera.position.set(player.getLocation().getX(), player.getLocation().getY(), 0);
        Sprite sprite = player.getPlayerSprite();
        float centerX = camera.position.x - sprite.getWidth() / 2f;
        float centerY = camera.position.y - sprite.getHeight() / 2f;
        sprite.setPosition(centerX, centerY);
    }
    public void update(){
        player.getPlayerSprite().draw(App.gameApp.getBatch());

        handlePlayerInput();
    }


    public void handlePlayerInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            player.getLocation().setY(player.getLocation().getY() + 1);
            if (!GameMap.isInsideFence(player.getLocation().getX(), player.getLocation().getY())) {
                player.getLocation().setY(player.getLocation().getY() - 1);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            player.getLocation().setX(player.getLocation().getX() + 1);
            if (!GameMap.isInsideFence(player.getLocation().getX(), player.getLocation().getY())){
                player.getLocation().setX(player.getLocation().getX() - 1);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            player.getLocation().setY(player.getLocation().getY() - 1);
            if (!GameMap.isInsideFence(player.getLocation().getX(), player.getLocation().getY())){
                player.getLocation().setY(player.getLocation().getY() + 1);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            player.getLocation().setX(player.getLocation().getX() - 1);
            if (!GameMap.isInsideFence(player.getLocation().getX(), player.getLocation().getY())){
                player.getLocation().setX(player.getLocation().getX() + 1);
            }
        }
    }
}
