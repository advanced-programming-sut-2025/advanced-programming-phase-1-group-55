package com.StardewValley.Server.Controller;

import com.StardewValley.Client.ClientData;
import com.StardewValley.Common.PlayerDetails;
import com.StardewValley.Common.enums.Direction;
import com.StardewValley.Common.model.Item.CollisionRect;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.Map.GreenHouse;
import com.StardewValley.Common.model.User;
import com.StardewValley.Common.model.weather;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.HashMap;

import static com.StardewValley.Common.model.App.gameApp;
import static com.StardewValley.Common.model.App.getCurrentGameModel;

public class PlayerController {
    private int speed = 10;
    private User player;
    private GameMap gameMap;
    private final float scale = 2f;
    private Stage stage;
    private Animation<TextureRegion> walkUp, walkDown, walkLeft, walkRight;
    private Animation<TextureRegion> currentAnimation;
    private MainGameController MainGameController;
    private boolean isFainting = false;
    private boolean faintSequenceFinished = false;
    private float stateTime = 0f;
    private Direction direction = Direction.DOWN;

    public PlayerController(User player, MainGameController controller) {
        this.player = player;
        initializeAnimations();
        MainGameController = controller;


        // Set initial collision rectangle based on frame size
        TextureRegion initialFrame = walkDown.getKeyFrame(0);
        player.setCollisionRect(new CollisionRect(
            player.getLocation().getX(),
            player.getLocation().getY(),
            initialFrame.getRegionWidth() * scale,
            initialFrame.getRegionHeight() * scale
        ));

        currentAnimation = walkDown;
    }

    private void initializeAnimations() {
        TextureRegion[] down = new TextureRegion[]{
            new TextureRegion(new Texture("walk/Alex_01.png")),
            new TextureRegion(new Texture("walk/Alex_02.png")),
            new TextureRegion(new Texture("walk/Alex_03.png")),
            new TextureRegion(new Texture("walk/Alex_04.png"))
        };
        TextureRegion[] right = new TextureRegion[]{
            new TextureRegion(new Texture("walk/Alex_05.png")),
            new TextureRegion(new Texture("walk/Alex_06.png")),
            new TextureRegion(new Texture("walk/Alex_07.png")),
            new TextureRegion(new Texture("walk/Alex_08.png"))
        };
        TextureRegion[] up = new TextureRegion[]{
            new TextureRegion(new Texture("walk/Alex_09.png")),
            new TextureRegion(new Texture("walk/Alex_10.png")),
            new TextureRegion(new Texture("walk/Alex_11.png")),
            new TextureRegion(new Texture("walk/Alex_12.png"))
        };
        TextureRegion[] left = new TextureRegion[]{
            new TextureRegion(new Texture("walk/Alex_13.png")),
            new TextureRegion(new Texture("walk/Alex_14.png")),
            new TextureRegion(new Texture("walk/Alex_15.png")),
            new TextureRegion(new Texture("walk/Alex_16.png"))
        };

        walkDown = new Animation<>(0.1f, down);
        walkUp = new Animation<>(0.1f, up);
        walkLeft = new Animation<>(0.1f, left);
        walkRight = new Animation<>(0.1f, right);
    }

    public void update() {
        if (player.isFainted()) {
            if (!isFainting) {
                startFaintSequence();
            }


            Sprite faintSprite = player.getSprite();
            if (faintSprite != null) {
                faintSprite.setPosition(player.getLocation().getX(), player.getLocation().getY());
                faintSprite.setScale(scale);
                faintSprite.draw(gameApp.getBatch());
            }

            drawOtherPlayers();

        } else {
            handlePlayerInput();

            boolean isMoving =
                Gdx.input.isKeyPressed(Input.Keys.W) ||
                    Gdx.input.isKeyPressed(Input.Keys.A) ||
                    Gdx.input.isKeyPressed(Input.Keys.S) ||
                    Gdx.input.isKeyPressed(Input.Keys.D);

            TextureRegion currentFrame;
            if (isMoving) {
                stateTime += Gdx.graphics.getDeltaTime();
                currentFrame = currentAnimation.getKeyFrame(stateTime, true);
            } else {
                stateTime = 0f;
                currentFrame = currentAnimation.getKeyFrame(0);
            }

            gameApp.getBatch().draw(
                currentFrame,
                player.getLocation().getX(),
                player.getLocation().getY(),
                currentFrame.getRegionWidth() * scale,
                currentFrame.getRegionHeight() * scale
            );

            drawOtherPlayers();
        }


        stage.act(Gdx.graphics.getDeltaTime());
//        stage.draw();
    }


