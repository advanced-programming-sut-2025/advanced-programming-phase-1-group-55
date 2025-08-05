package com.StardewValley.View.newView;

import com.StardewValley.Controller.FishingController;
import com.StardewValley.model.Animal.Fishing.FishType;
import com.StardewValley.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class FishingGameScreen implements Screen {
    private FishType fishType;
    private BitmapFont font;
    private boolean isPerfectCatch=true;
    private Stage stage;
    private Skin skin;
    private FishingController controller;
    private ProgressBar progressBar;
    private Rectangle greenRectangle;

    public FishingGameScreen(FishType fishType, FishingController controller) {
        this.fishType = fishType;
        this.controller = controller;
        stage = new Stage();
        skin= App.skin;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Texture backgroundTexture = new Texture("backgrounds/22.png");
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);
        ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();
        Pixmap bgPixmap = new Pixmap(200, 20, Pixmap.Format.RGBA8888);
        bgPixmap.setColor(com.badlogic.gdx.graphics.Color.DARK_GRAY);
        bgPixmap.fill();
        progressBarStyle.background = new TextureRegionDrawable(new Texture(bgPixmap));

        Pixmap knobPixmap = new Pixmap(1, 20, Pixmap.Format.RGBA8888);
        knobPixmap.setColor(Color.MAGENTA);
        knobPixmap.fill();
        progressBarStyle.knobBefore = new TextureRegionDrawable(new Texture(knobPixmap));
        progressBar = new ProgressBar(0, 10000, 1, false, progressBarStyle);
        stage.addActor(progressBar);

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        controller.handleButtonClicked();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(v);
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

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

    }
}
