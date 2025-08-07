package com.StardewValley.Controller;


import com.StardewValley.Common.enums.WeatherType;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.GameTime;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.audio.Sound;

import static com.StardewValley.Common.model.GameTime.getDay;
import static com.StardewValley.Common.model.weather.getCurrentWeather;

public class TimeController {
    private BitmapFont hour;
    private BitmapFont day;
    private BitmapFont gold;
    private TextureAtlas textureAtlas;
    private Sprite rawClock;
    private Sprite clockArrow;
    private Sprite Spring;
    private Sprite Summer;
    private Sprite Fall;
    private Sprite Winter;
    private Sprite Sunny;
    private Sprite Rain;
    private Sprite Snow;
    private Sprite Storm;
    private int scale;


    private Sound thunderSound;

    public TimeController() {
        scale = 4;
        hour = new BitmapFont();
        hour.setColor(Color.BLACK);
        hour.getData().setScale(2f);
        day = new BitmapFont();
        day.setColor(Color.BLACK);
        day.getData().setScale(2f);
        gold = new BitmapFont();
        gold.setColor(Color.BLACK);
        gold.getData().setScale(2f);
        TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("clockSprite/clockAtlas.atlas"));
        thunderSound = Gdx.audio.newSound(Gdx.files.internal("thunder.mp3"));
        rawClock = textureAtlas.createSprite("Raw-Clock");
        clockArrow = textureAtlas.createSprite("Arrow");

        Spring = textureAtlas.createSprite("Spring");
        Summer = textureAtlas.createSprite("Summer");
        Fall = textureAtlas.createSprite("Fall");
        Winter = textureAtlas.createSprite("Winter");

        Sunny = textureAtlas.createSprite("Sunny");
        Rain = textureAtlas.createSprite("Rain");
        Snow = textureAtlas.createSprite("Snow");
        Storm = textureAtlas.createSprite("Storm");

        rawClock.setSize(rawClock.getWidth() * scale, rawClock.getHeight() * scale);
        clockArrow.setSize(clockArrow.getWidth() * scale, clockArrow.getHeight() * scale);
        Spring.setSize(Spring.getWidth() * scale, Spring.getHeight() * scale);
        Summer.setSize(Summer.getWidth() * scale, Summer.getHeight() * scale);
        Fall.setSize(Fall.getWidth() * scale, Fall.getHeight() * scale);
        Winter.setSize(Winter.getWidth() * scale, Winter.getHeight() * scale);
        Sunny.setSize(Sunny.getWidth() * scale, Sunny.getHeight() * scale);
        Rain.setSize(Rain.getWidth() * scale, Rain.getHeight() * scale);
        Snow.setSize(Snow.getWidth() * scale, Snow.getHeight() * scale);
        Storm.setSize(Storm.getWidth() * scale, Storm.getHeight() * scale);

        clockArrow.setOrigin(clockArrow.getWidth() / 2, 0);
    }

    private boolean lightningFlash = false;
    private boolean hasLightningHappened = false;
    private float flashDuration = 0f;

    public void update(float delta) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            triggerLightning();
            hasLightningHappened = false;
        }

        if (getCurrentWeather() == WeatherType.Storm && !hasLightningHappened) {
            triggerLightning();
        }

        if (lightningFlash) {
            flashDuration -= delta;
            if (flashDuration <= 0) {
                lightningFlash = false;
            }
        }
    }

    private void triggerLightning() {
        lightningFlash = true;
        flashDuration = 0.2f;
        thunderSound.play();
        hasLightningHappened = true;
    }


    public void render(SpriteBatch batch, OrthographicCamera camera) {

        Matrix4 originalMatrix = batch.getProjectionMatrix();


        Matrix4 uiMatrix = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.setProjectionMatrix(uiMatrix);

        float clockX = Gdx.graphics.getWidth() - rawClock.getWidth() - 20;
        float clockY = Gdx.graphics.getHeight() - rawClock.getHeight() - 20;
        if (lightningFlash) {
            ShapeRenderer shapeRenderer = new ShapeRenderer();
            shapeRenderer.setProjectionMatrix(camera.combined);
            Gdx.gl.glEnable(GL20.GL_BLEND);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(1, 1, 1, 0.8f);
            shapeRenderer.rect(camera.position.x - camera.viewportWidth / 2,
                    camera.position.y - camera.viewportHeight / 2,
                    camera.viewportWidth, camera.viewportHeight);
            shapeRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);
            shapeRenderer.dispose();
        }
        rawClock.setPosition(clockX, clockY);
        clockArrow.setPosition(clockX + 88 - clockArrow.getWidth() / 2, clockY + 156);

        float weatherX = clockX + 29 * scale;
        float weatherY = clockY + 35 * scale;
        float seasonX = clockX + 53 * scale;
        float seasonY = clockY + 35 * scale;

        Sunny.setPosition(weatherX, weatherY);
        Rain.setPosition(weatherX, weatherY);
        Snow.setPosition(weatherX, weatherY);
        Storm.setPosition(weatherX, weatherY);
        Summer.setPosition(seasonX, seasonY);
        Fall.setPosition(seasonX, seasonY);
        Winter.setPosition(seasonX, seasonY);
        Spring.setPosition(seasonX, seasonY);

        clockArrow.setRotation(-((GameTime.getHour() - 9) * 12 + 180));
        rawClock.draw(batch);
        clockArrow.draw(batch);

        switch (GameTime.getSeason().getName()) {
            case "spring":
                Spring.draw(batch);
                break;
            case "summer":
                Summer.draw(batch);
                break;
            case "fall":
                Fall.draw(batch);
                break;
            case "winter":
                Winter.draw(batch);
                break;
        }
        switch (getCurrentWeather()) {
            case Rain:
                Rain.draw(batch);
                break;
            case Snow:
                Snow.draw(batch);
                break;
            case Sunny:
                Sunny.draw(batch);
                break;
            case Storm:
                Storm.draw(batch);
                break;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2) && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            GameTime.increaseHour(1);
        }

//        GameMenuController menuController = new GameMenuController();
        String dayOfWeek = getDay().getName();


        hour.draw(batch, GameTime.getHour() + " o'clock",
                clockX + 27 * scale, clockY + 23 * scale + hour.getLineHeight());
        day.draw(batch, dayOfWeek + ". ",
                clockX + 27 * scale, clockY + 45 * scale + hour.getLineHeight());

        User currentPlayer = App.currentGameModel.getCurrentUser();


        gold.draw(batch, String.valueOf(currentPlayer.getGold()),
                clockX + 17 * scale, clockY + 3 * scale + gold.getLineHeight());


        batch.setProjectionMatrix(originalMatrix);
    }

    public void dispose() {
        if (hour != null) hour.dispose();
        if (day != null) day.dispose();
        if (gold != null) gold.dispose();
        thunderSound.dispose();
    }
}

