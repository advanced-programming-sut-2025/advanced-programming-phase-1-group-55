package com.StardewValley.model.Map;

import com.StardewValley.enums.AnsiColor;
import com.StardewValley.model.Artisan.ArtisanMachine;
import com.StardewValley.model.Item.CollisionRect;
import com.StardewValley.model.NPC.Npc;
import com.StardewValley.model.Store.ShippingBin;
import com.StardewValley.model.Store.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static com.StardewValley.model.App.currentGameModel;

public class GameMap {
    public Tile[][] tiles = new Tile[41][160];

    private Farm farm1;//baray nafar aval
    private Farm farm2;
    private Farm farm3;
    private Farm farm4;
    private NpcVillage village=new NpcVillage();
    private ArrayList<ArtisanMachine> artisanMachines=new ArrayList<>();
    private static final int WORLD_WIDTH = (int)(1920*4);
    private static final int WORLD_HEIGHT = (int)(1080*4);
    public  ArrayList<Fence> fences = new ArrayList<>();


    public GameMap(Farm farm1, Farm farm2, Farm farm3, Farm farm4, NpcVillage village) {


    }
    //todo in constructor bade inke map choose zade shod ,bardaashte beshe
    public GameMap() {

    }

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
        if (farm1.getLake().getCollisionRect().collidesWith(collisionRect)||
            farm1.getHouse().getCollisionRect().collidesWith(collisionRect)) {
            return false;
        }
        return true;
    }

    public void BuildMap() {
        MapBuilder mapBuilder1 = new MapBuilder();
        mapBuilder1.BuildFences(WORLD_WIDTH, WORLD_HEIGHT,this);


    }
    public void BuildFarm(String map1,String map2, String map3, String map4){
        MapBuilder mapBuilder1 = new MapBuilder();
        mapBuilder1.BuildFarms(map1,map2,map3,map4,this,WORLD_WIDTH,WORLD_HEIGHT);
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

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
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

    private Map<Location, Tile> pointsOfTheMap = new HashMap<>();
    private Map<Location, Character> MiniMap = new HashMap<>();

    public Map<Location, Character> getMiniMap() {
        return MiniMap;
    }

    public void setMiniMap(Map<Location, Character> miniMap) {
        MiniMap = miniMap;
    }

    public Map<Location, Tile> getPointsOfTheMap() {
        return pointsOfTheMap;
    }

    public void setPointsOfTheMap(Map<Location, Tile> pointsOfTheMap) {
        this.pointsOfTheMap = pointsOfTheMap;
    }

    public NpcVillage getVillage() {
        return village;
    }

    public void setVillage(NpcVillage village) {
        this.village = village;
    }

    public AnsiColor colorOfTile(String item) {
        AnsiColor color = AnsiColor.RESET;
        color = switch (item) {
            case "W" -> AnsiColor.BG_BLUE;
            case "^" -> AnsiColor.BG_BRIGHT_BLACK;
            case "h" -> AnsiColor.BG_BRIGHT_PURPLE;
            case "g" -> AnsiColor.BG_OLIVE_GREEN;
            case "#" -> AnsiColor.BG_ORANGE;
            case "=" -> AnsiColor.BG_RED;
            case "T" -> AnsiColor.BG_BROWN;
            case "0" -> AnsiColor.BG_BRIGHT_WHITE;
            case "&" -> AnsiColor.BRIGHT_GREEN;
            case "*" -> AnsiColor.GREEN;
            case "Z" -> AnsiColor.BROWN;
            case "@" -> AnsiColor.BG_BRIGHT_YELLOW;
            default -> color;
        };
        return color;
    }

    public String printMap(Location start, int sizex, int sizey) {
        StringBuilder map = new StringBuilder();
        for (int i = max(start.getY(), 0); i < min(sizey + max(start.getY(), 0), 41); i++) {
            for (int j = max(start.getX(), 0); j < min(sizex + max(start.getX(), 0), 160); j++) {
                Tile t = tiles[i][j];
                if (j == currentGameModel.currentUser.getLocation().getX() && i == currentGameModel.currentUser.getLocation().getY()) {
                    map.append(AnsiColor.RED).append("P").append(AnsiColor.RESET);
                    continue;

                }
                if (t != null) {
                    AnsiColor color = colorOfTile(t.getMohtaviat());
                    map.append(color).append(t.getMohtaviat()).append(AnsiColor.RESET);
                } else {
                    map.append(AnsiColor.PINK).append(".").append(AnsiColor.RESET);
                }

            }
            map.append("\n");
        }
        return map.toString();
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
