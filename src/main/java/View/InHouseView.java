package View;

import model.App;
import model.Map.MainLocation;
import java.util.regex.Matcher;

public class InHouseView implements AppMenu {
    private final MainGameView mainGameView = new MainGameView();

    @Override
    public void check(String input) {
        if (!App.currentGame.currentUser.getMainLocation().equals(MainLocation.House)) {
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
