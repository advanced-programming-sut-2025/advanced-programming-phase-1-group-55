package com.StardewValley.model.Animal;

import com.StardewValley.enums.AssetManager;
import com.StardewValley.model.App;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.Map.Location;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class AnimalBuilding {
    private final FarmBuildingType farmBuildingType;
    private final int cost;
    private final int capacity;
    private final int width;
    private final int height;
    private Location location;
    private CollisionRect collisionRect;
    private Sprite sprite;
    private ArrayList<Animal> animals = new ArrayList<>();



    public AnimalBuilding(Location location, FarmBuildingType type) {
        this.farmBuildingType = type;
        this.cost = type.getPrice();
        this.capacity = type.getCapacity();
        this.width = type.getSize().get(0);
        this.height = type.getSize().get(1);
        this.location = new Location(location.getX(), location.getY());
        float tileW = 64;
        float tileH = 64;
        this.collisionRect = new CollisionRect(location.getX(), location.getY(),
            width * tileW, height * tileH);
        if (type.getName().equalsIgnoreCase("Barn")) {
            this.sprite = new Sprite(AssetManager.BARN.getTexture());
        } else if (type.getName().equalsIgnoreCase("Coop")) {
            this.sprite = new Sprite(AssetManager.COOP.getTexture());
        } else {
            this.sprite = new Sprite(AssetManager.BARN.getTexture());
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

//    public AnimalBuilding findHomeBuildingFor(Animal animal) {
//        for (AnimalBuilding b : App.mainUser.getFarmBuildings()) {
//            if (b.getAnimals().contains(animal)) return b;
//        }
//
//
//        var allowed = animal.getAnimalType().getBuildings();
//
//        AnimalBuilding fallback = null;
//        for (AnimalBuilding b : App.mainUser.getFarmBuildings()) {
//            if (allowed.contains(b.getFarmBuildingType())) {
//                if (b.getAnimals().size() < b.getCapacity()) return b;
//                if (fallback == null) fallback = b;
//            }
//        }
//        return fallback;
//    }



    public FarmBuildingType getFarmBuildingType() { return farmBuildingType; }
    public Location getLocation() { return location; }
    public CollisionRect getCollisionRect() { return collisionRect; }
    public Sprite getSprite() { return sprite; }
    public int getCapacity() { return capacity; }
}
