package com.StardewValley.View.newView;

import com.StardewValley.model.Animal.Fishing.FishMovementPattern;
import com.StardewValley.model.Animal.Fishing.MixedMovement;
import com.StardewValley.model.App;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class FishingGameScreen implements Screen {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private Rectangle fishingBar;
    private Rectangle fish;
    private float catchMeter;
    private boolean isPerfectCatch;

    private float fishY;
    private float fishUpdateTimer;
    private FishMovementPattern fishPattern;

    private BitmapFont font;

    public FishingGameScreen() {

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();

        fishingBar = new Rectangle(50, 200, 30, 60);
        fish = new Rectangle(60, 250, 20, 20);

        fishY = fish.y;
        catchMeter = 0;
        isPerfectCatch = true;

        fishPattern = new MixedMovement();
    }

    @Override
    public void render(float delta) {
        handleInput(delta);


        fishUpdateTimer += delta;
        if (fishUpdateTimer >= 0.5f) {
            fishUpdateTimer = 0;
            int deltaY = fishPattern.getNextDeltaY();
            fishY += deltaY;
            fishY = MathUtils.clamp(fishY, 0, Gdx.graphics.getHeight() - fish.height);
        }

        fish.y = fishY;


        if (fish.overlaps(fishingBar)) {
            catchMeter += delta * 0.5f;
        } else {
            catchMeter -= delta * 0.5f;
            isPerfectCatch = false;
        }
        catchMeter = MathUtils.clamp(catchMeter, 0, 1);


        if (catchMeter >= 1f) {
            System.out.println("Fish Caught!");
            if (isPerfectCatch)
                System.out.println("Perfect Catch!");
            App.gameApp.setScreen(App.currentGameGraphicView);
        } else if (catchMeter <= 0f) {
            System.out.println("Fish Escaped!");
            App.gameApp.setScreen(App.currentGameGraphicView);
        }


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);


        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(100, 50, 200, 20);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(100, 50, 200 * catchMeter, 20);


        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(fishingBar.x, fishingBar.y, fishingBar.width, fishingBar.height);


        shapeRenderer.setColor(Color.ORANGE);
        shapeRenderer.rect(fish.x, fish.y, fish.width, fish.height);

        shapeRenderer.end();

        batch.begin();
        if (isPerfectCatch)
            font.draw(batch, "Perfect Catch!", 150, 300);
        batch.end();
    }

    private void handleInput(float delta) {
        float speed = 200;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            fishingBar.y += speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            fishingBar.y -= speed * delta;
        }
        fishingBar.y = MathUtils.clamp(fishingBar.y, 0, Gdx.graphics.getHeight() - fishingBar.height);

        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            App.gameApp.setScreen(App.currentGameGraphicView);
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }
}
