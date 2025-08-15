package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientData;
import com.StardewValley.Common.GameDetails;
import com.StardewValley.Common.model.Chat.EmojiType;
import com.StardewValley.Server.Controller.MainGameController;
import com.StardewValley.Common.model.Animal.AnimalBuilding;
import com.StardewValley.Common.model.Animal.FarmBuildingType;
import com.StardewValley.Server.Controller.TimeController;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Artisan.ArtisanMachineType;
import com.StardewValley.Common.model.GameTime;
import com.StardewValley.Common.model.MainTime;
import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.StardewValley.Common.enums.AssetManager.DAY_BACKGROUND;
import static com.StardewValley.Common.enums.AssetManager.NIGHT_BACKGROUND;

public class MainGameGraphicView implements Screen, InputProcessor {
    private final MainGameController controller;
    private OrthographicCamera camera;

    private Texture bgTexture;
    private Texture fenceTexture;
    private ProgressBar energyBar;
    private Table tableTop;
    private Stage stage;
    private User player = App.mainUser;
    private boolean isChoosingPlace = false;
    private ArtisanMachineType chosenArtisanType;
    private Sprite chosenArtisanSprite;
    private GameMap map = new GameMap();
    private TimeController timeController;
    private TextureRegion backgroundRegion;
    private GameDetails gameDetails;


    private String errorMessage = null;
    private float errorTimer = 0f;

    public void showError(String message, float duration) {
        errorMessage = message;
        errorTimer = duration;
    }

    public void update(float delta) {
        if (errorTimer > 0) {
            errorTimer -= delta;
            if (errorTimer <= 0) {
                errorMessage = null;
            }
        }
    }

    //    private GameMap map = new GameMap();
    private boolean isPlacingBuilding = false;
    private FarmBuildingType chosenBuildingType;


    public MainGameGraphicView(GameDetails game, MainGameController controller, GameMap map) {
        this.controller = controller;
        this.map = map;
        controller.setView(this);
        App.currentGameGraphicView = this;
        controller.getPlayerController().setGameMap(map);
        this.gameDetails = game;

    }

    private void setupCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
    }

    public void setUpStage() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

        setupCamera();

        setUpStage();
