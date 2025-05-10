package model.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMap {
    public Tile[][] tiles = new Tile[80][80];

    //    private ArrayList<Farm> farms=new ArrayList<>();
    private Farm farm1;//baray nafar aval
    private Farm farm2;
    private Farm farm3;
    private Farm farm4;

    //todo npc village add beshe!!
    public GameMap(Farm farm1, Farm farm2, Farm farm3, Farm farm4) {
        farm2.setLocation(new Location(farm2.getLocation().getY() + 20, farm2.getLocation().getX()));
        farm2.getQuarry().changeLocation(20, 0);
        farm2.getLake().changeLocation(20, 0);
        farm2.getGreenHouse().changeLocation(20, 0);
        farm2.getHouse().changeLocation(20, 0);
        farm3.setLocation(new Location(farm3.getLocation().getY(), farm3.getLocation().getX() + 50));
        farm3.getQuarry().changeLocation(0, 50);
        farm3.getLake().changeLocation(0, 50);
        farm3.getGreenHouse().changeLocation(0, 50);
        farm3.getHouse().changeLocation(0, 50);
        farm4.setLocation(new Location(farm4.getLocation().getY() + 20, farm4.getLocation().getX() + 50));
        farm4.getQuarry().changeLocation(20, 50);
        farm4.getLake().changeLocation(20, 50);
        farm4.getGreenHouse().changeLocation(20, 50);
        farm4.getHouse().changeLocation(20, 50);
        this.farm1 = farm1;
        this.farm2 = farm2;
        this.farm3 = farm3;
        this.farm4 = farm4;

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


    public void setMiniMap(char[][] miniMap) {
        this.miniMap = miniMap;
    }


    public NpcVillage getVillage() {
        return village;
    }

    public void setVillage(NpcVillage village) {
        this.village = village;
    }
}
