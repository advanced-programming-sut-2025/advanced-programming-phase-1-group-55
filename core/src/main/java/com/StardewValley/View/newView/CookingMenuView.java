package com.StardewValley.View.newView;

import com.StardewValley.Controller.CookingMenuController;
import com.StardewValley.enums.CookingItemType;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.Item.ItemType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CookingMenuView implements Screen {
    private Stage stage;
    private Table table;
    private final Skin skin = App.skin;
    private final User user;
    private final CookingMenuController controller;
    private TextButton backBtn;
    private Dialog currentFridgeDialog;

    public CookingMenuView(CookingMenuController controller, User user) {
        this.controller = controller;
        this.user = user;
        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        table = new Table();
        table.setFillParent(true);
        ScrollPane scrollPane = new ScrollPane(table, skin);
        scrollPane.setFillParent(true);
        stage.addActor(scrollPane);
        backBtn = new TextButton("Back", skin);
        Table fridgeCell = new Table();
        String fridgeImagePath = "Special_item/Mini-Fridge.png";
        com.badlogic.gdx.files.FileHandle fridgeHandle = Gdx.files.internal(fridgeImagePath);
        if (fridgeHandle.exists()) {
            Texture fridgeTex = new Texture(fridgeHandle);
            Image fridgeImage = new Image(new TextureRegionDrawable(new TextureRegion(fridgeTex)));
            fridgeImage.setSize(100, 120);
            fridgeCell.add(fridgeImage).width(100).height(120);
        } else {
            Label fridgeLabel = new Label("Fridge", skin);
            fridgeCell.add(fridgeLabel).pad(20);
        }
        fridgeCell.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showFridgeDialog();
            }
        });
        final int columns = 4;
        int colCount = 0;
        table.add(fridgeCell).colspan(columns).center().pad(10);
        table.row();
        Set<CookingItemType> learned = new HashSet<>(user.getBackPack().getCookingRecipes());
        for (final CookingItemType recipe : CookingItemType.values()) {
            String itemName = recipe.getProductName().name();
            String[] parts = itemName.split("_");
            StringBuilder fileNameBuilder = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                String part = parts[i].toLowerCase();
                fileNameBuilder.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1));
                if (i < parts.length - 1) fileNameBuilder.append("_");
            }
            String fileName = fileNameBuilder.toString() + ".png";
            String imagePath = "Recipe/" + fileName;
            boolean isUnlocked = learned.contains(recipe);
            com.badlogic.gdx.files.FileHandle handle = Gdx.files.internal(imagePath);
            Table cell = new Table();
            if (handle.exists()) {
                Texture texture = new Texture(handle);
                Image image = new Image(new TextureRegionDrawable(new TextureRegion(texture)));
                image.setSize(48, 48);
                cell.add(image).width(48).height(48);
                cell.row();
                String displayName = recipe.getProductName().getDisplayName();
                Label label = new Label(displayName, skin);
                cell.add(label).padTop(5);
                if (!isUnlocked) {
                    image.setColor(Color.GRAY);
                    label.setColor(Color.GRAY);
                }
                cell.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (isUnlocked) {
                            controller.handleRecipeClicked(recipe);
                        }
                    }
                });
            } else {
                String displayName = recipe.getProductName().getDisplayName();
                TextButton txtBtn = new TextButton(displayName, skin);
                if (!isUnlocked) {
                    txtBtn.setDisabled(true);
                    txtBtn.getLabel().setColor(Color.GRAY);
                }
                txtBtn.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (isUnlocked) {
                            controller.handleRecipeClicked(recipe);
                        }
                    }
                });
                cell.add(txtBtn).width(120).height(50);
            }
            table.add(cell).pad(10);
            colCount++;
            if (colCount % columns == 0) table.row();
        }
        table.row().padTop(20);
        table.add(backBtn).colspan(columns).center().padBottom(10);
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.gameApp.setScreen(App.currentGameGraphicView);
            }
        });
    }



    private void showFridgeDialog() {
        if (currentFridgeDialog != null) {
            currentFridgeDialog.hide();
        }
        final Dialog dialog = new Dialog("Refrigerator", skin);
        Table content = new Table();
        content.pad(10);
        content.add(new Label("Fridge Contents:", skin)).left().row();
        java.util.ArrayList<com.StardewValley.model.CookingItems.CookingItem> fridgeItems = user.getRefrigerator();
        if (fridgeItems == null || fridgeItems.isEmpty()) {
            content.add(new Label(" (Empty)", skin)).left().row();
        } else {
            for (com.StardewValley.model.CookingItems.CookingItem ci : fridgeItems) {
                String name = ci.getItemType().getDisplayName();
                int quantity = ci.getNumber();
                content.add(new Label(name + " x" + quantity, skin)).left().row();
            }
        }
        content.add(new Label("\nBackpack Items:", skin)).left().row();
        Map<String, Item> inventory = user.getBackPack().getInventory();
        if (inventory == null || inventory.isEmpty()) {
            content.add(new Label(" (No items in backpack)", skin)).left().row();
        } else {
            for (Map.Entry<String, Item> entry : inventory.entrySet()) {
                Item item = entry.getValue();
                ItemType itemType = item.getItemType();
                int qty = item.getNumber();
                Table row = new Table();
                Label label = new Label(itemType.getDisplayName() + " x" + qty, skin);
                TextButton addBtn = new TextButton("Add", skin);
                addBtn.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        controller.moveItemToFridge(itemType);
                        dialog.hide();
//                        showFridgeDialog();
                    }
                });
                TextButton eatBtn = new TextButton("Eat", skin);
                eatBtn.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        controller.eatInventoryItem(itemType);
                        dialog.hide();
