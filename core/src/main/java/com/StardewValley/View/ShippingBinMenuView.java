package com.StardewValley.View;

import com.StardewValley.Controller.ShippingBinMenuController;
import com.StardewValley.Controller.StoreMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.Store.Store;
import com.StardewValley.model.User;
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

import java.util.HashMap;
import java.util.Map;

public class ShippingBinMenuView implements Screen {
    private ShippingBinMenuController controller;
    private Stage stage;
    private User user;
    private GameMap map;
    private String from;
    private Skin skin;
    private Button backButton;
    private Button sellButton;
    private Map<String, Item> items;

    private  Item selectedItem;

    public ShippingBinMenuView(ShippingBinMenuController controller, User user, GameMap map, String from) {
        this.controller = controller;
        controller.setView(this);
        this.from = from;
        this.user = user;
        this.map = map;
        this.items = user.getBackPack().getInventory();
        this.skin = App.getSkin();
        this.stage = new Stage(new ScreenViewport());
        this.backButton = new TextButton("Back", skin);
        this.sellButton = new TextButton("Sell", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        Texture backgroundTexture = AssetManager.Stone_background.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);


        Table titleTable = new Table();
        Label title = new Label("Shipping Bin Menu", skin);
        title.setFontScale(1.4f);

        Texture heartTexture = AssetManager.TrashCan.getTexture();
        Image heartImage = new Image(heartTexture);
        heartImage.setSize(85, 85);

        titleTable.add(title).padRight(10);
        titleTable.add(heartImage).size(85);
        mainTable.add(titleTable).colspan(2).center().pad(20);
        mainTable.row();








        Table itemTable = new Table();
        int columnCount = 3;
        int i = 0;

        Map<TextButton, Item> buttonItemMap = new HashMap<>();
        final TextButton[] selectedButton = {null};


        for (Map.Entry<String, Item> entry : items.entrySet()) {
           Item item = entry.getValue();



            String itemName = item.getItemType().getDisplayName();
            int price = item.getPrice();

            TextButton itemButton = new TextButton(itemName + "\nPrice: " + price+"\nQuantity: "+item.getNumber(), skin);
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
                        itemButton.setColor(Color.GREEN);}
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


    public Stage getStage() { return stage; }
    public void setStage(Stage stage) { this.stage = stage; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public GameMap getMap() { return map; }
    public void setMap(GameMap map) { this.map = map; }
    public Skin getSkin() { return skin; }
    public void setSkin(Skin skin) { this.skin = skin; }
    public Button getBackButton() { return backButton; }
    public void setBackButton(Button backButton) { this.backButton = backButton; }
    public Button getSellButton() { return sellButton; }
    public void setPurchaseButton(Button sellButton) { this.sellButton = sellButton; }
    public Map<String, Item> getItems() { return items; }
    public void setItems(Map<String, Item> items) { this.items = items; }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public ShippingBinMenuController getController() {
        return controller;
    }

    public void setController(ShippingBinMenuController controller) {
        this.controller = controller;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSellButton(Button sellButton) {
        this.sellButton = sellButton;
    }
}
