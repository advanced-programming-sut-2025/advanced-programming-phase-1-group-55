package com.StardewValley.View;

import com.StardewValley.Controller.MainGameController;
import com.StardewValley.model.App;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.MainTime;
import com.StardewValley.model.Map.GameMap;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.StardewValley.model.AssetManager.*;

public class MainGameGraphicView implements Screen {
    private final MainGameController controller;
    private OrthographicCamera camera;

    private Texture bgTexture;
    private Texture fenceTexture;
    private ProgressBar energyBar;
    private Table tableTop;
    private Stage stage;


    public MainGameGraphicView(MainGameController controller) {
        this.controller = controller;
        controller.setView(this);
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
        GameMap.BuildMap();

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
        GameMap.DrawMap();

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
}
