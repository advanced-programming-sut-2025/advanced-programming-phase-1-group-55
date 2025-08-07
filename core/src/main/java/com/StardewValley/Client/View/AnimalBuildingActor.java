//package com.StardewValley.View.newView;
//
//import com.StardewValley.model.Animal.AnimalBuilding;
//import com.badlogic.gdx.graphics.g2d.Batch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.scenes.scene2d.Actor;
//
//public class AnimalBuildingActor extends Actor {
//    private final AnimalBuilding building;
//    private final TextureRegion region;
//
//    public AnimalBuildingActor(AnimalBuilding building, TextureRegion region) {
//        this.building = building;
//        this.region = region;
//        setBounds(
//            building.getLocation().getX(),
//            building.getLocation().getY(),
//            region.getRegionWidth(),
//            region.getRegionHeight()
//        );
//    }
//
//    @Override
//    public void draw(Batch batch, float parentAlpha) {
//        batch.draw(region, getX(), getY());
//    }
//
//    public AnimalBuilding getBuilding() {
//        return building;
//    }
//}
//
