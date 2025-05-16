package model.Map;

import enums.AnsiColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static model.App.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static model.App.currentGame;

public class GameMap {
    public Tile[][] tiles = new Tile[41][160];

    private Farm farm1;//baray nafar aval
    private Farm farm2;
    private Farm farm3;
    private Farm farm4;
    private NpcVillage village;

    public GameMap(Farm farm1, Farm farm2, Farm farm3, Farm farm4, NpcVillage village) {

        farm2.setLocation(new Location(farm2.getLocation().getY() + 21, farm2.getLocation().getX()));
        farm2.getQuarry().getLocation().changeLocation(21, 0);
        farm2.getLake().getLocation().changeLocation(21, 0);
        farm2.getGreenHouse().getLocation().changeLocation(21, 0);
        farm2.getHouse().getLocation().changeLocation(21, 0);
        farm3.setLocation(new Location(farm3.getLocation().getY(), farm3.getLocation().getX() + 140));
        farm3.getQuarry().getLocation().changeLocation(0, 140);
        farm3.getLake().getLocation().changeLocation(0, 140);
        farm3.getGreenHouse().getLocation().changeLocation(0, 140);
        farm3.getHouse().getLocation().changeLocation(0, 140);
        farm4.setLocation(new Location(farm4.getLocation().getY() + 21, farm4.getLocation().getX() + 140));
        farm4.getQuarry().getLocation().changeLocation(21, 140);
        farm4.getLake().getLocation().changeLocation(21, 140);
        farm4.getGreenHouse().getLocation().changeLocation(21, 140);
        farm4.getHouse().getLocation().changeLocation(21, 140);
        this.farm1 = farm1;
        this.farm2 = farm2;
        this.farm3 = farm3;
        this.farm4 = farm4;
        this.village = village;

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
                if (j == currentGame.currentUser.getLocation().getX() && i == currentGame.currentUser.getLocation().getY()) {
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
}
