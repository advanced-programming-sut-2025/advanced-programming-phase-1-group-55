package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum AnimalCommands {
    BUILD_ANIMAL_HOUSE("build\\s+-a\\s+(?<name>.+)\\s+-l\\s+(?<x>\\d+)\\s+(?<y>\\d+)"),
    BUY_ANIMAL("buy\\s+animal\\s+-a\\s+(?<animal>.+)\\s+-n (?<name>.*)"),
    PET_ANIMAL("pet\\s+-n\\s+(?<name>\\S+)"),
    ANIMAL_INFOS("animals"),
    SHEPHERD_ANIMAL("shepherd\\s+animals\\s+-n\\s+(?<name>.+)\\s+-l\\s+(?<x>\\d+)\\s+(?<y>\\d+)"),
    FEED_HAY("feed\\s+hay\\s+-n\\s+(?<name>.+)"),
    PRODUCES("produces"),
    COLLECT_PRODUCES("collect\\s+produces\\s+-n\\s+(?<name>.+)"),
    SELL_ANIMAL("sell\\s+animal\\s+-n\\s+(?<name>.+)");




    private final String pattern;

    AnimalCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
