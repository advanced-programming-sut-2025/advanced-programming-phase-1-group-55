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
        farmBuilder fb = new farmBuilder();

        User Player0 = mainUser;
        User Player1 = AllUsers.get(Username1);
        User Player2 = null;
        User Player3 = null;
        int numberOFPlayers = 2;
        numberOFPlayers++;
        if (Username2 != null) {
            numberOFPlayers++;
            Player2 = AllUsers.get(Username2);


        }
        if (Username3 != null) {
            numberOFPlayers++;
            Player3 = AllUsers.get(Username3);

        }
        System.out.println("choose number of map for players : ");
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

                Player0.setFarm(fb.getFarm1());
            } else if (i == 1 && mapNumber == 2) {
                Player0.setFarm(fb.getFarm2());
            }
            if (i == 1 && mapNumber == 1) {


                Player1.setFarm(fb.getFarm1());
            } else if (i == 1 && mapNumber == 2) {
                Player1.setFarm(fb.getFarm2());
            }
            if (i == 2 && mapNumber == 1) {

                assert Player2 != null;
                Player2.setFarm(fb.getFarm1());
            } else if (i == 2 && mapNumber == 2) {
                assert Player2 != null;
                Player2.setFarm(fb.getFarm2());
            }
            if (i == 3 && mapNumber == 1) {

                assert Player3 != null;
                Player3.setFarm(fb.getFarm1());
            } else if (i == 3 && mapNumber == 2) {
                assert Player3 != null;
                Player3.setFarm(fb.getFarm2());
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
