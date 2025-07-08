package com.StardewValley.model.Artisan;

import com.StardewValley.model.Item.Item;

public class ArtisanMachine extends Item {
    private final ArtisanMachineType artisanType;
    private int lastStartedToWork = 0;

    public ArtisanMachine(ArtisanMachineType artisanType) {
        super(artisanType.getType());
        this.artisanType = artisanType;
    }

    public ArtisanMachineType getArtisanType() {
        return artisanType;
    }

    public int getLastStartedToWork() {
        return lastStartedToWork;
    }

    public void setLastStartedToWork(int lastStartedToWork) {
        this.lastStartedToWork = lastStartedToWork;
    }
}
