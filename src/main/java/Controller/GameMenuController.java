package Controller;

import model.App;
import model.Game;
import model.Map.GameMap;
import model.Map.farmBuilder;
import model.Map.mapBuilder;
import model.Result;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;

import static model.App.*;


public class GameMenuController {
    //todo gereftan mazrae va map az player haa va pass dadn be mapbuilder
    public Result newGame(String Username1, String Username2, String Username3) {
        //todo error hash ro bezan

        farmBuilder fb = new farmBuilder();
        mapBuilder mb = new mapBuilder();
        GameMap Map = fb.mapCreator();
        fb.fillFarmTiles(Map, Map.getFarm1());
        fb.fillFarmTiles(Map, Map.getFarm2());
        fb.fillFarmTiles(Map, Map.getFarm3());
        fb.fillFarmTiles(Map, Map.getFarm4());
        mb.fillOtherTiles(Map);
        HashMap<String, User> playersInGame = new HashMap<>();
        currentGame = new Game(mainUser, playersInGame, Map);
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
