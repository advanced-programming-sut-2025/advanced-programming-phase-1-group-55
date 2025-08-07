package com.StardewValley.Common.model.Map;

import com.StardewValley.Common.model.App;
import com.StardewValley.Common.model.Artisan.ArtisanMachine;
import com.StardewValley.Common.model.Item.CollisionRect;
import com.StardewValley.Common.model.NPC.Npc;
import com.StardewValley.Common.model.Store.ShippingBin;
import com.StardewValley.Common.model.Store.Store;
import com.StardewValley.Common.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static com.StardewValley.Common.model.App.currentGameModel;

public class GameMap {

    private Farm farm1;
    private Farm farm2;
    private Farm farm3;
    private Farm farm4;
    private NpcVillage village=new NpcVillage();
    private ArrayList<ArtisanMachine> artisanMachines=new ArrayList<>();
    private static final int WORLD_WIDTH = (int)(1920*4);
    private static final int WORLD_HEIGHT = (int)(1080*4);
    public  ArrayList<Fence> fences = new ArrayList<>();
    public  boolean  canMove(CollisionRect collisionRect) {
        for (Fence fence : fences) {
            if (fence.getCollisionRect().collidesWith(collisionRect)) {
                return false;
            }
        }
        for (Store store:village.getStores().values()){
            if (store.getCollisionRect().collidesWith(collisionRect)) {
                return false;
            }
        }
        for (Npc npc:village.getNpss().values()){
            if (npc.getType().getHouse().getCollisionRect().collidesWith(collisionRect)) {
                return false;
            }
        }
        for (ShippingBin bin:village.getShippingBins()){
            if (bin.getCollisionRect().collidesWith(collisionRect)) {
                return false;
            }
        }
        for (ArtisanMachine artisanMachine:artisanMachines){
            if (artisanMachine.getCollisionRect().collidesWith(collisionRect)) {
                return false;
            }
        }
       if(currentGameModel.getCurrentUser().getFarm().getLake().getCollisionRect().collidesWith(collisionRect)||
           currentGameModel.getCurrentUser().getFarm().getHouse().getCollisionRect().collidesWith(collisionRect)){
           return false;
       }
        for (User user:App.currentGameModel.playersInGame){
            if (user.getCollisionRect().collidesWith(collisionRect)&&!user.getUsername().equals(currentGameModel.currentUser.getUsername())){
                return false;
            }
        }
        if (collisionRect.collidesWith(currentGameModel.currentUser.getFarm().getGreenHouse().getCollisionRect())&&
        !currentGameModel.currentUser.getFarm().getGreenHouse().getRepaired()){
            return false;
        }
        return true;
    }

    public void BuildMap() {
        MapBuilder mapBuilder1 = new MapBuilder();
        mapBuilder1.BuildFences(WORLD_WIDTH, WORLD_HEIGHT,this);


    }
    public void BuildFarm(String map2, String map3, String map4){
        MapBuilder mapBuilder1 = new MapBuilder();
        mapBuilder1.BuildFarms(map2,map3,map4,this,WORLD_WIDTH,WORLD_HEIGHT);
    }
    public void DrawMap(){
        MapBuilder mapBuilder1 = new MapBuilder();
        mapBuilder1.drawFences(this);
        mapBuilder1.drawStores(this);
        mapBuilder1.drawNpcHouses(this);
        mapBuilder1.drawBins(this);
        mapBuilder1.drawArtisans(this);
        mapBuilder1.drawFarms(this);
    }


    public int getWORLD_WIDTH() {
        return WORLD_WIDTH;
    }

    public int getWORLD_HEIGHT() {
        return WORLD_HEIGHT;
    }

    public Farm getFarm1() {
        return farm1;
    }

    public void setFarm1(Farm farm1) {
        this.farm1 = farm1;
    }

    public Farm getFarm2() {
        return farm2;
    }

    public void setFarm2(Farm farm2) {
        this.farm2 = farm2;
    }

    public Farm getFarm3() {
        return farm3;
    }

    public void setFarm3(Farm farm3) {
        this.farm3 = farm3;
    }

    public Farm getFarm4() {
        return farm4;
    }

    public void setFarm4(Farm farm4) {
        this.farm4 = farm4;
    }


    private Map<Location, Character> MiniMap = new HashMap<>();

    public Map<Location, Character> getMiniMap() {
        return MiniMap;
    }

    public void setMiniMap(Map<Location, Character> miniMap) {
        MiniMap = miniMap;
    }

    public NpcVillage getVillage() {
        return village;
    }

    public void setVillage(NpcVillage village) {
        this.village = village;
    }

    public ArrayList<Fence> getFences() {
        return fences;
    }

    public void setFences(ArrayList<Fence> fences) {
        this.fences = fences;
    }

    public ArrayList<ArtisanMachine> getArtisanMachines() {
        return artisanMachines;
    }

    public void setArtisanMachines(ArrayList<ArtisanMachine> artisanMachines) {
        this.artisanMachines = artisanMachines;
    }
}
