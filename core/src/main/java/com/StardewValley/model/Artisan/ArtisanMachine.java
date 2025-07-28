package com.StardewValley.model.Artisan;

import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Item.Item;
import com.StardewValley.model.User;

public class ArtisanMachine extends Item {
    private final ArtisanMachineType artisanType;
    private int lastStartedToWork = 0;
    private User owner;
    private CollisionRect collisionRect;

    public ArtisanMachine(ArtisanMachineType artisanType, User owner, CollisionRect collisionRect) {
        super(artisanType.getType());
        this.artisanType = artisanType;
        this.owner = owner;
        this.collisionRect = collisionRect;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
