package Controller;

import enums.Menu;
import enums.mainGameCommands;
import model.App;
import model.Game;
import model.Map.Farm;
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
    public void setTileOwner(User user, Farm farm,GameMap map){
        System.out.println(farm.getLocation().toString());
        System.out.println(farm.getHeight());
        System.out.println(farm.getWidth());
        for(int i=farm.getLocation().getY()-1;i<farm.getWidth()+farm.getLocation().getY()-2;i++){
            for (int j=farm.getLocation().getX()-1;j< farm.getHeight()+farm.getLocation().getX()-2;j++){
                System.out.println(i+"  "+j);
                map.tiles[i][j].setOwner(user);
            }
        }
    }
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
        mapBuilder mb = new mapBuilder();
        GameMap Map = fb.mapCreator();
        fb.fillFarmTiles(Map, Map.getFarm1());
        fb.fillFarmTiles(Map, Map.getFarm2());
        fb.fillFarmTiles(Map, Map.getFarm3());
        fb.fillFarmTiles(Map, Map.getFarm4());
        mb.fillOtherTiles(Map);
        User Player0 = mainUser;
        User Player1 = AllUsers.get(Username1);
        User Player2 = null;
        User Player3 = null;
        int numberOFPlayers = 1;
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
            String input = scanner.nextLine();
            Matcher chooseMap = mainGameCommands.chooseMap.getMatcher(input);
            if (chooseMap == null) {
                return new Result(false, "incorrect format for map selecting ");
            } else {

                try {
                    mapNumber = Integer.parseInt(chooseMap.group("X"));
                    if (mapNumber > 2 || mapNumber < 1) {
                        return new Result(false, "Invalid map number");
                    }
                } catch (Exception e) {
                    return new Result(false, "Invalid map number");

                }
            }
            if (i == 0 && mapNumber == 1) {
                Player0.setFarm(fb.getFarm1());
                Player0.setLocation(Player0.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player0,Player0.getFarm(),Map);
            } else if (i == 0) {
                Player0.setFarm(fb.getFarm2());
                Player0.setLocation(Player0.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player0,Player0.getFarm(),Map);
            }
            if (i == 1 && mapNumber == 1) {

                Player1.setFarm(fb.getFarm1());
                Player1.setLocation(Player1.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player1,Player1.getFarm(),Map);

            } else if (i == 1) {
                System.out.println("ooooooookkkkkk");
                Player1.setFarm(fb.getFarm2());
                Player1.setLocation(Player1.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player1,Player1.getFarm(),Map);
            }
            if (i == 2 && mapNumber == 1) {

                assert Player2 != null;
                Player2.setFarm(fb.getFarm1());
                Player2.setLocation(Player2.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player2,Player2.getFarm(),Map);
            } else if (i == 2) {
                assert Player2 != null;
                Player2.setFarm(fb.getFarm2());
                Player2.setLocation(Player2.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player2,Player2.getFarm(),Map);
            }
            if (i == 3 && mapNumber == 1) {

                assert Player3 != null;
                Player3.setFarm(fb.getFarm1());
                Player3.setLocation(Player3.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player3,Player3.getFarm(),Map);
            } else if (i == 3) {
                assert Player3 != null;
                Player3.setFarm(fb.getFarm2());
                Player3.setLocation(Player3.getFarm().getLocation().changeLocation(1, 1));
                setTileOwner(Player3,Player3.getFarm(),Map);
            }


        }


        currentGame = new Game(mainUser, playersInGame, Map);
        currentMenu = Menu.MainGameMenu;
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
