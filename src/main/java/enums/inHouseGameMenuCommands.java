package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum inHouseGameMenuCommands {

    ShowLearnedCratingRecipes("^\\s*crafting\\s+show\\s+recipes\\s*$"),
    CHEAT_ADD_CRAFTING_RECIPE("cheat\\s+add\\s+crafting\\s+recipe\\s+(?<recipeName>.*)"),
    CraftItem("crafting\\s+craft\\s+(?<itemName>.*)"),
    PlaceItem("place\\s+item\\s+-n\\s+(?<itemName>.*)\\s+-d\\s+(?<direction>\\S+)"),
    CheatAddItem("cheat\\s+add\\s+item\\s+" + "-n\\s+(?<itemName>.*)\\s+" + "-c\\s+(?<count>\\d+)"),
    PutInRefrigerator("cooking\\s+refrigerator\\s+put\\s+(?<item>.*)"),
    PickFromRefrigerator("cooking\\s+refrigerator\\s+pick\\s+(?<item>.*)"),
    ShowLearnedCookingRecipes("cooking\\s+show\\s+recipes"),
    CookItem("cooking\\s+prepare\\s+(?<recipeName>.*)"),
    Eat("eat\\s+(?<foodName>.*)");

    private final String pattern;

    inHouseGameMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
