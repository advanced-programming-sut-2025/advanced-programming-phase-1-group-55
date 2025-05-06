package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ForagingTreesCommands {
    showForagingTreesByName ("show foraging tree (?<name>[\\w\\s]+)");

    private final String pattern;
    ForagingTreesCommands(String pattern) {
        this.pattern = pattern;
    }
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
