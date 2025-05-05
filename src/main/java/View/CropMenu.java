//package View;
//
//import Controller.CropController;
//import enums.CropMenuCommands;
//import java.util.regex.Matcher;
//
//public class CropMenu implements AppMenu {
//    private final CropController controller = new CropController();
//
//
//
//    @Override
//    public void check(String input) {
//
//        Matcher matcher;
//
//         if ((matcher = CropMenuCommands.ShowCropByName.getMatcher(input)) != null) {
//            System.out.println(controller.getCropByName(matcher.group("name")));
//        }  else {
//            System.out.println("invalid command!");
//        }
//    }
//
//
//}