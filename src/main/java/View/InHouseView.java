package View;

import Controller.MainLocationController;
import enums.MainLocation;
import java.util.regex.Matcher;

public class InHouseView implements AppMenu {
    private final MainGameView mainGameView = new MainGameView();

    @Override
    public void check(String input) {
        if (!MainLocationController.isIn(MainLocation.House)) {
            System.out.println("you are not in a house !");
            return;
        }

        Matcher matcher = null;

//        if() {
//
//        } else {
//
//            mainGameView.check(input);
//        }
    }
}
