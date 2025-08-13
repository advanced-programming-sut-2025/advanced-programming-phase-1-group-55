package com.StardewValley.Server.Controller;


import com.StardewValley.Client.View.*;
import com.StardewValley.Common.model.Map.Fence;
import com.StardewValley.Common.model.Map.FenceType;
//import com.StardewValley.View.MainGameGraphicView;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Artisan.ArtisanMachine;
import com.StardewValley.Common.model.Item.CollisionRect;
import com.StardewValley.Common.model.NPC.Npc;
import com.StardewValley.Common.model.Store.ShippingBin;
import com.StardewValley.Common.model.Store.Store;
import com.StardewValley.Common.model.Result;


import com.StardewValley.Common.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import static com.StardewValley.Common.model.App.*;
import static com.StardewValley.Common.model.GameTime.*;
import static com.StardewValley.Common.model.weather.getCurrentWeather;

public class MainGameController {
    private MainGameGraphicView view;
    private PlayerController playerController;
    private ToolController toolController;
    private NpcController npcController;
    private StoresStatusController storeController;
    private User currentPlayer = App.getMainUser();

    public void setView(MainGameGraphicView view) {

        this.view = view;
        view.setUpStage();
        currentPlayer = view.getPlayer();
        playerController = new PlayerController(currentPlayer,this);
        playerController.setStage(view.getStage());
        toolController = new ToolController(currentPlayer);
        npcController = new NpcController(currentPlayer, view.getMap());
        storeController = new StoresStatusController(currentPlayer, view.getMap());
        currentPlayer.setGold(40000);
        currentPlayer.setWood(40000);
    }

    public void checkIfClickedOnMachine(float dx, float dy) {
        for (ArtisanMachine artisanMachine : view.getMap().getArtisanMachines()) {
            if (artisanMachine.getCollisionRect().isInside(dx, dy) && artisanMachine.getOwner().equals(currentPlayer)) {
                gameApp.setScreen(new ArtisanMachineMenuView(currentPlayer, view.getMap(), artisanMachine,
                    new ArtisanMachineMenuController(currentPlayer, view.getMap(), artisanMachine)));
            }
        }
    }

    public boolean canPlace(Sprite sprite, float x, float y) {
        CollisionRect collisionRect = new CollisionRect(x, y, sprite.getWidth(), sprite.getHeight());
        if (x > view.getMap().getWORLD_WIDTH() / 2 || x < -view.getMap().getWORLD_WIDTH() / 2 ||
            y > view.getMap().getWORLD_HEIGHT() / 2 || y < -view.getMap().getWORLD_HEIGHT() / 2) {
            return false;
        }
        for (Fence fence : view.getMap().getFences()) {
            if (collisionRect.collidesWith(fence.getCollisionRect())) {
                return false;
            }
        }
        for (Store store : view.getMap().getVillage().getStores().values()) {
            if (collisionRect.collidesWith(store.getCollisionRect())) {
                return false;
            }
        }
        for (Npc npc : view.getMap().getVillage().getNpss().values()) {
            if (collisionRect.collidesWith(npc.getCollisionRect())) {
                return false;
            }
            if (collisionRect.collidesWith(npc.getType().getHouse().getCollisionRect())) {
                return false;
            }
        }
        for (ShippingBin bin : view.getMap().getVillage().getShippingBins()) {
            if (collisionRect.collidesWith(bin.getCollisionRect())) {
                return false;
            }
        }
        for (ArtisanMachine artisanMachine : view.getMap().getArtisanMachines()) {
            if (artisanMachine.getCollisionRect().collidesWith(collisionRect)) {
                return false;
            }
        }
        if (collisionRect.collidesWith(currentPlayer.getFarm().getHouse().getCollisionRect()) ||
            collisionRect.collidesWith(currentPlayer.getFarm().getGreenHouse().getCollisionRect()) ||
            collisionRect.collidesWith(currentPlayer.getFarm().getLake().getCollisionRect()) ||
            collisionRect.collidesWith(currentPlayer.getFarm().getQuarry().getCollisionRect())) {
            return false;
        }
        return true;
    }

    public void checkIfClickedOnPlayer(float dx, float dy) {
        for (User user : currentGameModel.playersInGame) {
            if (user.getCollisionRect().isInside(dx, dy) && !user.getUsername().equals(currentPlayer.getUsername())) {
                gameApp.setScreen(new FriendMenuView(user, new FriendMenuController(currentPlayer, user)));
            }
        }
    }

