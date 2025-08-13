package com.StardewValley.View.newView;

import com.StardewValley.model.Animal.Animal;
import com.StardewValley.model.Animal.AnimalBuilding;
import com.StardewValley.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class AnimalBuildingMenuView implements Screen {
//    private final AnimalBuilding building;
    private final Stage stage;
    private final Skin skin = App.skin;

    public AnimalBuildingMenuView() {
//        this.building = building;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        setupUI();
    }

    private void setupUI() {
        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        Table menuTable = new Table();
        menuTable.defaults().width(500).pad(10);

        Label title = new Label("My Animals", skin);
        menuTable.add(title).center().padBottom(20).row();

        if (App.mainUser == null || App.mainUser.getMyAnimals() == null || App.mainUser.getMyAnimals().isEmpty()) {
            Label noAnimals = new Label("You have no animals yet.", skin);
            menuTable.add(noAnimals).center().row();
        } else {
            for (Animal animal : App.mainUser.getMyAnimals()) {
                Table animalRow = new Table();

                final Label animalInfo = new Label(animal.getInfo(), skin);
                animalInfo.setWrap(true);
                animalInfo.setWidth(400);

                TextButton petButton = new TextButton("Pet", skin);
                petButton.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        animal.pet();
                        animalInfo.setText(animal.getInfo());
                        showTemporaryPopup("Petting...");
                    }
                });

                TextButton feedButton = new TextButton("Feed", skin);
                feedButton.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        animal.feed();
                        animalInfo.setText(animal.getInfo());
                        showTemporaryPopup("Feeding...");
                    }
                });

                TextButton shepherdButton = new TextButton("Shepherd", skin);
                shepherdButton.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        animal.goOut();

                        AnimalBuilding home = findHomeBuildingFor(animal);
                        if (home != null && App.currentGameGraphicView instanceof MainGameGraphicView view) {
                            view.placeAnimalNearBuilding(animal, home);
                        } else if (App.currentGameGraphicView instanceof MainGameGraphicView view) {
                            view.showError("No suitable building found.", 1.2f);
                        }

                        animalInfo.setText(animal.getInfo());
                    }
                });



//                animalRow.defaults().padRight(20);
                animalRow.add(animalInfo).left().padRight(10).width(350f);
                animalRow.add(petButton).right().width(90f).padRight(30);
                animalRow.add(feedButton).right().width(90f).padRight(30);
                animalRow.add(shepherdButton).right().width(90f);
                menuTable.add(animalRow).left().row();
            }
        }

        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getGameApp().setScreen(App.currentGameGraphicView);
            }
        });

        menuTable.add(backButton).center().padTop(30).row();

        ScrollPane scrollPane = new ScrollPane(menuTable, skin);
        scrollPane.setFadeScrollBars(false);
        rootTable.add(scrollPane).expand().fill().pad(20);
    }

    private AnimalBuilding findHomeBuildingFor(Animal animal) {
        if (animal == null || App.mainUser == null || App.mainUser.getFarmBuildings() == null) {
            return null;
        }
        var buildings = App.mainUser.getFarmBuildings();
        if (buildings.isEmpty()) {
            System.out.println("[Shepherd] No buildings for player.");
            return null;
        }
        for (AnimalBuilding building : buildings) {
            if (building.getAnimals() != null && building.getAnimals().contains(animal)) {
                return building;
            }
        }
        var allowed = animal.getAnimalType().getBuildings();
        AnimalBuilding fallback = null;
        for (AnimalBuilding building : buildings) {
            if (allowed.contains(building.getFarmBuildingType())) {
                if (building.getAnimals().size() < building.getCapacity()) {
                    return building;
                }
                if (fallback == null) fallback = building;
            }
        }
        if (fallback != null) return fallback;
        String need = animal.getAnimalType().getAnimalType().name();
        for (AnimalBuilding b : buildings) {
            if (b.getFarmBuildingType().name().contains(need)) {
                return b;
            }
        }
        System.out.println("[Shepherd] Falling back to first building.");
        return buildings.get(0);
    }

    private void showTemporaryPopup(String message) {
        final Dialog dialog = new Dialog("", skin);
        dialog.text(message);
        dialog.setModal(false);
        dialog.setMovable(false);
        dialog.show(stage);

        dialog.setPosition(
            stage.getWidth() / 2f - dialog.getWidth() / 2f,
            stage.getHeight() / 2f - dialog.getHeight() / 2f
        );

        com.badlogic.gdx.utils.Timer.schedule(new com.badlogic.gdx.utils.Timer.Task() {
            @Override
            public void run() {
                dialog.remove();
            }
        }, 2f);
    }








    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }
}
