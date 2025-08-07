package com.StardewValley.View;

import com.StardewValley.Common.model.Animal.AnimalBuilding;
import com.StardewValley.Common.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class AnimalBuildingMenuView implements Screen {
    private final AnimalBuilding building;
    private final Stage stage;
    private final Skin skin = App.skin;

    public AnimalBuildingMenuView(AnimalBuilding building) {
        this.building = building;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        setupUI();
    }

    private void setupUI() {
        // پس‌زمینه
        Texture bgTexture = new Texture(Gdx.files.internal("background/vintage-textured-paper-background-vector.jpg"));
        Image bgImage = new Image(bgTexture);
        bgImage.setFillParent(true);
        stage.addActor(bgImage);

        // ریشه جدول
        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        // جدول دکمه‌ها
        Table menuTable = new Table();
        menuTable.defaults().width(400).height(80).pad(20);

        // دکمه Back
        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(App.currentGameGraphicView); // بازگشت به بازی
            }
        });

        menuTable.add(backButton).row();

        rootTable.add(menuTable).center().top().padTop(100);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }
}
