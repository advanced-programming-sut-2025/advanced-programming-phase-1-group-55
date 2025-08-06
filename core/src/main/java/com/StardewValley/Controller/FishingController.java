package com.StardewValley.Controller;

import com.StardewValley.View.newView.FishingGameScreen;
import com.StardewValley.model.Animal.Fishing.Fish;
import com.StardewValley.model.Animal.Fishing.FishMovementPattern;
import com.StardewValley.model.Animal.Fishing.FishMovementType;
import com.StardewValley.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class FishingController {
    private FishingGameScreen view;
    private Fish fish;
    private float time=0;
    private FishMovementPattern fishMovementPattern= FishMovementType.getRandomType().createPattern();
    public void handleButtonClicked(float delta) {
        float speed = 200;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            view.getSimpleRect().moveY(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            view.getSimpleRect().moveY(-speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            App.gameApp.setScreen(App.currentGameGraphicView);
        }


        float top = view.getBarRect().getY() + view.getBarRect().getHeight() - view.getSimpleRect().getHeight();
        float bottom = view.getBarRect().getY();
        view.getSimpleRect().setY(Math.max(bottom, Math.min(top, view.getSimpleRect().getY())));
        handleFishMovement(top, bottom,delta);
    }
    public  void handleFishMovement(float top, float bottom,float delta) {
        time+=delta;
        if (time>0.5f){
            if (view.getFishRect().collidesWith(view.getSimpleRect())){
                view.getProgressBar().setValue(view.getProgressBar().getValue()+2);
            }else {
                view.getProgressBar().setValue(view.getProgressBar().getValue()-6);
            }
            if (view.getProgressBar().getValue()<=0){
                // todo lose
            } else if (view.getProgressBar().getValue()>=100) {
                //todo won
            }
            time=0;
            view.getFishRect().setY(Math.max(bottom, Math.min(top, view.getFishRect().getY()+7*fishMovementPattern.getNextDeltaY())));
            view.getFishSprite().setPosition(view.getFishRect().getX(), view.getFishRect().getY());
        }
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

    public FishMovementPattern getFishMovementPattern() {
        return fishMovementPattern;
    }

    public void setFishMovementPattern(FishMovementPattern fishMovementPattern) {
        this.fishMovementPattern = fishMovementPattern;
    }
}
