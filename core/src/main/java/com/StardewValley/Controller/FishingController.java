package com.StardewValley.Controller;

import com.StardewValley.View.newView.FishingGameScreen;
import com.StardewValley.model.Animal.Fishing.Fish;

public class FishingController {
    private FishingGameScreen view;
    private Fish fish;
    public void handleButtonClicked() {

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
