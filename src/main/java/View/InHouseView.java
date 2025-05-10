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

        // 🏡 دستورات خاص خانه
        if ((matcher = InHouseCommands.sleep.getMatcher(input)) != null) {
            System.out.println("شما به رختخواب رفتید... روز جدید آغاز شد!");
            // مثلاً می‌تونه روز را در مدل جلو ببرد

        } else if ((matcher = InHouseCommands.changeClothes.getMatcher(input)) != null) {
            System.out.println("لباس شما با موفقیت تغییر کرد.");

        } else if ((matcher = InHouseCommands.saveGame.getMatcher(input)) != null) {
            System.out.println("بازی ذخیره شد.");

        } else {
            // اگر دستور خاص خانه نبود، بفرست به MainGameView برای بررسی دستورات عمومی
            mainGameView.check(input);
        }
    }
}
