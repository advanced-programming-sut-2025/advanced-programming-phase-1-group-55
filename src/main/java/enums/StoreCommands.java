package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum StoreCommands {
    showAllProducts("^\\s*show\\s+all\\s+products\\s*$"),
    showAllAvailableProducts("^\\s*show\\s+all\\s+available\\s+products\\s*$"),
    purchaseItem("^\\s*purchase\\s+(?<name>.+?)(?=\\s+-n\\s+\\S+)?(?:\\s+-n\\s+(?<count>\\S+))?\\s*$"),
    cheatMoney("^\\s*cheat\\s+add\\s+(?<count>\\S+)\\s+dollars\\s*$"),
    sellItem("^\\s*sell\\s+(?<name>.+?)(?=\\s+-n\\s+\\S+)?(?:\\s+-n\\s+(?<count>\\S+))?\\s*$");

    StoreCommands(String pattern) {
        this.pattern = pattern;
    }

    private final String pattern;
    public Matcher getMatcher(String input) {
        java.util.regex.Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
