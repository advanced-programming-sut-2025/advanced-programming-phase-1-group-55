package com.StardewValley.Client.View;

import com.StardewValley.Client.ClientData;
import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Artisan.ArtisanMachineType;
import com.StardewValley.Common.model.Chat.EmojiType;
import com.StardewValley.Server.Controller.EmojiController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

public class ChangeDefaultEmojiMenu implements Screen {
    private Stage stage=new Stage();
    private Skin skin=App.skin;
    private EmojiType selectedEmoji = null;
    private EmojiType selectedEmojiToChange = null;
    private TextButton backBtn;
    private TextButton changeBtn;
    private EmojiController controller;
    private Drawable createColorDrawable(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegionDrawable(new TextureRegion(texture));
    }
    public ChangeDefaultEmojiMenu(EmojiType selectedEmojiToChange) {
        this.selectedEmojiToChange = selectedEmojiToChange;
        controller=new EmojiController();
        controller.setChangeDefaultEmojiMenu(this);
    }

    @Override
    public void show() {
        backBtn = new TextButton("Back", skin);
        changeBtn = new TextButton("Change", skin);
        Gdx.input.setInputProcessor(stage);
        stage.clear();


        Texture backgroundTexture = new Texture(Gdx.files.internal("background/vintage-textured-paper-background-vector.jpg"));
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);


        Table titleTable = new Table();
        Label title = new Label("Choose one of these emojis", skin);
        title.setFontScale(1.4f);
        Texture gearTexture = new Texture(Gdx.files.internal("Emoji/Emojis096.png"));
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

        for (EmojiType item : EmojiType.values()) {
            final EmojiType currentItem = item;
            Texture itemTexture = new Texture(item.getPath());
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
                    selectedEmoji = currentItem;
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
        buttonTable.add(backBtn).pad(10).width(140).height(60);
        buttonTable.add(changeBtn).pad(10).width(140).height(60);
        mainTable.add(buttonTable).colspan(2).center().padBottom(20);
    }






    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(v);
        stage.draw();
        controller.handleButton();
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

    public EmojiType getSelectedEmoji() {
        return selectedEmoji;
    }

    public void setSelectedEmoji(EmojiType selectedEmoji) {
        this.selectedEmoji = selectedEmoji;
    }

    public EmojiType getSelectedEmojiToChange() {
        return selectedEmojiToChange;
    }

    public void setSelectedEmojiToChange(EmojiType selectedEmojiToChange) {
        this.selectedEmojiToChange = selectedEmojiToChange;
    }

    public TextButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(TextButton backBtn) {
        this.backBtn = backBtn;
    }

    public TextButton getChangeBtn() {
        return changeBtn;
    }

    public void setChangeBtn(TextButton changeBtn) {
        this.changeBtn = changeBtn;
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

    }
}
