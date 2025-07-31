package com.StardewValley.View.newView;

import com.StardewValley.enums.CraftingItemType;
import com.StardewValley.Controller.CraftingMenuController;
import com.StardewValley.model.App;
import com.StardewValley.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import java.util.HashSet;
import java.util.Set;

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

        Set<CraftingItemType> learned = new HashSet<>(user.getBackPack().getCraftingRecipes());

        for (final CraftingItemType recipe : CraftingItemType.values()) {
            String itemName = recipe.getProductName().name();
            // تبدیل enum به فرمت فایل: Cherry_Bomb.png
            String[] parts = itemName.split("_");
            StringBuilder fileNameBuilder = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                String part = parts[i].toLowerCase();
                fileNameBuilder.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1));
                if (i < parts.length - 1) fileNameBuilder.append("_");
            }
            String fileName = fileNameBuilder.toString() + ".png";
            String imagePath = "Crafting/" + fileName;

            boolean isUnlocked = learned.contains(recipe);

            Table cell = new Table(); // جدول کوچک برای هر آیتم

            // اگر تصویر وجود دارد، آن‌را لود می‌کنیم؛ وگرنه می‌توانیم از تصویر پیش‌فرض یا متن خالی استفاده کنیم
            com.badlogic.gdx.files.FileHandle handle = Gdx.files.internal(imagePath);
            if (handle.exists()) {
                Texture texture = new Texture(handle);
                Image image = new Image(texture);
                image.setSize(64, 64);
                cell.add(image).width(64).height(64);
                cell.row();

                // نام قابل نمایش آیتم
                String displayName = recipe.getProductName().getDisplayName();
                Label label = new Label(displayName, skin);
                cell.add(label).padTop(5);

                // اگر recipe قفل است، تصویر و متن را خاکستری کنید
                if (!isUnlocked) {
                    image.setColor(Color.GRAY);
                    label.setColor(Color.GRAY);
                }

                // Listener برای کلیک روی آیتم
                cell.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (isUnlocked) {
                            controller.handleRecipeClicked(recipe);
                        }
                    }
                });
            } else {
                // اگر تصویر وجود ندارد، فقط دکمه متنی می‌سازیم
                String displayName = recipe.getProductName().getDisplayName();
                TextButton txtBtn = new TextButton(displayName, skin);
                if (!isUnlocked) {
                    txtBtn.setDisabled(true);
                    txtBtn.getLabel().setColor(Color.GRAY);
                }
                txtBtn.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        controller.handleRecipeClicked(recipe);
                    }
                });
                // به‌جای cell، دکمه متنی را به جدول اصلی اضافه می‌کنیم
                table.add(txtBtn).width(120).height(50).pad(10);
                // بعد از افزودن دکمه به جدول اصلی، ادامه می‌دهیم
                continue;
            }

            // افزودن جدول کوچک به جدول اصلی
            table.add(cell).pad(10);

            // می‌توانید تعداد ستون‌ها در هر ردیف را کنترل کنید
            // مثلاً 4 ستون در هر ردیف:
             if ((recipe.ordinal() + 1) % 4 == 0) table.row();
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

    // متدهای دیگر (setErrorMessage و setSuccessMessage و ... ) مثل قبل باقی می‌مانند
    public void setErrorMessage(String error) {
        System.out.println(error);
    }

    public void setSuccessMessage(String message) {
        System.out.println(message);
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { if (stage != null) stage.dispose(); }
}
