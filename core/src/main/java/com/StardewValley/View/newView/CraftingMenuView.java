package com.StardewValley.View.newView;

import com.StardewValley.enums.CraftingItemType;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.StardewValley.Controller.CraftingMenuController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.HashSet;
import java.util.Set;

/**
 * Graphical view for the crafting menu. Presents a list of
 * crafting recipes to the user, distinguishing between learned and
 * locked recipes, and forwards selection events to the controller.
 */
public class CraftingMenuView implements Screen {
    private Stage stage;
    private Table table;
    private final Skin skin = App.skin;
    private final User user;
    private final CraftingMenuController controller;

    public CraftingMenuView(CraftingMenuController controller, User user) {
        this.controller = controller;
        this.user = user;
        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // دستورالعمل‌های یادگرفته‌شده
        Set<CraftingItemType> learned = new HashSet<>(user.getBackPack().getCraftingRecipes());
        for (final CraftingItemType recipe : CraftingItemType.values()) {
            String name = recipe.getProductName().getDisplayName();
            TextButton button = new TextButton(name, skin);
            // قفل بودن recipe
            if (!learned.contains(recipe)) {
                button.setDisabled(true);
                button.getLabel().setColor(Color.GRAY);
            }
            button.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    controller.handleRecipeClicked(recipe);
                }
            });
            table.add(button).width(300).height(50).pad(10).row();
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        if (stage != null) {
            stage.act(delta);
            stage.draw();
        }
    }

    public void setErrorMessage(String error) {
        System.out.println(error);
    }

    public void setSuccessMessage(String message) {
        System.out.println(message);
    }

    // سایر متدهای Screen
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { if (stage != null) stage.dispose(); }
}
