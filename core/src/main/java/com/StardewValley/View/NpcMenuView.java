package com.StardewValley.View;

import com.StardewValley.Controller.NpcMenuController;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class NpcMenuView implements Screen {
    private NpcMenuController controller;
    private Npc npc;
    private User player;
    private GameMap map;
    private Stage stage;
    private final Skin skin;

    public NpcMenuView(NpcMenuController controller, Npc npc, User player, GameMap map) {
        this.controller = controller;
        this.npc = npc;
        this.player = player;
        this.map = map;
        this.stage = new Stage(new ScreenViewport());
        this.skin = App.getSkin();
        controller.setView(this);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        // عنوان اصلی بالای صفحه
        Label titleLabel = new Label("NPC Menu", skin);
        titleLabel.setFontScale(2f);
        rootTable.top().padTop(20);
        rootTable.add(titleLabel).colspan(3).center().padBottom(30);
        rootTable.row();

        // ساخت منوها
        Table leftMenu = createMenuBox("Friendship");
        Table middleMenu = createMenuBox("Quests");
        Table rightMenu = createMenuBox("Send Gifts");

        rootTable.row().expand().fill();
        rootTable.add(leftMenu).expand().fill().pad(10);
        rootTable.add(middleMenu).expand().fill().pad(10);
        rootTable.add(rightMenu).expand().fill().pad(10);

        // دکمه Back
        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        });

        rootTable.row().colspan(3).padTop(20);
        rootTable.add(backButton).center().padBottom(20);
    }

    private Table createMenuBox(String title) {
        Table menu = new Table(skin);
        menu.top();

        // عنوان هر بخش
        Label label = new Label(title, skin);
        label.setFontScale(1.5f);
        menu.add(label).center().padTop(10).padBottom(20);
        menu.row();

        // گزینه‌های هر بخش
        menu.add(new Label("گزینه ۱", skin)).pad(5);
        menu.row();
        menu.add(new Label("گزینه ۲", skin)).pad(5);
        menu.row();
        menu.add(new Label("گزینه ۳", skin)).pad(5);

        return menu;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.9f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    public NpcMenuController getController() { return controller; }
    public void setController(NpcMenuController controller) { this.controller = controller; }
    public Npc getNpc() { return npc; }
    public void setNpc(Npc npc) { this.npc = npc; }
    public User getPlayer() { return player; }
    public void setPlayer(User player) { this.player = player; }
    public GameMap getMap() { return map; }
    public void setMap(GameMap map) { this.map = map; }
    public Stage getStage() { return stage; }
    public void setStage(Stage stage) { this.stage = stage; }
}
