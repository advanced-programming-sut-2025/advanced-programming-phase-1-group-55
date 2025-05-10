package model.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private Tile[][] map = new Tile[40][70];
    //    private ArrayList<Farm> farms=new ArrayList<>();
    private Farm farm1;
    private Farm farm2;
    private Farm farm3;
    private Farm farm4;

    public GameMap(Farm farm1, Farm farm2, Farm farm3, Farm farm4) {
        farm2.setLocation(new Location(farm2.getLocation().getY() + 20, farm2.getLocation().getX()));
        farm3.setLocation(new Location(farm3.getLocation().getY(), farm3.getLocation().getX() + 50));
        farm4.setLocation(new Location(farm4.getLocation().getY() + 20, farm4.getLocation().getX() + 50));
        this.farm1 = farm1;
        this.farm2 = farm2;
        this.farm3 = farm3;
        this.farm4 = farm4;

    }

    private NpcVillage village = new NpcVillage();
    private char[][] miniMap = new char[40][70];
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


    public Tile[][] getMap() {
        return map;
    }

    public void setMap(Tile[][] map) {
        this.map = map;
    }

    public void setMiniMap(char[][] miniMap) {
        this.miniMap = miniMap;
    }

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public void setFarms(ArrayList<Farm> farms) {
        this.farms = farms;
    }

    public NpcVillage getVillage() {
        return village;
    }

    public void setVillage(NpcVillage village) {
        this.village = village;
    }
}
