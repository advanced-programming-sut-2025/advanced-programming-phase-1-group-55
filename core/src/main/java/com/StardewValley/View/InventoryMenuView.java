package com.StardewValley.View;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Map;

public class InventoryMenuView implements Screen {
    private Stage stage;
    private Skin skin;
    private User user;
    private Table table;
    private TextButton backBtn;
    private TextButton useBtn;
    private Item selectedItem;
    private Label itemInfoLabel;
    private Image backgroundImage;
    private ImageButton trashButton;
    private Label messageLabel;


    public InventoryMenuView(User user) {
        this.user = user;
        this.skin = App.getSkin();
        this.table = new Table();
        this.backBtn = new TextButton("Back", skin);
        this.useBtn = new TextButton("Use", skin);
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        try {
            Texture bg = new Texture(Gdx.files.internal("background/vintage-textured-paper-background-vector.jpg"));
            backgroundImage = new Image(bg);
            backgroundImage.setFillParent(true);
            stage.addActor(backgroundImage);
        } catch (Exception e) {
            System.out.println("Background not loaded: " + e.getMessage());
        }

        stage.addActor(table);

        table.setFillParent(true);

        try {
            rebuildInventoryDisplay();
        } catch (Exception e) {
            System.out.println("Error in rebuildInventoryDisplay: " + e.getMessage());
            e.printStackTrace();
        }
        Texture trashTexture = AssetManager.TrashCan.getTexture();
        ImageButton.ImageButtonStyle trashStyle = new ImageButton.ImageButtonStyle();
        trashStyle.imageUp = new TextureRegionDrawable(new TextureRegion(trashTexture));
        trashButton = new ImageButton(trashStyle);

        messageLabel = new Label("", skin);

    }


    private void rebuildInventoryDisplay() {
        table.clear();

        if (user == null || user.getBackPack() == null || user.getBackPack().getInventory() == null) {
            table.add(new Label("Inventory is not available", skin)).row();
            table.add(backBtn).padTop(20);
            backBtn.addListener(backListener());
            return;
        }

        Map<String, Item> inventory = user.getBackPack().getInventory();
        if (inventory == null || inventory.isEmpty()) {
            table.add(new Label("Inventory is empty.", skin)).row();
            table.add(backBtn).padTop(20);
            backBtn.addListener(backListener());
            return;
        }

        table.add(new Label("Your Inventory", skin)).padBottom(20).colspan(inventory.size()).row();

        for (Item item : inventory.values()) {
            Sprite sprite = new Sprite(item.getItemType().getTexture());
            if (item == selectedItem) {
                sprite.setColor(1f, 1f, 0.5f, 1f);
                sprite.setScale(1.3f);
            }

            Image itemImage = new Image(new SpriteDrawable(sprite));
            itemImage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    selectedItem = item;
                    rebuildInventoryDisplay();
                }
            });

            table.add(itemImage).pad(10).width(64).height(64);
        }

        table.row();

        itemInfoLabel = new Label(
            selectedItem != null
                ? "Item: " + selectedItem.getItemType().toString() + " | Count: " + selectedItem.getNumber()
                : "Select an item to see details",
            skin
        );
        table.add(itemInfoLabel).colspan(inventory.size()).padTop(20).row();

        table.add(useBtn).padTop(15).colspan(inventory.size()).row();
        table.add(backBtn).padTop(10).colspan(inventory.size());

        useBtn.addListener(useListener());
        backBtn.addListener(backListener());
        table.add(trashButton).padTop(10).colspan(inventory.size()).row();
        table.add(messageLabel).padTop(10).colspan(inventory.size()).row();
        trashButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (selectedItem != null) {
                    user.getBackPack().removeItemFromInventory(selectedItem);
                    selectedItem = null;
                    messageLabel.setColor(Color.GREEN);
                    messageLabel.setText("Item successfully removed!");
                    rebuildInventoryDisplay();
                } else {
                    messageLabel.setColor(Color.RED);
                    messageLabel.setText("Please select an item to remove.");
                }
            }
        });

    }

    private ClickListener backListener() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(new PauseMenuView(new com.StardewValley.Controller.PauseMenuController(), user));
            }
        };
    }

    private ClickListener useListener() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (selectedItem != null) {
                    //use inventory chikar mikone joz to satl ashghal andakhtan
                    System.out.println("Used: " + selectedItem.getItemType());
                }
            }
        };
    }

    @Override public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }
}
