package enums;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public enum ForagingCropsCommands {
    showForagingCropsByName ("show foraging crop (?<name>[\\w\\s]+)");

    private final String pattern;
    ForagingCropsCommands(String pattern) {
        this.pattern = pattern;
    }
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}
