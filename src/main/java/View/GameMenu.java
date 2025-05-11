package View;

import Controller.GameMenuController;
import model.Map.GameMap;
import model.Map.Tile;
import model.Map.farmBuilder;

import java.util.Scanner;

import static model.Map.GameMap.*;


public class GameMenu extends AppView implements AppMenu {
    GameMenuController controller = new GameMenuController();

    @Override
    public void check(String input) {
        if (input.equals("1")) {
            farmBuilder fb = new farmBuilder();
            GameMap Map = fb.mapCreator();
            fb.fillTiles(Map, Map.getFarm1());
            fb.fillTiles(Map, Map.getFarm2());
            fb.fillTiles(Map, Map.getFarm3());
            fb.fillTiles(Map, Map.getFarm4());
            for (int i = 0; i < 40; i++) {          // پیمایش ردیف‌ها
                for (int j = 0; j < 70; j++) {   // پیمایش ستون‌ها
                    Tile t = Map.tiles[i][j];
                    if (t != null) {

                        System.out.print(t.getMohtaviat());
                    }
                    else {
                        System.out.print(".");
                    }
                }
                System.out.println();                         // بعد از هر ردیف یک خط جدید
            }
        }

    }
}
