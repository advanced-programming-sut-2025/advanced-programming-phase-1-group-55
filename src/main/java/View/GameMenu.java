package View;

import Controller.GameMenuController;
import model.Map.GameMap;
import model.Map.Tile;
import model.Map.farmBuilder;
import model.Map.mapBuilder;


public class GameMenu extends AppView implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public void check(String input) {
        if (input.equals("1")) {
            farmBuilder fb = new farmBuilder();
            mapBuilder mb=new mapBuilder();
            GameMap Map = fb.mapCreator();
            fb.fillFarmTiles(Map, Map.getFarm1());
            fb.fillFarmTiles(Map, Map.getFarm2());
            fb.fillFarmTiles(Map, Map.getFarm3());
            fb.fillFarmTiles(Map, Map.getFarm4());
            mb.fillOtherTiles(Map);
            System.out.println(Map.printMap());
        }

    }
}
