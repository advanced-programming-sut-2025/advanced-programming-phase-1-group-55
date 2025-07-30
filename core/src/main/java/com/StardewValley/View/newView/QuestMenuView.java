package com.StardewValley.View.newView;

import com.StardewValley.Controller.PauseMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.NPC.Quest;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class QuestMenuView implements Screen {
    private Stage stage;
    private Viewport viewport;
    private Table table;
    private TextButton backButton;
    private final Skin skin;

    public QuestMenuView() {
        this.skin = App.skin;
        backButton = new TextButton("Back", skin);
        stage = new Stage(new ScreenViewport());

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Texture backgroundTexture = AssetManager.QuestBackground.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        Label titleLabel = new Label("Your Quests", skin);
        titleLabel.setColor(Color.BLACK);
        rootTable.add(titleLabel).center().padTop(20).padBottom(20).row();


        Table scrollContent = new Table();
        scrollContent.top().center().pad(10);
        scrollContent.defaults().padBottom(10).width(600);

        for (Quest quest : App.currentGameGraphicView.getPlayer().getQuest().values()) {
            Label label = new Label(quest.toString(), skin);
            label.setWrap(true);
            label.setColor(Color.BLACK);
            scrollContent.add(label).expandX().fillX().row();
        }

        ScrollPane scrollPane = new ScrollPane(scrollContent, skin);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);

        rootTable.add(scrollPane).expand().fill().padLeft(20).padRight(20).row();

        rootTable.add(backButton).padTop(20).padBottom(30).center();

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(new PauseMenuView(new PauseMenuController(), App.currentGameGraphicView.getPlayer()));
            }
        });
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public void setBackButton(TextButton backButton) {
        this.backButton = backButton;
    }

    public Skin getSkin() {
        return skin;
    }



    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
        stage.dispose();

    }
}
