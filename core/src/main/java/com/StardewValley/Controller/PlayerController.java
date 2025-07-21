package com.StardewValley.Controller;

import com.StardewValley.GameApp;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Map.Location;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerController {
    private int speed = 5;
    private User player;
    private GameMap gameMap;

    public PlayerController(User player) {
        this.player = player;
        player.setCollisionRect(new CollisionRect(player.getLocation().getX(), player.getLocation().getY(), player.getSprite().getWidth(), player.getSprite().getHeight()));
    }

    public void centerPlayerOnCamera(OrthographicCamera camera) {
        camera.position.set(player.getLocation().getX(), player.getLocation().getY(), 0);
        Sprite sprite = player.getPlayerSprite();
        float centerX = camera.position.x - sprite.getWidth() / 2f;
        float centerY = camera.position.y - sprite.getHeight() / 2f;
        sprite.setPosition(centerX, centerY);
    }

    public void update() {
        player.getPlayerSprite().draw(App.gameApp.getBatch());

        handlePlayerInput();
    }


    public void handlePlayerInput() {
        boolean movedSuccessfully = true;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.getLocation().setY(player.getLocation().getY() + speed);
            player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
            if (!gameMap.canMove(player.getCollisionRect())) {
                player.getLocation().setY(player.getLocation().getY() - speed);
                player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
                movedSuccessfully = false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.getLocation().setX(player.getLocation().getX() + speed);
            player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
            if (!gameMap.canMove(player.getCollisionRect())) {
                player.getLocation().setX(player.getLocation().getX() - speed);
                player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
                movedSuccessfully = false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.getLocation().setY(player.getLocation().getY() - speed);
            player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
            if (!gameMap.canMove(player.getCollisionRect())) {
                player.getLocation().setY(player.getLocation().getY() + speed);
                player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
                movedSuccessfully = false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.getLocation().setX(player.getLocation().getX() - speed);
            player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
            if (!gameMap.canMove(player.getCollisionRect())) {
                player.getLocation().setX(player.getLocation().getX() + speed);
                player.getCollisionRect().updateCollisionRect(player.getLocation().getX(), player.getLocation().getY());
                movedSuccessfully = false;
            }
        }
        if (movedSuccessfully) {
            //todo  energy kam beshe  arshia bezn ino
        }
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }
}
