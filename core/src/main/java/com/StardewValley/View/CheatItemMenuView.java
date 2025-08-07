package com.StardewValley.View;

import com.StardewValley.Controller.CheatItemMenuController;
import com.StardewValley.Common.enums.AssetManager;
import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Item.Item;
import com.StardewValley.Common.model.Item.ItemType;
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

public class CheatItemMenuView implements Screen {
    private CheatItemMenuController controller;
    private Stage stage;

    private Skin skin;
    private Button backButton;
    private Button sellButton;

    private  Item selectedItem;

    public CheatItemMenuView(CheatItemMenuController controller) {
        this.controller = controller;
        controller.setView(this);
        this.skin = App.skin;
        this.stage = new Stage(new ScreenViewport());
        this.backButton = new TextButton("Back", skin);
        this.sellButton = new TextButton("Select", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        Texture backgroundTexture = AssetManager.CheatBackground.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);


        Table titleTable = new Table();
        String titleText = "Add Item";
        Texture imageTexture =new Texture(Gdx.files.internal("Tools/36_Backpack.png"));
        Label title = new Label(titleText, skin);
        title.setFontScale(1.4f);

        Image heartImage = new Image(imageTexture);
        heartImage.setSize(85, 85);

        titleTable.add(title).padRight(10);
        titleTable.add(heartImage).size(85);
        mainTable.add(titleTable).colspan(2).center().pad(20);
        mainTable.row();

        Table itemTable = new Table();
        int columnCount = 3;
        int i = 0;

        final TextButton[] selectedButton = {null};


        for (ItemType itemType : ItemType.values()) {
            Item item = new Item(itemType);

            String itemName = item.getItemType().getDisplayName();
            int price = item.getPrice();

            TextButton itemButton = new TextButton(itemName, skin);
            itemButton.getLabel().setFontScale(0.65f);
            itemButton.pad(10);

            itemButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (selectedButton[0] != null) {
                        selectedButton[0].setColor(Color.WHITE);
                    }
                    selectedButton[0] = itemButton;
                    selectedItem = item;
                    itemButton.setColor(Color.MAGENTA);
                }
            });

            itemTable.add(itemButton).pad(10).width(150).height(100);
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
        buttonTable.add(sellButton).pad(10).width(140).height(60);
        mainTable.add(buttonTable).colspan(2).center().padBottom(20);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        controller.handleButton();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void dispose() {
        stage.dispose();
    }

    public CheatItemMenuController getController() {
        return controller;
    }

    public void setController(CheatItemMenuController controller) {
        this.controller = controller;
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

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Button getSellButton() {
        return sellButton;
    }

    public void setSellButton(Button sellButton) {
        this.sellButton = sellButton;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }
}
