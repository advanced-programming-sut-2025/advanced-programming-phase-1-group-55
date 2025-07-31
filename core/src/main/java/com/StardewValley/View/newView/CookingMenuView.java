package com.StardewValley.View.newView;
import com.StardewValley.Controller.CookingMenuController;
import com.StardewValley.enums.CookingItemType;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.HashSet;
import java.util.Set;




public class CookingMenuView implements Screen {
    private Stage stage;
    private Table table;
    private final Skin skin = App.skin;
    private final User user;
    private final CookingMenuController controller;
    private TextButton backBtn;

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
        Set<CookingItemType> learned = new HashSet<>(user.getBackPack().getCookingRecipes());
        final int columns = 4;
        int colCount = 0;

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
                image.setSize(64, 64);
                cell.add(image).width(64).height(64);
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


    public void setErrorMessage(String error) {
        Dialog dialog = new Dialog("Error", skin);
        dialog.text(error);
        dialog.button("OK");
        dialog.show(stage);
    }

    public void setSuccessMessage(String message) {
        Dialog dialog = new Dialog("Success", skin);
        dialog.text(message);
        dialog.button("OK");
        dialog.show(stage);
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
    @Override public void dispose() { if (stage != null) stage.dispose(); }
}