    private void startFaintSequence() {
        isFainting = true;
        faintSequenceFinished = false;

        player.setSprite(new Sprite(new Texture("walk/Alex_52.png")));

        Image redOverlay = new Image(new Texture("backgrounds/red-background.png"));
        redOverlay.setFillParent(true);
        redOverlay.getColor().a = 0;

        redOverlay.addAction(Actions.sequence(
            Actions.repeat(3, Actions.sequence(
                Actions.fadeIn(0.3f),
                Actions.fadeOut(0.3f)
            )),
            Actions.run(() -> {
                MainGameController.nextTurn();
                faintSequenceFinished = true;
                isFainting = false;


                redOverlay.remove();
            })
        ));

        stage.addActor(redOverlay);
    }

    private HashMap<String, Sprite> otherPlayerSprites = new HashMap<>();

    public void drawOtherPlayers() {
        for (PlayerDetails pd : ClientData.getInstance().gameDetails.getPlayers().values()) {
            if (pd.username.equals(player.getUsername())) continue;

            Sprite sprite = otherPlayerSprites.get(pd.username);
            if (sprite == null) {
                sprite = new Sprite(new Texture("walk/Alex_01.png"));
                sprite.setScale(2f);
                otherPlayerSprites.put(pd.username, sprite);
            }

            sprite.setPosition(pd.posX, pd.posY);
            sprite.draw(gameApp.getBatch());
        }
    }

    public void centerPlayerOnCamera(OrthographicCamera camera) {
//        Sprite sprite = player.getPlayerSprite();
        TextureRegion currentFrame = currentAnimation.getKeyFrame(0);
        float centerX = player.getLocation().getX() + (currentFrame.getRegionWidth() * scale) / 2f;
        float centerY = player.getLocation().getY() + (currentFrame.getRegionHeight() * scale) / 2f;
        camera.position.set(centerX, centerY, 0);
    }

    public void handlePlayerInput() {
        boolean moved = false;


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            direction = Direction.UP;
            currentAnimation = walkUp;
            moved |= tryMove(0, speed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            direction = Direction.DOWN;
            currentAnimation = walkDown;
            moved |= tryMove(0, -speed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            direction = Direction.LEFT;
            currentAnimation = walkLeft;
            moved |= tryMove(-speed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            direction = Direction.RIGHT;
            currentAnimation = walkRight;
            moved |= tryMove(speed, 0);
        }

        if (moved) {
            player.decreaseEnergy(weather.getEnergyLoser());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            player.increaseEnergy(10);
        }
        if (player.getCollisionRect().isNear(player.getFarm().getGreenHouse().getCollisionRect())) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0)) {
                GreenHouse greenhouse = player.getFarm().getGreenHouse();


                if (player.getGold() > greenhouse.getGoldForGreenHouse() && player.getWood() > greenhouse.getWoodForGreenHouse() && !greenhouse.getRepaired()) {
                    greenhouse.setRepaired(true);
                    player.decreaseWood(greenhouse.getWoodForGreenHouse());
                    player.decreaseGold(greenhouse.getGoldForGreenHouse());
                    greenhouse.setSprite(greenhouse.getSprite_salem());
                } else {
                    MainGameController.getView().showError("you dont have enough material", 2f);
                }

            }
        }
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }


    private boolean tryMove(int dx, int dy) {
        player.getLocation().add(dx, dy);
        player.getCollisionRect().updateCollisionRect(
            player.getLocation().getX(),
            player.getLocation().getY()
        );

//        if (gameMap != null && !gameMap.canMove(player.getCollisionRect())) {
//            player.getLocation().add(-dx, -dy);
//            player.getCollisionRect().updateCollisionRect(
//                player.getLocation().getX(),
//                player.getLocation().getY()
//            );
//            return false;
//        }
        return true;
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
