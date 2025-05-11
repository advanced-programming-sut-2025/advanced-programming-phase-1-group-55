package View;

import Controller.GameMenuController;
import model.Map.GameMap;
import model.Map.Tile;
import model.Map.farmBuilder;
import model.Map.mapBuilder;

import static model.Game.*;


public class GameMenu extends AppView implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public void check(String input) {
        if (input.equals("1")) {
            farmBuilder fb = new farmBuilder();
            mapBuilder mb = new mapBuilder();
            GameMap Map = fb.mapCreator();
            fb.fillFarmTiles(Map, Map.getFarm1());
            fb.fillFarmTiles(Map, Map.getFarm2());
            fb.fillFarmTiles(Map, Map.getFarm3());
            fb.fillFarmTiles(Map, Map.getFarm4());
            mb.fillOtherTiles(Map);
            mb.initializeMapTiles(Map);
            System.out.println(Map.printMap());
            readfile();
            mainUser = AllUsers.get("arshiaF2");
            mainUser.moveTo(10, 10, Map.tiles);
        }

    }
}