    public void choosingPlace(float x, float y) {
        Sprite sprite = view.getChosenArtisanSprite();
        sprite.setPosition(x, y);
        if (canPlace(sprite, x, y)) {
            sprite.setColor(Color.GREEN);
        } else {
            sprite.setColor(Color.RED);
        }
    }

    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            passTheGate();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            gameApp.setScreen(new PauseMenuView(new PauseMenuController(), currentPlayer));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.K)) {
            gameApp.setScreen(new ChooseArtisanMenuView(currentPlayer, view.getMap(), new ChooseArtisanController(currentPlayer, view.getMap())));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
            if (view.isChoosingPlace()) {
                if (view.getChosenArtisanSprite().getColor().equals(Color.GREEN)) {
                    Sprite sprite = new Sprite(view.getChosenArtisanSprite());
                    ArtisanMachine artisanMachine = new ArtisanMachine(view.getChosenArtisanType(), currentPlayer,
                        new CollisionRect(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight()));
                    view.getMap().getArtisanMachines().add(artisanMachine);
                    view.setChoosingPlace(false);
                }
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
            nextTurn();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            gameApp.setScreen(new CheatItemMenuView(new CheatItemMenuController(view.getPlayer())));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {

            CraftingMenuController craftingController = new CraftingMenuController();
            CraftingMenuView craftingView = new CraftingMenuView(craftingController, currentPlayer);
            gameApp.setScreen(craftingView);
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
            CookingMenuController cookingController = new CookingMenuController();
            CookingMenuView cookingView = new CookingMenuView(cookingController, currentPlayer);
            gameApp.setScreen(cookingView);
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            gameApp.setScreen(new FarmingProductMenuView());
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            AnimalMenuController animalMenuController = new AnimalMenuController(currentPlayer);
            AnimalMenuView animalMenuView = new AnimalMenuView(animalMenuController, currentPlayer);
            gameApp.setScreen(animalMenuView);
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            gameApp.setScreen(new ChatMenuView(new ArrayList<>()));
        }


    }

    public void nextTurn() {
        int i = 0;
        int lastIndex = getCurrentGameModel().playersInGame.size() - 1;
        for (User user : getCurrentGameModel().playersInGame) {
            if (user.getUsername().equals(currentPlayer.getUsername())) {
                if (i == lastIndex) {
                    currentPlayer = getCurrentGameModel().playersInGame.getFirst();
                } else {
                    currentPlayer = getCurrentGameModel().playersInGame.get(i + 1);
                }
                view.setPlayer(currentPlayer);
                playerController.setPlayer(currentPlayer);
                toolController.setPlayer(currentPlayer);
                npcController.setPlayer(currentPlayer);
                storeController.setPlayer(currentPlayer);
                getCurrentGameModel().setCurrentUser(currentPlayer);
                return;
            }
            i++;
        }
    }

    private void passTheGate() {
        for (Fence fence : view.getMap().fences) {
            if (fence.getFenceType().equals(FenceType.door)) {
                float playerX = playerController.getPlayer().getCollisionRect().getX();
                float playerY = playerController.getPlayer().getCollisionRect().getY();

                float fenceX = fence.getCollisionRect().getX();
                float fenceY = fence.getCollisionRect().getY();

                float dx = playerX - fenceX;
                float dy = playerY - fenceY;
                float distance = (float) Math.sqrt(dx * dx + dy * dy);

                if (distance < 60) {
                    if (playerX < fenceX) {
                        if (!playerController.getPlayer().getFarm().getDoors().contains(fence)) {
                            return;
                        }
                        playerController.getPlayer().getLocation().setX((int) playerX + 75);

                    } else {
                        if (!playerController.getPlayer().getFarm().getDoors().contains(fence)) {
                            return;
                        }
                        playerController.getPlayer().getLocation().setX((int) playerX - 75);

                    }


                    playerController.getPlayer().getCollisionRect().updateCollisionRect(
                        playerController.getPlayer().getLocation().getX(),
                        playerController.getPlayer().getLocation().getY()
                    );
                    return;
                }
            }
        }
    }

    public void updateGame(float delta) {
        if (view != null) {
            handleInput();
            playerController.update();
            toolController.update(delta);
            npcController.update();
            // drawOtherPlayers();


        }
    }
    public Result time() {

        return new Result(true, String.valueOf(getHour()));
    }

    public Result date() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDayofMonth()).append(" of ").append(getSeason());

        return new Result(true, sb.toString());
    }

    public Result season() {
        return new Result(true, String.valueOf(getSeason()));
    }

    public Result weather() {
        return new Result(true, getCurrentWeather().name());
    }

    public NpcController getNpcController() {
        return npcController;
    }

    public void setNpcController(NpcController npcController) {
        this.npcController = npcController;
    }

    public MainGameGraphicView getView() {
        return view;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public ToolController getToolController() {
        return toolController;
    }

    public void setToolController(ToolController toolController) {
        this.toolController = toolController;
    }

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(User currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public StoresStatusController getStoreController() {
        return storeController;
    }

    public void setStoreController(StoresStatusController storeController) {
        this.storeController = storeController;
    }

}
