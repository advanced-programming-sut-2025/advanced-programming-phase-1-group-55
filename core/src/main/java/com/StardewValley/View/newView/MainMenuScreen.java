package com.StardewValley.View.newView;


import com.badlogic.gdx.Screen;
import com.StardewValley.Controller.LoginMenuController;
import com.StardewValley.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {

    private Stage stage;
    private Skin skin=App.skin;




    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);


        Table table = new Table();
        table.setFillParent(true);
        table.center();
        stage.addActor(table);

        Label title = new Label("Main Menu", skin);
        TextButton profileBtn = new TextButton("Enter Profile", skin);
        TextButton avatarBtn = new TextButton("Enter Avatar", skin);
        TextButton gameBtn = new TextButton("Enter Game", skin);
        TextButton logoutBtn = new TextButton("Logout", skin);

        table.add(title).padBottom(40).row();
        table.add(profileBtn).pad(10).row();
        table.add(avatarBtn).pad(10).row();
        table.add(gameBtn).pad(10).row();
        table.add(logoutBtn).pad(10).row();

        profileBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("going to Profile menu");
                App.getGameApp().setScreen(new ProfileMenuScreen());
            }
        });

//        avatarBtn.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("going to Avatar menu");
//                App.getGameApp().setScreen(new AvatarScreen());
//            }
//        });

//        gameBtn.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("going to Game menu");
//                App.getGameApp().setScreen(new GameScreen());
//            }
//        });

        logoutBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("going to Register menu");
                App.getGameApp().setScreen(new RegisterScreen());
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) { stage.getViewport().update(width, height, true); }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }
}
