package Controller;

import model.Map.Farm;
import model.Map.GameMap;
import model.Map.farmBuilder;
import model.Result;


public class GameMenuController {
    //todo gereftan mazrae va map az player haa va pass dadn be mapbuilder
    public Result newGame(String Username1, String Username2, String Username3) {
        //todo error hash ro bezan
        farmBuilder fb = new farmBuilder();
        GameMap Map = fb.mapCreator();

        fb.fillTiles(Map, Map.getFarm1());
        fb.fillTiles(Map, Map.getFarm2());
        fb.fillTiles(Map, Map.getFarm3());
        fb.fillTiles(Map, Map.getFarm4());


        return new Result(true, "Map selected succesfully!");
    }

    public Result gameMap(int MapNumber) {
        return null;
    }

    public Result loadGame(String Username1, String Username2, String Username3) {
        return null;
    }

    public Result exitGame(String Username1, String Username2, String Username3) {
        return null;
    }

    public Result deleteGame() {
        return null;
    }

    public Result nextTurn() {
        return null;
    }


}
