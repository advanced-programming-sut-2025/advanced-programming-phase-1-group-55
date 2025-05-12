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
        if (AllUsers.get(Username1) == null || AllUsers.get(Username2) == null || AllUsers.get(Username3) == null) {
            return new Result(false, "Username is not correct");
        } else if (Username1 == null) {
            return new Result(false, "Username is empty you should at least add one user");
        }
        //todo agar bishtar az se nam karbari dashtim


        farmBuilder fb = new farmBuilder();
        mapBuilder mb = new mapBuilder();
        GameMap Map = fb.mapCreator();
        fb.fillFarmTiles(Map, Map.getFarm1());
        fb.fillFarmTiles(Map, Map.getFarm2());
        fb.fillFarmTiles(Map, Map.getFarm3());
        fb.fillFarmTiles(Map, Map.getFarm4());
        mb.fillOtherTiles(Map);
        HashMap<String, User> playersInGame = new HashMap<>();
        User Player1 = AllUsers.get(Username1);
        playersInGame.put(Username1, Player1);
        if (Username2 != null) {
            User Player2 = AllUsers.get(Username2);
            playersInGame.put(Username2, Player1);
        }
        if (Username3 != null) {
            User Player3 = AllUsers.get(Username3);
            playersInGame.put(Username3, Player1);
        }


        currentGame = new Game(mainUser, playersInGame, Map);
        return new Result(true, "game has created successfully !");
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
