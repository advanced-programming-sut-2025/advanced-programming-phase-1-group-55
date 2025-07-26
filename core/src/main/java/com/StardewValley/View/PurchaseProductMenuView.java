package com.StardewValley.View;

import com.StardewValley.Controller.PurchaseProductMenuController;
import com.StardewValley.model.App;
import com.StardewValley.model.Map.GameMap;
import com.StardewValley.model.Store.Product;
import com.StardewValley.model.User;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class PurchaseProductMenuView implements Screen {
    private User user;
    private GameMap map;
    private Skin skin;
    private Button backButton;
    private Button purchaseButton;
    private PurchaseProductMenuController controller;
    private Stage stage;
    private Product product;

    public PurchaseProductMenuView(PurchaseProductMenuController controller, User user, GameMap map, Product product) {
        this.controller = controller;
        this.user = user;
        this.map = map;
        this.product = product;
        controller.setView(this);
        stage = new Stage();
        skin= App.getSkin();
        this.backButton = new TextButton("Back", skin);
        this.purchaseButton = new TextButton("Purchase", skin);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
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

    public Button getPurchaseButton() {
        return purchaseButton;
    }

    public void setPurchaseButton(Button purchaseButton) {
        this.purchaseButton = purchaseButton;
    }

    public PurchaseProductMenuController getController() {
        return controller;
    }

    public void setController(PurchaseProductMenuController controller) {
        this.controller = controller;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
