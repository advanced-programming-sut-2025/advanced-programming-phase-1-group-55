package com.StardewValley.Client.View;

import com.StardewValley.Server.Controller.ChooseArtisanController;
import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Artisan.ArtisanMachineType;

import com.StardewValley.Common.model.Map.GameMap;
import com.StardewValley.Common.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

public class ChooseArtisanMenuView implements Screen {
    private User player;
    private GameMap map;
    private TextButton backButton;
    private TextButton confirmButton;
    private Stage stage;
    private Skin skin;
    private ArtisanMachineType selected=ArtisanMachineType.BEER;
    private ChooseArtisanController controller;

    public ChooseArtisanMenuView(User player, GameMap map, ChooseArtisanController controller) {
        this.player = player;
        this.map = map;
        this.controller = controller;
        this.skin = App.skin;
        this.stage = new Stage();
        this.backButton = new TextButton("Back", skin);
        this.confirmButton = new TextButton("Confirm", skin);
        controller.setView(this);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();


        Texture backgroundTexture = AssetManager.blueBackground.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);


        Table titleTable = new Table();
        Label title = new Label("Choose one of these machines", skin);
        title.setFontScale(1.4f);
        Texture gearTexture = AssetManager.gear.getTexture();
        Image gearImage = new Image(gearTexture);
        gearImage.setSize(85, 85);
        titleTable.add(title).padRight(10);
        titleTable.add(gearImage).size(85);
        mainTable.add(titleTable).colspan(2).center().pad(20);
        mainTable.row();


        final Drawable defaultBackground = createColorDrawable(Color.LIGHT_GRAY);
        final Drawable selectedBackground = createColorDrawable(Color.GREEN);

        Table itemTable = new Table();
        int columnCount = 3;
        int i = 0;
        final Table[] selectedTable = {null};

        for (ArtisanMachineType item : ArtisanMachineType.values()) {
            final ArtisanMachineType currentItem = item;
            Texture itemTexture = currentItem.getTexture();
            Image itemImage = new Image(itemTexture);
            itemImage.setSize(64, 64);

            Table itemContainer = new Table();
            itemContainer.setBackground(defaultBackground);
            itemContainer.add(itemImage).padBottom(5).row();

            itemContainer.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (selectedTable[0] != null) {
                        selectedTable[0].setBackground(defaultBackground);
                    }
                    selectedTable[0] = itemContainer;
                    selected = currentItem;
                    itemContainer.setBackground(selectedBackground);
                }
            });

            itemTable.add(itemContainer).pad(10).width(160).height(140);
            i++;
            if (i % columnCount == 0) {
                itemTable.row();
            }
        }

        ScrollPane scrollPane = new ScrollPane(itemTable, skin);
        scrollPane.setScrollingDisabled(true, false);
        mainTable.add(scrollPane).colspan(2).expand().fill().pad(20);
        mainTable.row();


        Table buttonTable = new Table();
        buttonTable.add(backButton).pad(10).width(140).height(60);
        buttonTable.add(confirmButton).pad(10).width(140).height(60);
        mainTable.add(buttonTable).colspan(2).center().padBottom(20);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        controller.handleButton();
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}


    private Drawable createColorDrawable(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegionDrawable(new TextureRegion(texture));
    }


    public User getPlayer() { return player; }
    public void setPlayer(User player) { this.player = player; }
    public GameMap getMap() { return map; }
    public void setMap(GameMap map) { this.map = map; }
    public TextButton getBackButton() { return backButton; }
    public TextButton getConfirmButton() { return confirmButton; }
    public Stage getStage() { return stage; }
    public Skin getSkin() { return skin; }
    public ChooseArtisanController getController() { return controller; }
    public ArtisanMachineType getSelected() { return selected; }
}
