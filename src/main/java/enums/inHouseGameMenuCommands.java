package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum inHouseGameMenuCommands {

    ShowLearnedRecipes("crafting show recipes"),
    CraftItem("crafting\\s+craft\\s+(?<itemName>.*)"),
    PlaceItem("place\\s+item\\s+" + "-n\\s+(?<itemName>.*)\\s+" + "-d\\s+(?<direction>\\S+)"),
    CheatAddItem("cheat\\s+add\\s+item\\s+" + "-n\\s+(?<itemName>.*)\\s+" + "-c\\s+(?<count>\\d+)");

    private final String pattern;

    inHouseGameMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
