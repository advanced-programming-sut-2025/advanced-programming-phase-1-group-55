package Controller;

import enums.mainGameCommands;
import model.App;
import model.Game;
import model.Map.GameMap;
import model.Map.farmBuilder;
import model.Map.mapBuilder;
import model.Result;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;

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
        HashMap<String, User> playersInGame = new HashMap<>();

        User player0 = mainUser;
        User player1 = AllUsers.get(Username1);

        int numberOFPlayers = 2;
        numberOFPlayers++;
        if (Username2 != null) {
            numberOFPlayers++;
            User Player2 = AllUsers.get(Username2);


        }
        if (Username3 != null) {
            numberOFPlayers++;
            User Player3 = AllUsers.get(Username3);

        }
        System.out.println("choose number of map for players : ");
        farmBuilder fb = new farmBuilder();
        int mapNumber;
        for (int i = 0; i < numberOFPlayers; i++) {

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            Matcher chooseMap = mainGameCommands.chooseMap.getMatcher(input);
            if (chooseMap == null) {
                return new Result(false, "incorrect format for map selecting ");
            } else {

                try {
                    mapNumber = Integer.parseInt(chooseMap.group("X"));
                } catch (NumberFormatException e) {
                    return new Result(false, "Invalid map number");

                }
            }
            if (i == 0 && mapNumber == 1) {

                player0.setFarm(fb.getFarm1());
            } else if (i == 1 && mapNumber == 2) {
                player0.setFarm(fb.getFarm2());
            } if (i == 1 && mapNumber == 1) {


                player1.setFarm(fb.getFarm1());
            } else if (i == 1 && mapNumber == 2) {
                player0.setFarm(fb.getFarm2());
            } if (i == 0 && mapNumber == 1) {

                player0.setFarm(fb.getFarm1());
            } else if (i == 1 && mapNumber == 2) {
                player0.setFarm(fb.getFarm2());
            }
            if (i == 0 && mapNumber == 1) {

                player0.setFarm(fb.getFarm1());
            } else if (i == 1 && mapNumber == 2) {
                player0.setFarm(fb.getFarm2());
            }



        }


        mapBuilder mb = new mapBuilder();
        GameMap Map = fb.mapCreator();
        fb.fillFarmTiles(Map, Map.getFarm1());
        fb.fillFarmTiles(Map, Map.getFarm2());
        fb.fillFarmTiles(Map, Map.getFarm3());
        fb.fillFarmTiles(Map, Map.getFarm4());
        mb.fillOtherTiles(Map);


        currentGame = new Game(mainUser, playersInGame, Map);
        return new Result(true, "game has created successfully !");
    }

    public Result gameMap(String MapNumber) {
        int mapNumber;
        try {
            mapNumber = Integer.parseInt(MapNumber);
        } catch (NumberFormatException e) {
            return new Result(false, "Invalid map number");

        }
        if (mapNumber != 1 && mapNumber != 2) {
            return new Result(false, "Invalid map number choose 1 or 2");
        }


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
