package View;

import Controller.GameMenuController;
import enums.Menu;
import model.App;
import model.Game;
import model.Map.*;
import enums.mainGameCommands;

import java.util.regex.Matcher;

import static model.App.*;


public class GameMenu extends AppView implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public void check(String input) {
        Matcher gameNew = mainGameCommands.gameNew.getMatcher(input);
        Matcher chooseMap = mainGameCommands.chooseMap.getMatcher(input);
        if (gameNew != null) {
            //todo inaro az inja bardarim
//            farmBuilder fb = new farmBuilder();
//            mapBuilder mb = new mapBuilder();
//            currentGame.setMap(fb.mapCreator());
//            GameMap map = currentGame.getMap();
//            fb.fillFarmTiles(map, map.getFarm1());
//            fb.fillFarmTiles(map, map.getFarm2());
//            fb.fillFarmTiles(map, map.getFarm3());
//            fb.fillFarmTiles(map, map.getFarm4());
//            mb.fillOtherTiles(map);
//            mb.initializeMapTiles(map);
//            System.out.println(map.printMap(new Location(0, 0), 160, 41));
//            readfile();
//            mainUser = AllUsers.get("arshia");
//            mainUser.moveTo(13, 3, map.tiles);
//            currentMenu = Menu.MainGameMenu;

        } else if (chooseMap != null) {


        }

    }
}
