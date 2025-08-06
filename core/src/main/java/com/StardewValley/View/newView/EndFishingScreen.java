package com.StardewValley.View.newView;

import com.StardewValley.model.Animal.Fishing.FishType;
import com.StardewValley.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class EndFishingScreen implements Screen {
    private final boolean won;
    private final Stage stage;
    private final Skin skin;
    private final TextButton okButton;
    private final FishType fishType;

    public EndFishingScreen(boolean won, FishType fishType) {
        this.won = won;
        this.fishType = fishType;
        this.stage = new Stage(new ScreenViewport());
        this.skin = App.skin;
        this.okButton = new TextButton("Confirm", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        // پس‌زمینه
        Texture backgroundTexture = new Texture(Gdx.files.internal(won ?
            "background/pastel-pink.jpg" :
            "background/vintage-textured-paper-background-vector.jpg"));
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        // جدول اصلی
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // پیام موفقیت یا شکست
        String status = won ? "You successfully caught the fish" : "You couldn't catch the fish, and it escaped!";
        Label titleLabel = new Label(status, skin);
        titleLabel.setColor(won ? Color.CYAN : Color.RED);
        titleLabel.setFontScale(2f);
        titleLabel.setAlignment(Align.center);

        // عکس ماهی و نام آن
        Image fishImage = new Image(fishType.getType().getTexture());
        Label fishNameLabel = new Label(fishType.getDisplayName(), skin);
        fishNameLabel.setFontScale(1.5f);
        fishNameLabel.setAlignment(Align.center);

        // دکمه تأیید
        okButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        });

        // چینش آیتم‌ها در جدول
        table.top().padTop(60);

        table.add(titleLabel).center().padBottom(80).row();
        table.add(fishImage).center().padBottom(20).row();
        table.add(fishNameLabel).center().padBottom(100).row();

        table.add(okButton).center().width(250).height(70).bottom().expandY().padBottom(40).row();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
