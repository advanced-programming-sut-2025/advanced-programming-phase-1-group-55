package com.StardewValley.View;

import com.StardewValley.Controller.FishingController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Animal.Fishing.FishType;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Item.ItemType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
    private ShapeRenderer shapeRenderer;
    private Sprite fishSprite;
    private Texture fishTexture;

    private CollisionRect barRect;
    private CollisionRect simpleRect;
    private CollisionRect fishRect;

    public FishingGameScreen(FishType fishType, FishingController controller) {
        this.fishType = fishType;
        this.controller = controller;
        stage = new Stage();
        controller.setView(this);
        skin= App.skin;
        barRect = new CollisionRect(100, 100, 40, 300);
        if (fishType.equals(FishType.LEGEND)){
            fishSprite= new Sprite(fishType.getTexture());
        }else {
            fishSprite= AssetManager.chub_fish.getSprite();
        }


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);


        Texture backgroundTexture = new Texture("backgrounds/22.png");
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);


        float barWidth = 60;
        float barHeight = 400;
        float centerX = Gdx.graphics.getWidth() / 2f - barWidth / 2f;
        float centerY = Gdx.graphics.getHeight() / 2f - barHeight / 2f;

        barRect = new CollisionRect(centerX, centerY, barWidth, barHeight);

        float simpleHeight = 60;
        simpleRect = new CollisionRect(centerX, centerY, barWidth, simpleHeight);
        fishRect=new CollisionRect(centerX, centerY,fishSprite.getWidth(),fishSprite.getHeight());



    ProgressBar.ProgressBarStyle progressBarStyle = new ProgressBar.ProgressBarStyle();
    Pixmap bgPixmap = new Pixmap(300, 40, Pixmap.Format.RGBA8888);
    bgPixmap.setColor(Color.DARK_GRAY);
    bgPixmap.fill();
    progressBarStyle.background = new TextureRegionDrawable(new Texture(bgPixmap));

    Pixmap knobPixmap = new Pixmap(10, 40, Pixmap.Format.RGBA8888);
    knobPixmap.setColor(Color.MAGENTA);
    knobPixmap.fill();
    progressBarStyle.knobBefore = new TextureRegionDrawable(new Texture(knobPixmap));

    progressBar = new ProgressBar(0, 100, 1, false, progressBarStyle);
    progressBar.setSize(300, 40);
    progressBar.setPosition(Gdx.graphics.getWidth() / 2f - 150, Gdx.graphics.getHeight() - 100);
    progressBar.setValue(30);
    Table topTable = new Table();
    topTable.setFillParent(true);
    topTable.add(progressBar).row();
    topTable.padBottom(700);
        if(App.currentGameModel.currentUser.getBackPack().getInventory().containsKey(ItemType.SONAR_BOBBER.getDisplayName())||fishType.equals(FishType.LEGEND)){
            topTable.add(new Image(fishType.getTexture())).row();
            topTable.add(new Label(fishType.getDisplayName(), skin)).row();
        }else {
            topTable.add(new Label("use snoar bobber to get information about the fish!", skin)).row();
        }
    stage.addActor(topTable);




        shapeRenderer = new ShapeRenderer();
    }



    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        controller.handleButtonClicked(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();


        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(barRect.getX(), barRect.getY(), barRect.getWidth(), barRect.getHeight());

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(simpleRect.getX(), simpleRect.getY(), simpleRect.getWidth(), simpleRect.getHeight());

        shapeRenderer.end();


        SpriteBatch batch = new SpriteBatch();
        batch.begin();


        fishSprite.setPosition(fishRect.getX(), fishRect.getY());
        fishSprite.draw(batch);

        batch.end();
        batch.dispose();
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
        stage.dispose();
        shapeRenderer.dispose();
    }

    public FishType getFishType() {
        return fishType;
    }

    public void setFishType(FishType fishType) {
        this.fishType = fishType;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public boolean isPerfectCatch() {
        return isPerfectCatch;
    }

    public void setPerfectCatch(boolean perfectCatch) {
        isPerfectCatch = perfectCatch;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public FishingController getController() {
        return controller;
    }

    public void setController(FishingController controller) {
        this.controller = controller;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public Sprite getFishSprite() {
        return fishSprite;
    }

    public void setFishSprite(Sprite fishSprite) {
        this.fishSprite = fishSprite;
    }

    public Texture getFishTexture() {
        return fishTexture;
    }

    public void setFishTexture(Texture fishTexture) {
        this.fishTexture = fishTexture;
    }

    public CollisionRect getBarRect() {
        return barRect;
    }

    public void setBarRect(CollisionRect barRect) {
        this.barRect = barRect;
    }

    public CollisionRect getSimpleRect() {
        return simpleRect;
    }

    public void setSimpleRect(CollisionRect simpleRect) {
        this.simpleRect = simpleRect;
    }

    public CollisionRect getFishRect() {
        return fishRect;
    }

    public void setFishRect(CollisionRect fishRect) {
        this.fishRect = fishRect;
    }
}
