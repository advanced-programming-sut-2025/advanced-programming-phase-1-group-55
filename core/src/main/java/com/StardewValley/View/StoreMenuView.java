package com.StardewValley.View;

import com.StardewValley.Controller.StoreMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
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

public class StoreMenuView implements Screen {
    private StoreMenuController controller;
    private Stage stage;
    private Store store;
    private User user;
    private GameMap map;
    private Skin skin;
    private Button backButton;
    private Button purchaseButton;
    private String sortBy;
    private Map<String, Product> products;

    private SelectBox<String> sortSelectBox;
    private TextButton sortConfirmButton;
    private  Product selectedProduct;

    public StoreMenuView(StoreMenuController controller, User user, GameMap map, String sortBy, Store store) {
        this.controller = controller;
        controller.setView(this);
        this.user = user;
        this.map = map;
        this.sortBy = sortBy;
        this.store = store;
        this.products = store.getProductsOfStore();
        this.skin = App.getSkin();
        this.stage = new Stage(new ScreenViewport());
        this.backButton = new TextButton("Back", skin);
        this.purchaseButton = new TextButton("Purchase", skin);
        this.sortConfirmButton = new TextButton("Confirm", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        Texture backgroundTexture = AssetManager.Wood_background2.getTexture();
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);


        Table titleTable = new Table();
        Label title = new Label("Welcome to " + store.getDisplayName(), skin);
        title.setFontScale(1.4f);

        Texture heartTexture = AssetManager.heart.getTexture();
        Image heartImage = new Image(heartTexture);
        heartImage.setSize(85, 85);

        titleTable.add(title).padRight(10);
        titleTable.add(heartImage).size(85);
        mainTable.add(titleTable).colspan(2).center().pad(20);
        mainTable.row();

        sortSelectBox = new SelectBox<>(skin);
        sortSelectBox.setItems("All", "Available");
        sortSelectBox.setSelected(sortBy);




        Table sortTable = new Table();
        sortTable.add(new Label("show products:", skin)).padRight(10);
        sortTable.add(sortSelectBox).width(150).padRight(10);
        sortTable.add(sortConfirmButton).width(100);
        mainTable.add(sortTable).colspan(2).center().pad(10);
        mainTable.row();

        Table productTable = new Table();
        int columnCount = 3;
        int i = 0;

        Map<TextButton, Product> buttonProductMap = new HashMap<>();
        final TextButton[] selectedButton = {null};


        for (Map.Entry<String, Product> entry : products.entrySet()) {
            Product product = entry.getValue();


            if (sortBy.equals("Available") && !controller.productIsAvailable(product)) continue;

            String productName = product.getItem().getItemType().getDisplayName();
            int price = product.getGoldCost();

            TextButton productButton = new TextButton(productName + "\nPrice: " + price, skin);
            productButton.getLabel().setFontScale(0.8f);
            productButton.pad(10);

            if (!controller.productIsAvailable(product)) {
                productButton.setColor(Color.GRAY);
                productButton.setDisabled(true);
            } else {
                productButton.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (selectedButton[0] != null) {
                            selectedButton[0].setColor(Color.WHITE);
                        }
                        selectedButton[0] = productButton;
                        selectedProduct = product;
                        productButton.setColor(Color.CYAN);
                    }
                });
            }

            productTable.add(productButton).pad(10).width(150).height(100);
            i++;
            if (i % columnCount == 0) {
                productTable.row();
            }
        }

        ScrollPane scrollPane = new ScrollPane(productTable, skin);
        scrollPane.setScrollingDisabled(true, false);
        mainTable.add(scrollPane).colspan(2).expand().fill().pad(20);
        mainTable.row();


        Table buttonTable = new Table();
        buttonTable.add(backButton).pad(10).width(140).height(60);
        buttonTable.add(purchaseButton).pad(10).width(140).height(60);
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

    // Getters & Setters
    public StoreMenuController getController() { return controller; }
    public void setController(StoreMenuController controller) { this.controller = controller; }
    public Stage getStage() { return stage; }
    public void setStage(Stage stage) { this.stage = stage; }
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public GameMap getMap() { return map; }
    public void setMap(GameMap map) { this.map = map; }
    public Skin getSkin() { return skin; }
    public void setSkin(Skin skin) { this.skin = skin; }
    public Button getBackButton() { return backButton; }
    public void setBackButton(Button backButton) { this.backButton = backButton; }
    public Button getPurchaseButton() { return purchaseButton; }
    public void setPurchaseButton(Button purchaseButton) { this.purchaseButton = purchaseButton; }
    public String getSortBy() { return sortBy; }
    public void setSortBy(String sortBy) { this.sortBy = sortBy; }
    public Map<String, Product> getProducts() { return products; }
    public void setProducts(Map<String, Product> products) { this.products = products; }

    public SelectBox<String> getSortSelectBox() {
        return sortSelectBox;
    }

    public void setSortSelectBox(SelectBox<String> sortSelectBox) {
        this.sortSelectBox = sortSelectBox;
    }

    public TextButton getSortConfirmButton() {
        return sortConfirmButton;
    }

    public void setSortConfirmButton(TextButton sortConfirmButton) {
        this.sortConfirmButton = sortConfirmButton;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
}
