package model.Map;

import java.util.HashMap;
import java.util.Map;


public class GameMap {
    private Map<Location, Tile> pointsOfTheMap=new HashMap<>();
    private Map<Location, Character> MiniMap=new HashMap<>();
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
}
