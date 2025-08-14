package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientLeaderboardController;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.LeaderboardEntry;
import com.StardewValley.Common.model.LeaderboardUpdate;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.List;

public class LeaderboardView extends ScreenAdapter {

    private Stage stage;
    private Skin skin = App.skin;
    private Table leaderboardTable;
    private final ClientLeaderboardController controller = ClientLeaderboardController.getInstance();

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        // دکمه برگشت
        TextButton backBtn = new TextButton("Back", skin);
        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                App.getGameApp().setScreen(new MainMenuScreen());
            }
        });

        // جدول نمایش لیدربرد
        leaderboardTable = new Table(skin);
        leaderboardTable.defaults().pad(5);

        root.add(new Label("Leaderboard", skin)).colspan(3).padBottom(20).row();
        root.add(leaderboardTable).colspan(3).row();
        root.add(backBtn).colspan(3).padTop(20);

        // ثبت ویو در کنترلر
        controller.attachView(this);
    }

    public void refresh(LeaderboardUpdate update) {
        leaderboardTable.clear();
        List<LeaderboardEntry> entries = update.getEntries();

        // هدر جدول
        leaderboardTable.add("Rank").padRight(20);
        leaderboardTable.add("Player").padRight(100);
        leaderboardTable.add(update.getCriteria().name()).row();

        // داده‌ها
        int rank = 1;
        for (LeaderboardEntry entry : entries) {
            leaderboardTable.add(String.valueOf(rank++));
            leaderboardTable.add(entry.getPlayerName());
            leaderboardTable.add(String.valueOf(entry.getScore())).row();
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide() {
        controller.detachView();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
