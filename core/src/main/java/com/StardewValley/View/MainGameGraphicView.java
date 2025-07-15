package com.StardewValley.View;

import com.StardewValley.Controller.MainGameController;
import com.StardewValley.model.GameTime;
import com.StardewValley.model.MainTime;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.StardewValley.model.AssetManager.DayBackGround;
import static com.StardewValley.model.AssetManager.NightBackGround;

public class MainGameGraphicView implements Screen, InputProcessor {
    private final MainGameController controller;
    private OrthographicCamera camera;
    private Texture bgTexture;
    private SpriteBatch batch;
    private Stage stage;


    private final int WORLD_WIDTH = 5000;
    private final int WORLD_HEIGHT = 5000;

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
        Gdx.input.setInputProcessor(this);
        if(GameTime.getMainTime().equals(MainTime.Night)){
            bgTexture=NightBackGround;
        }else {
            bgTexture=DayBackGround;
        }
        bgTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void render(float delta) {
        if(GameTime.getMainTime().equals(MainTime.Night)){
            bgTexture=NightBackGround;
        }else {
            bgTexture=DayBackGround;
        }
        bgTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();


        TextureRegion backgroundRegion = new TextureRegion(bgTexture);
        backgroundRegion.setRegion(0, 0, WORLD_WIDTH, WORLD_HEIGHT);


        batch.draw(backgroundRegion, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);



        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
        camera.update();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();

    }


    @Override public boolean keyDown(int i) { return false; }
    @Override public boolean keyUp(int i) { return false; }
    @Override public boolean keyTyped(char c) { return false; }
    @Override public boolean touchDown(int i, int i1, int i2, int i3) { return false; }
    @Override public boolean touchUp(int i, int i1, int i2, int i3) { return false; }
    @Override public boolean touchCancelled(int i, int i1, int i2, int i3) { return false; }
    @Override public boolean touchDragged(int i, int i1, int i2) { return false; }
    @Override public boolean mouseMoved(int i, int i1) { return false; }
    @Override public boolean scrolled(float v, float v1) { return false; }

    public MainGameController getController() {
        return controller;
    }
}