//        stage = new Stage(new ScreenViewport());
//        Gdx.input.setInputProcessor(stage);

        updateBackgroundTexture();
        timeController = new TimeController(gameDetails);

        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();

        Pixmap bgPixmap = new Pixmap(200, 20, Pixmap.Format.RGBA8888);
        bgPixmap.setColor(Color.DARK_GRAY);
        bgPixmap.fill();
        progressBarStyle.background = new TextureRegionDrawable(new Texture(bgPixmap));

        Pixmap knobPixmap = new Pixmap(1, 20, Pixmap.Format.RGBA8888);
        knobPixmap.setColor(Color.GREEN);
        knobPixmap.fill();
        progressBarStyle.knobBefore = new TextureRegionDrawable(new Texture(knobPixmap));

        energyBar = new ProgressBar(0, 10000, 1, false, progressBarStyle);


        tableTop = new Table();
        tableTop.top().left();
        tableTop.setFillParent(true);
        tableTop.add(energyBar).pad(10).padRight(50).left();


        stage.addActor(tableTop);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this);
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);

    }

    private void updateBackgroundTexture() {
        Texture newTexture = GameTime.getMainTime().equals(MainTime.Night)
            ? NIGHT_BACKGROUND.getTexture()
            : DAY_BACKGROUND.getTexture();
        if (bgTexture != newTexture) {
            bgTexture = newTexture;
            bgTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
            backgroundRegion = new TextureRegion(bgTexture);
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();

        controller.getPlayerController().centerPlayerOnCamera(camera);
        App.gameApp.getBatch().setProjectionMatrix(camera.combined);

        App.gameApp.getBatch().begin();

        drawBackground();
        updateBackgroundTexture();

        player.getFarm().draw();
        for (FarmLand land : player.getFarm().getFarmLands()) {
            land.draw();
        }
        map.DrawMap();
        if (isChoosingPlace) {
            chosenArtisanSprite.draw(App.gameApp.getBatch());
        }
        for (AnimalBuilding building : player.getFarmBuildings()) {
            building.getSprite().setPosition(building.getLocation().getX(), building.getLocation().getY());
            building.getSprite().draw(App.gameApp.getBatch());
        }


        controller.updateGame(delta);
        timeController.update(delta);
        timeController.render(App.gameApp.getBatch(), camera);
        update(delta);
        if (errorMessage != null) {
            BitmapFont font = new BitmapFont();
            font.setColor(Color.RED);
            font.getData().setScale(2f);

            font.draw(App.gameApp.getBatch(), errorMessage,
                Gdx.graphics.getWidth() / 2f - 100,
                Gdx.graphics.getHeight() - 50);
        }
        App.gameApp.getBatch().end();

        energyBar.setValue((float) player.getEnergy());
        stage.act(delta);
        stage.draw();
    }


    private void drawBackground() {
        float camX = camera.position.x - camera.viewportWidth / 2;
        float camY = camera.position.y - camera.viewportHeight / 2;

        int texWidth = bgTexture.getWidth();
        int texHeight = bgTexture.getHeight();

        int offsetX = ((int) camX) % texWidth;
        if (offsetX < 0) offsetX += texWidth;

        backgroundRegion.setRegion(offsetX, 0, (int) camera.viewportWidth, (int) camera.viewportHeight);

        App.gameApp.getBatch().draw(backgroundRegion, camX, camY, camera.viewportWidth, camera.viewportHeight);
    }


    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }


    public void startBuildingMode(FarmBuildingType buildingType) {
        this.isPlacingBuilding = true;
        this.chosenBuildingType = buildingType;
        float farmLandWidth = player.getFarm().getFarmLands().get(0).getCollisionRect().getWidth();
        float farmLandHeight = player.getFarm().getFarmLands().get(0).getCollisionRect().getHeight();
        int widthInTiles = buildingType.getSize().get(0);
        int heightInTiles = buildingType.getSize().get(1);
        for (FarmLand land : player.getFarm().getFarmLands()) {
            boolean canBuildHere = true;
            float baseX = land.getCollisionRect().getX();
            float baseY = land.getCollisionRect().getY();
            for (int dx = 0; dx < widthInTiles; dx++) {
                for (int dy = 0; dy < heightInTiles; dy++) {
                    float checkX = baseX + dx * farmLandWidth;
                    float checkY = baseY + dy * farmLandHeight;
                    FarmLand tile = player.getFarm().findFarmLandAt(checkX, checkY);
                    if (tile == null || tile.isPlanted()) {
//                        canBuildHere = false;
                        break;
                    }
                    for (AnimalBuilding built : player.getFarmBuildings()) {
                        if (built.getCollisionRect().overlaps(checkX, checkY, farmLandWidth, farmLandHeight)) {
//                            canBuildHere = false;
                            break;
                        }
                    }
                }
                if (!canBuildHere) break;
            }
            if (canBuildHere) {
                land.setColor(Color.GREEN);
            } else {
                land.setColor(Color.RED);
            }
        }

    }


    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
        camera.update();
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        if (timeController != null) {
            timeController.dispose();
        }
    }

    public MainGameController getController() {
        return controller;
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            Vector3 click = new Vector3(screenX, screenY, 0);
            camera.unproject(click);
            controller.getNpcController().checkIfClickedOnNpc(click.x, click.y);
            controller.getStoreController().checkIfClickedOnStores(click.x, click.y);
            controller.getStoreController().checkIfClickedOnBins(click.x, click.y);
            controller.checkIfClickedOnMachine(click.x, click.y);
            controller.getToolController().UseTool(click.x, click.y);
            controller.checkIfClickedOnPlayer(click.x, click.y);
            Vector3 worldClick = new Vector3(screenX, screenY, 0);
            camera.unproject(worldClick);
            float clickX = worldClick.x;
            float clickY = worldClick.y;
            if (isPlacingBuilding && chosenBuildingType != null) {
                FarmLand targetLand = player.getFarm().findFarmLandAt(clickX, clickY);
                if (targetLand != null) {
                    if (targetLand.getSprite().getColor().equals(Color.GREEN)) {
                        player.setGold(player.getGold() - chosenBuildingType.getPrice());
                        player.setWood(player.getWood() - chosenBuildingType.getWoodNumber());
                        player.setStone(player.getStone() - chosenBuildingType.getStoneNumber());
                        AnimalBuilding newBuilding = new AnimalBuilding(targetLand.getLocation(), chosenBuildingType);
                        player.addFarmBuilding(newBuilding);
                        for (FarmLand land : player.getFarm().getFarmLands()) {
                            land.setColor(Color.WHITE);
                        }
                        isPlacingBuilding = false;
                        chosenBuildingType = null;
                    } else {
                        System.out.println("Cannot build here - invalid location.");
                    }
                }
                return true;
            }
            controller.getNpcController().checkIfClickedOnNpc(clickX, clickY);
            controller.getStoreController().checkIfClickedOnStores(clickX, clickY);
            controller.getStoreController().checkIfClickedOnBins(clickX, clickY);
            controller.checkIfClickedOnMachine(clickX, clickY);
            controller.getToolController().UseTool(clickX, clickY);
            controller.checkIfClickedOnPlayer(clickX, clickY);
        }
        return true;
    }


    public void showTemporaryAction(String message, Texture texture) {
        com.badlogic.gdx.scenes.scene2d.ui.Dialog actionDialog =
            new com.badlogic.gdx.scenes.scene2d.ui.Dialog("", App.skin);

        com.badlogic.gdx.scenes.scene2d.ui.Table content = new com.badlogic.gdx.scenes.scene2d.ui.Table();
        content.pad(20);

        if (texture != null) {
            com.badlogic.gdx.scenes.scene2d.ui.Image image =
                new com.badlogic.gdx.scenes.scene2d.ui.Image(new TextureRegionDrawable(new TextureRegion(texture)));
            image.setSize(64, 64);
            content.add(image).center().row();
        }

        com.badlogic.gdx.scenes.scene2d.ui.Label label =
            new com.badlogic.gdx.scenes.scene2d.ui.Label(message, App.skin);
        content.add(label).padTop(10).center();

        actionDialog.getContentTable().add(content).center();
        actionDialog.show(stage);

        Gdx.app.postRunnable(() -> {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    Gdx.app.postRunnable(actionDialog::hide);
                } catch (InterruptedException ignored) {
                }
            }).start();
        });
    }


    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        controller.getToolController().handleToolRotation(screenX, screenY);
        Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
        camera.unproject(worldCoordinates);

        if (isChoosingPlace) {
            controller.choosingPlace(worldCoordinates.x, worldCoordinates.y);
        }
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Texture getBgTexture() {
        return bgTexture;
    }

    public void setBgTexture(Texture bgTexture) {
        this.bgTexture = bgTexture;
    }

    public Texture getFenceTexture() {
        return fenceTexture;
    }

    public void setFenceTexture(Texture fenceTexture) {
        this.fenceTexture = fenceTexture;
    }

    public ProgressBar getEnergyBar() {
        return energyBar;
    }

    public void setEnergyBar(ProgressBar energyBar) {
        this.energyBar = energyBar;
    }

    public Table getTableTop() {
        return tableTop;
    }

    public void setTableTop(Table tableTop) {
        this.tableTop = tableTop;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public boolean isChoosingPlace() {
        return isChoosingPlace;
    }

    public void setChoosingPlace(boolean choosingPlace) {
        isChoosingPlace = choosingPlace;
    }

    public ArtisanMachineType getChosenArtisanType() {
        return chosenArtisanType;
    }

    public void setChosenArtisanType(ArtisanMachineType chosenArtisanType) {
        this.chosenArtisanType = chosenArtisanType;
    }

    public Sprite getChosenArtisanSprite() {
        return chosenArtisanSprite;
    }

    public void setChosenArtisanSprite(Sprite chosenArtisanSprite) {
        this.chosenArtisanSprite = chosenArtisanSprite;
    }


}
