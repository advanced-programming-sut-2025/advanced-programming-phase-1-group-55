package com.StardewValley.View;

import com.StardewValley.Controller.BuyAnimalMenuController;
import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.Animal.FarmAnimalType;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BuyAnimalMenuView implements Screen {

    private final Stage stage;
    private final Skin skin;
    private final BuyAnimalMenuController controller;
    private final User user;
    private final Table table;
    private final Label messageLabel;
    private final ScrollPane scrollPane;

//    public BuyAnimalMenuController controller;

    public BuyAnimalMenuView(BuyAnimalMenuController controller, User user) {
        this.controller = controller;
        this.user = user;
//        this.controller = new BuyAnimalMenuController(user);
        this.skin = App.skin;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        scrollPane = new ScrollPane(table, skin);
        messageLabel = new Label("", skin);

        buildUI();
    }

    private void buildUI() {
        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        Label title = new Label("Buy Animals", skin);
        title.setFontScale(1.5f);
        root.add(title).pad(10).colspan(2);
        root.row();

        for (FarmAnimalType animalType : FarmAnimalType.values()) {
            TextButton buyButton = new TextButton(animalType.getName(), skin);
            buyButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    String result = controller.tryBuyAnimal(animalType);
                    messageLabel.setText(result);
                }
            });
            table.add(buyButton).pad(5).row();
        }

        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);
        scrollPane.setForceScroll(false, true);

        root.add(scrollPane).expand().fill().colspan(2).pad(10);
        root.row();

        root.add(messageLabel).colspan(2).pad(10);

        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        });
        root.add(backButton).colspan(2).pad(10);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
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
}
