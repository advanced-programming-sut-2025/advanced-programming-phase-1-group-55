package model.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMap {
    public Tile[][] tiles = new Tile[41][160];

    //    private ArrayList<Farm> farms=new ArrayList<>();
    private Farm farm1;//baray nafar aval
    private Farm farm2;
    private Farm farm3;
    private Farm farm4;

    //todo npc village add beshe!!
    public GameMap(Farm farm1, Farm farm2, Farm farm3, Farm farm4) {

        farm2.setLocation(new Location(farm2.getLocation().getY() + 21, farm2.getLocation().getX()));
        farm2.getQuarry().changeLocation(21, 0);
        farm2.getLake().changeLocation(21, 0);
        farm2.getGreenHouse().changeLocation(21, 0);
        farm2.getHouse().changeLocation(21, 0);
        farm3.setLocation(new Location(farm3.getLocation().getY(), farm3.getLocation().getX() + 140));
        farm3.getQuarry().changeLocation(0, 140);
        farm3.getLake().changeLocation(0, 140);
        farm3.getGreenHouse().changeLocation(0, 140);
        farm3.getHouse().changeLocation(0, 140);
        farm4.setLocation(new Location(farm4.getLocation().getY() + 21, farm4.getLocation().getX() + 140));
        farm4.getQuarry().changeLocation(21, 140);
        farm4.getLake().changeLocation(21, 140);
        farm4.getGreenHouse().changeLocation(21, 140);
        farm4.getHouse().changeLocation(21, 140);
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
    public String printMap(){
        StringBuilder map=new StringBuilder();
        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 160; j++) {
                Tile t = tiles[i][j];
                if (t != null) {
                    map.append(t.getMohtaviat());
                }
                else {
                    map.append(".");
                }
            }
            map.append("\n");
        }
        return map.toString();
    }
}
