package com.StardewValley.Controller;

import com.StardewValley.View.newView.FishingGameScreen;
import com.StardewValley.model.Animal.Fishing.Fish;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class FishingController {
    private FishingGameScreen view;
    private Fish fish;
    public void handleButtonClicked(float delta) {
        float speed = 200;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            view.getSimpleRect().moveY(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            view.getSimpleRect().moveY(-speed * delta);
        }


        float top = view.getBarRect().getY() + view.getBarRect().getHeight() - view.getSimpleRect().getHeight();
        float bottom = view.getBarRect().getY();
        view.getSimpleRect().setY(Math.max(bottom, Math.min(top, view.getSimpleRect().getY())));
    }
    public FishingGameScreen getView() {
        return view;
    }

    public void setView(FishingGameScreen view) {
        this.view = view;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }
}