//                        showFridgeDialog();
                    }
                });
                row.add(label).left().padRight(10);
                row.add(addBtn).right().padRight(5);
                row.add(eatBtn).right();

                content.add(row).left().row();
            }
        }

        ScrollPane scrollPane = new ScrollPane(content, skin);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);

        dialog.getContentTable().add(scrollPane).width(850).height(350);
        dialog.button("Close");
        dialog.show(stage);
        currentFridgeDialog = dialog;
    }
    public void refreshFridgeDialog() {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                showFridgeDialog();
            }
        });
    }




    public void showEatingAnimation(ItemType itemType) {
        final Dialog eatDialog = new Dialog("", skin);
        Table content = new Table();
        content.pad(20);
        String fileName = itemType.name().toLowerCase();
        fileName = Character.toUpperCase(fileName.charAt(0)) + fileName.substring(1) + ".png";
        String path = "Recipe/" + fileName;
        if (Gdx.files.internal(path).exists()) {
            Texture tex = new Texture(Gdx.files.internal(path));
            Image image = new Image(new TextureRegionDrawable(new TextureRegion(tex)));
            image.setSize(64, 64);
            content.add(image).center().row();
        }
        Label eatingLabel = new Label("Eating...", skin);
        content.add(eatingLabel).padTop(10).center();

        eatDialog.getContentTable().add(content).center();
        eatDialog.show(stage);
        Gdx.app.postRunnable(() -> {
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    Gdx.app.postRunnable(() -> eatDialog.hide());
                } catch (InterruptedException ignored) {}
            }).start();
        });
    }

    public void setErrorMessage(String error) {
        Dialog dialog = new Dialog("Error", skin);
        dialog.text(error);
        dialog.button("OK");
        dialog.show(stage);
    }
    public void setSuccessMessage(String message) {
        new Thread(() -> {
            try {
                Thread.sleep(3100);
                Gdx.app.postRunnable(() -> {
                    Dialog dialog = new Dialog("Success", skin);
                    dialog.text(message);
                    dialog.button("OK");
                    dialog.show(stage);
                });
            } catch (InterruptedException ignored) {}
        }).start();
    }













    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        if (stage != null) {
            stage.act(delta);
            stage.draw();
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        if (stage != null) {
            stage.dispose();
        }
    }
}
