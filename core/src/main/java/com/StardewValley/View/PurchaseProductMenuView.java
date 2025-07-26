package com.StardewValley.View;

import com.StardewValley.Controller.PurchaseProductMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;

public class PurchaseProductMenuView implements Screen {
    private User user;
    private GameMap map;
    private Skin skin;
    private Button backButton;
    private Button purchaseButton;
    private PurchaseProductMenuController controller;
    private Stage stage;
    private Product product;
    private Label totalPriceLabel;
    private final int[] quantity = {1};
    private StoreMenuView storeMenuView;
    private int totalPrice;

    public PurchaseProductMenuView(PurchaseProductMenuController controller, User user, GameMap map, Product product, StoreMenuView storeMenuView) {
        this.controller = controller;
        this.user = user;
        this.map = map;
        this.product = product;
        this.controller.setView(this);
        this.skin = App.getSkin();
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        this.storeMenuView = storeMenuView;

        this.backButton = new TextButton("Back", skin);
        this.purchaseButton = new TextButton("Purchase", skin);
    }

    @Override
    public void show() {
        Table rootTable = new Table();
        rootTable.setFillParent(true);
        rootTable.top().padTop(50);
        stage.addActor(rootTable);

        TextureRegion productImage = AssetManager.heart.getTextureRegion();
        if (productImage != null) {
            Image image = new Image(productImage);
            image.setScaling(Scaling.fit);
            rootTable.add(image).size(180, 180).colspan(2).padBottom(25).row();
        }

        Label nameLabel = new Label(product.getItem().getItemType().getDisplayName(), skin);
        nameLabel.setFontScale(1.4f);
        rootTable.add(nameLabel).colspan(2).padBottom(40).row();

        Label priceLabel = new Label("Price per unit: " + product.getGoldCost() + " G", skin);
        priceLabel.setFontScale(1.1f);
        rootTable.add(priceLabel).colspan(2).padBottom(60).row();


        Label quantityTitleLabel = new Label("Quantity:", skin);
        quantityTitleLabel.setFontScale(1.1f);

        Label quantityLabel = new Label(String.valueOf(quantity[0]), skin);
        quantityLabel.setAlignment(Align.center);
        quantityLabel.setFontScale(1.2f);

        TextButton minusButton = new TextButton("<", skin);
        minusButton.setWidth(30);
        minusButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (quantity[0] > 1) {
                    quantity[0]--;
                    quantityLabel.setText(String.valueOf(quantity[0]));
                    updateTotalPrice();
                }
            }
        });

        TextButton plusButton = new TextButton(">", skin);
        plusButton.setWidth(30);
        plusButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (quantity[0] < product.getDailyLimit()-product.getTodaySell()) {
                    quantity[0]++;
                    quantityLabel.setText(String.valueOf(quantity[0]));
                    updateTotalPrice();
                }
            }
        });

        Table quantityTable = new Table();
        quantityTable.add(minusButton).width(10).height(40).padRight(50);
        quantityTable.add(quantityLabel).width(60);
        quantityTable.add(plusButton).width(10).height(40).padLeft(50);

        rootTable.add(quantityTitleLabel).padRight(90).padBottom(100);
        rootTable.add(quantityTable).padBottom(100).row();


        totalPriceLabel = new Label("Total: " + product.getGoldCost() * quantity[0] + " G", skin);
        totalPriceLabel.setFontScale(1.2f);
        rootTable.add(totalPriceLabel).colspan(2).padTop(30).padBottom(100).row();


        Table buttonTable = new Table();
        buttonTable.add(backButton).width(130).height(55).padRight(30);
        buttonTable.add(purchaseButton).width(130).height(55);

        rootTable.add(buttonTable).colspan(2).padBottom(20).row();
    }


    private void updateTotalPrice() {
        totalPrice=product.getGoldCost() * quantity[0];
        totalPriceLabel.setText("Total: " + (totalPrice) + " G");
    }

    @Override
    public void render(float delta) {
        controller.handleInput();
        ScreenUtils.clear(0.2f, 0.2f, 0.25f, 1);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }


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
    public PurchaseProductMenuController getController() { return controller; }
    public void setController(PurchaseProductMenuController controller) { this.controller = controller; }
    public Stage getStage() { return stage; }
    public void setStage(Stage stage) { this.stage = stage; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getSelectedQuantity() { return quantity[0]; }

    public Label getTotalPriceLabel() {
        return totalPriceLabel;
    }

    public void setTotalPriceLabel(Label totalPriceLabel) {
        this.totalPriceLabel = totalPriceLabel;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public StoreMenuView getStoreMenuView() {
        return storeMenuView;
    }

    public void setStoreMenuView(StoreMenuView storeMenuView) {
        this.storeMenuView = storeMenuView;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
