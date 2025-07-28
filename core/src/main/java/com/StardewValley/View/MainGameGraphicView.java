package com.StardewValley.View;

import com.StardewValley.Controller.MainGameController;
import com.StardewValley.model.App;
import com.StardewValley.model.Artisan.ArtisanMachineType;
import com.StardewValley.model.Friendship.NpcFriendship;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.StardewValley.model.MainTime;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.NPC.Quest;
import com.StardewValley.model.User;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.StardewValley.enums.AssetManager.*;

public class MainGameGraphicView implements Screen, InputProcessor {
    private final MainGameController controller;
    private OrthographicCamera camera;

    private Texture bgTexture;
    private Texture fenceTexture;
    private ProgressBar energyBar;
    private Table tableTop;
    private Stage stage;
    private User player=new User();
    private boolean isChoosingPlace=true;
    private ArtisanMachineType chosenArtisanType=ArtisanMachineType.BEER;
    private Sprite chosenArtisanSprite;
    //todo field paayin baayad beshe App.currentGame.map
    private GameMap map=new GameMap();


    public MainGameGraphicView(MainGameController controller) {
        this.controller = controller;
        controller.setView(this);
        App.currentGameGraphicView=this;
        map.BuildMap();
        controller.getPlayerController().setGameMap(map);
        //todo remove this after arshia completed pregame menu
        for (Npc npc:map.getVillage().getNpss().values()){
            NpcFriendship friendship=new NpcFriendship(player,npc);
            player.getFriendsNpc().put(npc.getType().getDisplayName(),friendship);
            for (Quest quest:npc.getType().getQuests().values()){
                quest.setNpc(npc);
                if (quest.getLevel()==1){
                    player.getQuest().put(quest.getId(),quest);
                }
            }
        }
        Item item=new Item(ItemType.WOOD);
        item.setPrice(10);
        player.getBackPack().addItemToInventory(item,200);
        Item item2=new Item(ItemType.GOLD_BAR);
        item2.setPrice(3000);
        player.getBackPack().addItemToInventory(item2,20);
        //todo remove  baalaayi !!!!!!!!!!!!!!!!
        chosenArtisanSprite=new Sprite(chosenArtisanType.getTexture());

    }

    private void setupCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
    }

    @Override
    public void show() {

        setupCamera();


        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        updateBackgroundTexture();


        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();

        Pixmap bgPixmap = new Pixmap(200, 20, Pixmap.Format.RGBA8888);
        bgPixmap.setColor(Color.DARK_GRAY);
        bgPixmap.fill();
        progressBarStyle.background = new TextureRegionDrawable(new Texture(bgPixmap));

        Pixmap knobPixmap = new Pixmap(1, 20, Pixmap.Format.RGBA8888);
        knobPixmap.setColor(Color.GREEN);
        knobPixmap.fill();
        progressBarStyle.knobBefore = new TextureRegionDrawable(new Texture(knobPixmap));

        energyBar = new ProgressBar(0f, 100f, 1f, false, progressBarStyle);
        energyBar.setValue(50f);


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
        //todo bade zadan choose map tavasot arshia az App.current game estefaade kn
        map.DrawMap();
        if (isChoosingPlace){
            chosenArtisanSprite.draw(App.gameApp.getBatch());
        }

        controller.updateGame(delta);

        App.gameApp.getBatch().end();
        //todo energy bar.setvalue-->> player.getEnergy  alan chon plyer==null nmishod zad intori
        stage.act(delta);
        stage.draw();
    }

    private void drawBackground() {
        float camX = camera.position.x - camera.viewportWidth / 2;
        float camY = camera.position.y - camera.viewportHeight / 2;

        TextureRegion backgroundRegion = new TextureRegion(bgTexture);

        int texWidth = bgTexture.getWidth();
        int texHeight = bgTexture.getHeight();

        int offsetX = ((int) camX) % texWidth;
        if (offsetX < 0) offsetX += texWidth;

        int offsetY = 0;

        backgroundRegion.setRegion(offsetX, offsetY, (int) camera.viewportWidth, (int) camera.viewportHeight);

        App.gameApp.getBatch().draw(backgroundRegion, camX, camY, camera.viewportWidth, camera.viewportHeight);
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
        camera.update();
        stage.getViewport().update(width, height, true);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
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
        }
        return true;
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

        if (isChoosingPlace){
            controller.choosingPlace( worldCoordinates.x, worldCoordinates.y);
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
        return stage;
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
