package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public enum CropMenuCommands {
//    ShowAllCrops("show all crops"),
    ShowCropByName("show crop (?<name>[\\w\\s]+)");
//    ShowCropsBySeason("show crops in (?<season>[a-zA-Z]+)");

    private final String pattern;

    CropMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}