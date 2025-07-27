package com.StardewValley.View;

import com.StardewValley.Controller.NpcMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class NpcMenuView implements Screen {
    private NpcMenuController controller;
    private Npc npc;
    private User player;
    private GameMap map;
    private Stage stage;
    private final Skin skin;
    private TextButton backButton;

    public NpcMenuView(NpcMenuController controller, Npc npc, User player, GameMap map) {
        this.controller = controller;
        this.npc = npc;
        this.player = player;
        this.map = map;
        this.stage = new Stage(new ScreenViewport());
        this.skin = App.getSkin();
        controller.setView(this);
        backButton = new TextButton("Back", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Texture backgroundTexture = AssetManager.PinkBackground.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        Label titleLabel = new Label(npc.getType().getDisplayName(), skin);
        titleLabel.setFontScale(2f);
        rootTable.top().padTop(20);
        rootTable.add(titleLabel).colspan(5).center().padBottom(30);
        rootTable.row();

        Table leftMenu = createMenuBox("Friendship");
        Table middleMenu = createMenuBox("Quests");
        Table rightMenu = createMenuBox("Send Gifts");


        Image verticalLine1 = new Image(createLineDrawable(2, 1, Color.GRAY));
        Image verticalLine2 = new Image(createLineDrawable(2, 1, Color.GRAY));

        rootTable.row().expand().fill();
        rootTable.add(leftMenu).expand().fill().pad(10);
        rootTable.add(verticalLine1).width(2).fillY().padTop(10).padBottom(10);
        rootTable.add(middleMenu).expand().fill().pad(10);
        rootTable.add(verticalLine2).width(2).fillY().padTop(10).padBottom(10);
        rootTable.add(rightMenu).expand().fill().pad(10);


        Image horizontalLine = new Image(createLineDrawable(1, 2, Color.GRAY));

        rootTable.row().colspan(5);
        rootTable.add(horizontalLine).height(2).fillX().padTop(20).padBottom(10);


        rootTable.row().colspan(5);
        rootTable.add(backButton).center().padBottom(20);
    }

    private Table createMenuBox(String title) {
        Table menu = new Table(skin);
        menu.top();

        Label label = new Label(title, skin);
        label.setFontScale(1.5f);
        menu.add(label).center().padTop(10).padBottom(20);
        menu.row();

        menu.add(new Label("گزینه ۱", skin)).pad(5);
        menu.row();
        menu.add(new Label("گزینه ۲", skin)).pad(5);
        menu.row();
        menu.add(new Label("گزینه ۳", skin)).pad(5);

        return menu;
    }

    private TextureRegionDrawable createLineDrawable(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegionDrawable(new TextureRegion(texture));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        controller.handleButtonClicked();
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

    public Skin getSkin() {
        return skin;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public void setBackButton(TextButton backButton) {
        this.backButton = backButton;
    }
}
